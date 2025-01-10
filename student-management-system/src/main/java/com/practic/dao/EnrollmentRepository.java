package com.practic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

import static com.practic.constants.SMSQueryConstants.ENROLLMENT_STUDENT_COURSE;
@Repository
public class EnrollmentRepository {

    @Autowired
    private Connection connection;

    public boolean istudentEnrolledWithGivenCourse(int sId, int cId) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(1) FROM enrolment where student_id="+sId+" and cource_id="+cId+";");
            if (resultSet.next()){
                throw new RuntimeException("Student is already Enrolled.");
            }
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public void enrollStudent(int studentId, List<Integer> courseId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ENROLLMENT_STUDENT_COURSE);
            for (Integer cId : courseId) {
                istudentEnrolledWithGivenCourse(studentId,cId);
                preparedStatement.setInt(1,studentId);
                preparedStatement.setInt(2,cId);
                preparedStatement.execute();
            }
        }catch (SQLException ex) {

        }
    }

}
