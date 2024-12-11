package com.practic.prestmt;

import java.sql.*;
import java.util.Scanner;

public class PreparedStmtApplication {

    private static final String INSERT_QUERY = "\n" +
            "INSERT INTO product (id, category, description, name, price, quantity_in_stock) values \n" +
            "(?,?,?,?,?,?);";

    public static void main(String[] args) {
        try(Connection conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/javaprojs", "root", "Sambit.joshi@01");
            Scanner sc = new Scanner(System.in)) {

            PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY);
            do {
                System.out.println("Please enter id, category, description, name, price, quantity_in_stock");
                String input = sc.nextLine();
                String[] s = input.split(",");
                stmt.setInt(1, Integer.parseInt(s[0]));
                stmt.setString(2,s[1]);
                stmt.setString(3,s[2]);
                stmt.setString(4,s[3]);
                stmt.setString(5,s[3]);
                stmt.setString(6,s[3]);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Record inserted successfully!");
                } else {
                    System.out.println("Failed to insert the record.");
                }
                System.out.println("Do u want to continue : (y/n) ");
                String scc = sc.nextLine();
                if (!scc.equals("y")) {
                    sc.close();
                }
            } while (true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
