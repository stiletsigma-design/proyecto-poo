package Dao;

import Conexion.ConexionDB;
import Modelo.DetalleVenta;
import java.sql.*;
import java.util.*;
import java.math.BigDecimal;

public class DetalleVentaDAO {

    ConexionDB cn = new ConexionDB();

    // Guardar detalle de venta
    public boolean guardar(Connection con, DetalleVenta d) {
        String sql = "INSERT INTO detalle_venta "
                + "(codigo_venta, codigo_producto, cantidad, "
                + "precio_unitario, subtotal) VALUES (?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, d.getCodigoVenta());
            ps.setInt(2, d.getCodigoProducto());
            ps.setInt(3, d.getCantidad());
            ps.setBigDecimal(4, d.getPrecioUnitario());
            ps.setBigDecimal(5, d.getSubtotal());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Descontar stock del inventario
    public boolean descontarStock(Connection con, DetalleVenta d) {
        String sql = "UPDATE inventario SET unidad = unidad - ? "
                + "WHERE codigo = ? AND unidad >= ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, d.getCantidad());
            ps.setInt(2, d.getCodigoProducto());
            ps.setInt(3, d.getCantidad());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Calcular subtotal
    public BigDecimal calcularSubtotal(DetalleVenta d) {
        return d.getPrecioUnitario().multiply(BigDecimal.valueOf(d.getCantidad()));
    }

    // Listar detalles de una venta
    public List<DetalleVenta> listar(int codigoVenta) {
        List<DetalleVenta> lista = new ArrayList<>();

        String sql = "SELECT d.*, i.nombre AS nombre_producto "
                + "FROM detalle_venta d "
                + "INNER JOIN inventario i "
                + "ON d.codigo_producto = i.codigo "
                + "WHERE d.codigo_venta = ? "
                + "ORDER BY d.codigo";

        try (Connection con = cn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, codigoVenta);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetalleVenta d = new DetalleVenta();

                    d.setCodigo(rs.getInt("codigo"));
                    d.setCodigoVenta(rs.getInt("codigo_venta"));
                    d.setCodigoProducto(rs.getInt("codigo_producto"));
                    d.setNombreProducto(rs.getString("nombre_producto"));
                    d.setCantidad(rs.getInt("cantidad"));
                    d.setPrecioUnitario(
                            rs.getBigDecimal("precio_unitario"));
                    d.setSubtotal(rs.getBigDecimal("subtotal"));

                    lista.add(d);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
