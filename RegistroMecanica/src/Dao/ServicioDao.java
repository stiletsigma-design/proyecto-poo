package Dao;

import Conexion.ConexionBD;
import Modelo.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ServicioDao {

    ConexionBD conexion = new ConexionBD();

    // GUARDAR
    public boolean guardar(Servicio s) {
        // La fecha NO se manda: MySQL pone la fecha y hora actual solo
        String sql = "INSERT INTO servicio(nombre, apellido_paterno, apellido_materno, "
                   + "telefono, pago, descripcion) VALUES(?,?,?,?,?,?)";

        try (Connection con = conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getNombre());
            ps.setString(2, s.getApPaterno());

            if (s.getApMaterno() == null || s.getApMaterno().trim().isEmpty()) {
                ps.setNull(3, java.sql.Types.VARCHAR);
            } else {
                ps.setString(3, s.getApMaterno());
            }

            ps.setString(4, s.getTelefono());
            ps.setDouble(5, s.getPago());
            ps.setString(6, s.getDescripcion());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al guardar servicio: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error al guardar: " + e.getMessage());
            return false;
        }
    }

    // LISTAR
    public List<Servicio> listarServicio() {
        List<Servicio> listaservicio = new ArrayList<>();
        String sql = "SELECT * FROM servicio ORDER BY codigo DESC";

        try (Connection con = conexion.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Servicio s = new Servicio();
                s.setCodigo(rs.getInt("codigo"));
                s.setNombre(rs.getString("nombre"));
                s.setApPaterno(rs.getString("apellido_paterno"));
                s.setApMaterno(rs.getString("apellido_materno"));
                s.setTelefono(rs.getString("telefono"));
                s.setPago(rs.getDouble("pago"));
                s.setDescripcion(rs.getString("descripcion"));

                Timestamp ts = rs.getTimestamp("fecha");
                if (ts != null) {
                    s.setFecha(ts.toLocalDateTime());
                }

                listaservicio.add(s);
            }

        } catch (Exception e) {
            System.out.println("Error al listar servicios: " + e.getMessage());
        }

        return listaservicio;
    }

    // MODIFICAR
    public boolean modificar(Servicio s) {
        // El WHERE codigo = ? es lo que evita modificar TODOS los servicios
        String sql = "UPDATE servicio SET nombre = ?, apellido_paterno = ?, "
                   + "apellido_materno = ?, telefono = ?, pago = ?, descripcion = ? "
                   + "WHERE codigo = ?";

        try (Connection con = conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getNombre());
            ps.setString(2, s.getApPaterno());

            if (s.getApMaterno() == null || s.getApMaterno().trim().isEmpty()) {
                ps.setNull(3, java.sql.Types.VARCHAR);
            } else {
                ps.setString(3, s.getApMaterno());
            }

            ps.setString(4, s.getTelefono());
            ps.setDouble(5, s.getPago());
            ps.setString(6, s.getDescripcion());
            ps.setInt(7, s.getCodigo());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al modificar servicio: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error al modificar: " + e.getMessage());
            return false;
        }
    }
}