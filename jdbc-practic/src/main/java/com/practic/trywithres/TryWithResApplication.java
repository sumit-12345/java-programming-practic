package com.practic.trywithres;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;

public class TryWithResApplication {

    public static void main(String[] args)  {
        TryWithResApplication ts = new TryWithResApplication();
        ts.tryWithResourceTesting();
    }

    private void tryWithResourceTesting()  {
        String url = "\"jdbc:mysql://localhost:3306/javaprojs\", \"root\", \"Sambit.joshi@01\"";
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM product");) {

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
        }catch (SQLException sqlException) {

        }
    }
}