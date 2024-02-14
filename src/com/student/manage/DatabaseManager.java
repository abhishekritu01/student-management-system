package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static Connection connection;

    static {
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");

            // Create a Connection
            String user = "root";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/student_management";

            connection = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Failed to load driver : " + e.getMessage());
            System.exit(0);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (final SQLException exception) {
            System.out.println("Failed to close connection : " + exception.getMessage());
        }
    }
}
