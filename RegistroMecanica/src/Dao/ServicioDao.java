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

            // El apellido materno es opcional: si viene vacío se guarda NULL
            if (s.getApMaterno() == null || s.getApMaterno().trim().isEmpty()) {
                ps.setNull(3, java.sql.Types.VARCHAR);
            } else {
                ps.setString(3, s.getApMaterno());
            }

            ps.setString(4, s.getTelefono());
            ps.setDouble(5, s.getPago());
            ps.setString(6, s.getDescripcion());
            
            // executeUpdate devuelve cuántas filas se insertaron (1 si salió bien
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al guardar servicio: " + e.getMessage());
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

                // La fecha viene como Timestamp y se convierte a LocalDateTime
                Timestamp ts = rs.getTimestamp("fecha");
                if (ts != null) {
                    s.setFecha(ts.toLocalDateTime());
                }

                listaservicio.add(s);   // sin esta línea la lista queda vacía
            }

        } catch (Exception e) {
            System.out.println("Error al listar servicios: " + e.getMessage());
        }

        return listaservicio;
    }
}
