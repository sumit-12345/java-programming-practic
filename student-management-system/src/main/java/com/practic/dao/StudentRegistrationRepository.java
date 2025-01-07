package com.practic.dao;

import com.practic.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class StudentRegistrationRepository {

    @Autowired
    private Connection connection;

    public boolean registrStudent(Student student) {
        String insertQuery = "INSERT INTO student (name, age, dept, status) " +
                "VALUES (?,?,?,?)";
        try  {
            PreparedStatement pStatement = connection.prepareStatement(insertQuery);
            pStatement.setString(1, student.getName());
            pStatement.setString(2, student.getAge() + "");
            pStatement.setString(3, student.getDepartment());
            pStatement.setString(4, student.getStatus());
            int rowsInserted = pStatement.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }

    }
}
