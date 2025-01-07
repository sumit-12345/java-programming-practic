package com.practic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDatabase {
/*
    // Insert student data into the database
    public static boolean insertStudent(Student student) {
        String query = "INSERT INTO students (name, address, roll_no, marks) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, student.getName());
            statement.setString(2, student.getAddress());
            statement.setString(3, student.getRollNo());
            statement.setInt(4, student.getMarks());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;  // Return true if insertion was successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Return false in case of any error
        }
    }

    // Fetch all students from the database
    public static void getAllStudents() {
        String query = "SELECT * FROM students";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {  // Explicitly using ResultSet

            // Iterate through the result set and print student details
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Name: " + resultSet.getString("name") +
                        ", Roll No: " + resultSet.getString("roll_no") +
                        ", Marks: " + resultSet.getInt("marks"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update student data in the database
    public static boolean updateStudent(Student student) {
        String query = "UPDATE students SET name = ?, address = ?, roll_no = ?, marks = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, student.getName());
            statement.setString(2, student.getAddress());
            statement.setString(3, student.getRollNo());
            statement.setInt(4, student.getMarks());
            statement.setInt(5, student.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;  // Return true if update was successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Return false if there was an error
        }
    }*/
}



