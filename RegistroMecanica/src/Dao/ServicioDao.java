package Dao;

import Conexion.ConexionBD;
import Modelo.Servicio;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

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

            // executeUpdate devuelve cuántas filas se insertaron (1 si salió bien)
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "No se pudo enviar los datos a la base de datos.\nPosible error: " + e.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}


