package com.practic.dao;

import com.practic.constants.SMSQueryConstants;
import com.practic.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.practic.constants.SMSQueryConstants.STUDENT_INSERT_QUERY;
import static com.practic.constants.SMSQueryConstants.ALL_STUDENT;
@Repository
public class StudentRegistrationRepository {

    @Autowired
    private Connection connection;

    public boolean registerStudent(Student student) {
        try  {
            PreparedStatement pStatement = connection.prepareStatement(STUDENT_INSERT_QUERY);
            pStatement.setInt(1,student.getId());
            pStatement.setString(2, student.getName());
            pStatement.setString(3, student.getAge() + "");
            pStatement.setString(4, student.getDepartment());
            pStatement.setString(5, student.getStatus());
            int rowsInserted = pStatement.executeUpdate();
            System.out.println("Student inserted with id : " + rowsInserted);
            return true;
        } catch (SQLIntegrityConstraintViolationException integrityEx) {
            return false;
        }catch (SQLException sqlException) {
            return false;
        }

    }

    public List<Student> fetchAllStudents()  {
        try(Statement statement = connection.createStatement()) {
            List<Student> students = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery(ALL_STUDENT);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setDepartment(resultSet.getString(3));
                student.setAge(resultSet.getInt(4));
                student.setStatus(resultSet.getString(5));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            return null;
        }
    }
}
