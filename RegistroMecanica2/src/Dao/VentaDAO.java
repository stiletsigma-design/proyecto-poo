package Dao;

import Conexion.ConexionDB;
import Modelo.Venta;
import Modelo.DetalleVenta;

import java.sql.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class VentaDAO {

    ConexionDB cn = new ConexionDB();
    DetalleVentaDAO detalleDAO = new DetalleVentaDAO();

    // Validar y calcular el total
    private BigDecimal calcularTotal(List<DetalleVenta> detalles) {

        if (detalles == null || detalles.isEmpty()) {
            throw new IllegalArgumentException("La venta debe tener productos.");
        }

        BigDecimal total = BigDecimal.ZERO;

        for (DetalleVenta d : detalles) {

            if (d == null || d.getCodigoProducto() <= 0 || d.getCantidad() <= 0 || d.getPrecioUnitario() == null || d.getPrecioUnitario().signum() < 0) {
                throw new IllegalArgumentException("Hay productos con datos incorrectos.");
            }

            BigDecimal precio = d.getPrecioUnitario().setScale(2, RoundingMode.HALF_UP);
            d.setPrecioUnitario(precio);
            BigDecimal subtotal = precio.multiply(BigDecimal.valueOf(d.getCantidad()));
            d.setSubtotal(subtotal);
            total = total.add(subtotal);
        }
        return total;
    }

    // Guardar una nueva venta
    public boolean guardar(Venta v, List<DetalleVenta> detalles) {

        if (v == null || v.getNombreCliente() == null || v.getNombreCliente().trim().isEmpty()) {
            return false;
        }

        try {
            v.setMontoTotal(calcularTotal(detalles));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        if (v.getFecha() == null) {
            v.setFecha(LocalDateTime.now());
        }

        String sql = "INSERT INTO venta "
                + "(fecha, nombre_cliente, monto_total) "
                + "VALUES (?,?,?)";

        try (Connection con = cn.conectar()) {

            con.setAutoCommit(false);

            try {
                int codigoVenta;

                try (PreparedStatement ps = con.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)) {

                    ps.setTimestamp(1,
                            Timestamp.valueOf(v.getFecha()));
                    ps.setString(2, v.getNombreCliente().trim());
                    ps.setBigDecimal(3, v.getMontoTotal());

                    if (ps.executeUpdate() != 1) {
                        throw new SQLException(
                                "No se pudo guardar la venta.");
                    }

                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (!rs.next()) {
                            throw new SQLException("No se obtuvo el codigo.");
                        }
                        codigoVenta = rs.getInt(1);
                    }
                }

                for (DetalleVenta d : detalles) {
                    d.setCodigoVenta(codigoVenta);

                    if (!detalleDAO.descontarStock(con, d)) {
                        throw new SQLException("Stock insuficiente. Producto: " + d.getCodigoProducto());
                    }

                    if (!detalleDAO.guardar(con, d)) {
                        throw new SQLException("Error al guardar detalle.");
                    }
                }

                con.commit();
                v.setCodigo(codigoVenta);

                return true;

            } catch (Exception e) {
                con.rollback();
                System.out.println(e.getMessage());
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Buscar una venta por su codigo
    public Venta buscar(int codigo) {

        String sql = "SELECT * FROM venta WHERE codigo = ?";

        try (Connection con = cn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, codigo);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Venta v = new Venta();

                    v.setCodigo(rs.getInt("codigo"));

                    Timestamp fecha = rs.getTimestamp("fecha");

                    if (fecha != null) {
                        v.setFecha(fecha.toLocalDateTime());
                    }

                    v.setNombreCliente(
                            rs.getString("nombre_cliente"));

                    v.setMontoTotal(
                            rs.getBigDecimal("monto_total"));

                    return v;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    // Listar las ventas
    public List<Venta> listar() {

        List<Venta> lista = new ArrayList<>();

        String sql = "SELECT * FROM venta ORDER BY codigo DESC";

        try (Connection con = cn.conectar(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Venta v = new Venta();

                v.setCodigo(rs.getInt("codigo"));

                Timestamp fecha = rs.getTimestamp("fecha");

                if (fecha != null) {
                    v.setFecha(fecha.toLocalDateTime());
                }

                v.setNombreCliente(
                        rs.getString("nombre_cliente"));

                v.setMontoTotal(
                        rs.getBigDecimal("monto_total"));

                lista.add(v);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    // Actualizar una venta existente
    public boolean actualizar(Venta v, List<DetalleVenta> detalles) {

        if (v == null || v.getCodigo() <= 0
                || v.getNombreCliente() == null
                || v.getNombreCliente().trim().isEmpty()) {
            return false;
        }

        try {
            v.setMontoTotal(calcularTotal(detalles));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        String sqlBloquear
                = "SELECT codigo FROM venta "
                + "WHERE codigo = ? FOR UPDATE";

        String sqlRestaurar
                = "UPDATE inventario i "
                + "INNER JOIN ("
                + "SELECT codigo_producto, SUM(cantidad) AS total "
                + "FROM detalle_venta WHERE codigo_venta = ? "
                + "GROUP BY codigo_producto"
                + ") d ON i.codigo = d.codigo_producto "
                + "SET i.unidad = i.unidad + d.total";

        String sqlEliminar
                = "DELETE FROM detalle_venta WHERE codigo_venta = ?";

        String sqlActualizar
                = "UPDATE venta SET nombre_cliente = ?, "
                + "monto_total = ? WHERE codigo = ?";

        try (Connection con = cn.conectar()) {

            con.setAutoCommit(false);

            try {

                // 1. Bloquear la venta
                try (PreparedStatement ps
                        = con.prepareStatement(sqlBloquear)) {

                    ps.setInt(1, v.getCodigo());

                    try (ResultSet rs = ps.executeQuery()) {

                        if (!rs.next()) {
                            throw new SQLException(
                                    "La venta no existe.");
                        }
                    }
                }

                // 2. Devolver al inventario el stock anterior
                try (PreparedStatement ps
                        = con.prepareStatement(sqlRestaurar)) {

                    ps.setInt(1, v.getCodigo());
                    ps.executeUpdate();
                }

                // 3. Eliminar los detalles anteriores
                try (PreparedStatement ps
                        = con.prepareStatement(sqlEliminar)) {

                    ps.setInt(1, v.getCodigo());
                    ps.executeUpdate();
                }

                // 4. Actualizar la cabecera
                try (PreparedStatement ps
                        = con.prepareStatement(sqlActualizar)) {

                    ps.setString(1, v.getNombreCliente().trim());
                    ps.setBigDecimal(2, v.getMontoTotal());
                    ps.setInt(3, v.getCodigo());

                    if (ps.executeUpdate() != 1) {
                        throw new SQLException(
                                "No se pudo actualizar la venta.");
                    }
                }

                // 5. Registrar los nuevos detalles
                for (DetalleVenta d : detalles) {

                    d.setCodigoVenta(v.getCodigo());

                    if (!detalleDAO.descontarStock(con, d)) {
                        throw new SQLException(
                                "Stock insuficiente. Producto: "
                                + d.getCodigoProducto());
                    }

                    if (!detalleDAO.guardar(con, d)) {
                        throw new SQLException(
                                "No se pudo actualizar el detalle.");
                    }
                }

                // 6. Confirmar todos los cambios
                con.commit();

                return true;

            } catch (Exception e) {
                con.rollback();
                System.out.println(e.getMessage());
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
