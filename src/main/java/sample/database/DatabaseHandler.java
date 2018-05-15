package sample.database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseHandler {
    private static DatabaseHandler handler = null;

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/apteka?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection conn = null;
    private static Statement stmt = null;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cant load database", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return conn;
    }
}
