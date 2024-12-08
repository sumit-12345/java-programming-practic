package com.practic;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class JdbcPracticApplication
{
    public static void main( String[] args )
    {
        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/javaprojs", "root", "Sambit.joshi@01");
            System.out.println("Connection Established..");
            Statement stmt = conn.createStatement();
            System.out.println("Statement Crated...");
            ResultSet rs = stmt.executeQuery("SELECT * FROM product");
            System.out.println("Query Executed...");

            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-20s %-50s %-20s %-15s %-10s\n", "Category", "Description", "Name", "Price", "Quantity");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                String category = rs.getString("category");
                String description = rs.getString("description");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity_in_stock");

                // Format each row's data with proper spacing
                System.out.printf("%-20s %-50s %-20s %-15.2f %-10d\n", category, description, name, price, quantity);
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
