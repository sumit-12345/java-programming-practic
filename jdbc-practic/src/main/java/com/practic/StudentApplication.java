package com.practic;

import java.sql.*;
import java.util.*;

public class StudentApplication {
    public static void main(String[] args) {
/*
        try (Connection connection = DatabaseConnection.getConnection()) {

            Statement statement = connection.createStatement();


            String insertQuery = "INSERT INTO student (id, name, address, roll_no, mark) " +
                    "VALUES (1, 'John Doe', '123 Main St, City', 101, 85.5)";
            int rowsInserted = statement.executeUpdate(insertQuery);
            System.out.println("Rows inserted: " + rowsInserted);


            String selectQuery = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                int rollNo = resultSet.getInt("roll_no");
                double mark = resultSet.getDouble("mark");

                System.out.println("ID: " + id + ", Name: " + name + ", Address: " + address +
                        ", Roll No: " + rollNo + ", Mark: " + mark);
            }

            // Step 5: Update the student's marks (for student with ID = 1)
            String updateQuery = "UPDATE student SET mark = 90.0 WHERE id = 1";
            int rowsUpdated = statement.executeUpdate(updateQuery);
            System.out.println("Rows updated: " + rowsUpdated);

        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }*/
    }
}

