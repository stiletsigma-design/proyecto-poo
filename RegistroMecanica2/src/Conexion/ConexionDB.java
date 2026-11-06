package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionDB {
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
                    "Error al intentar conectar la base de datos.\nERROR: " + e.getMessage());
        }

        return con;
    }
}
