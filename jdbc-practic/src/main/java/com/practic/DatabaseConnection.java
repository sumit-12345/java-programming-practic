package com.practic;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/School";  // Update with your database URL
    private static final String USER = "root";  // Your MySQL username
    private static final String PASSWORD = "saish";  // Your MySQL password

    // Method to establish and return a connection to the database
    public static Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish and return the database connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Handle the case when the MySQL driver is not found
            throw new SQLException("MySQL JDBC driver not found", e);
        }
    }
}
