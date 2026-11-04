package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/mecanica";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private Connection con;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "No se pudo conectar a la base de datos\nPosible error: " + e.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}
