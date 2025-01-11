package com.practic.dao;

import com.practic.exceptions.StudentAlreadyEnrolledException;
import com.practic.model.Enrollment;
import com.practic.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.practic.constants.SMSQueryConstants.ALL_ENROLLMENT;
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
                throw new StudentAlreadyEnrolledException("Student : "+sId+" is already registered with course : "+cId);
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
//                istudentEnrolledWithGivenCourse(studentId,cId);
                preparedStatement.setInt(1,studentId);
                preparedStatement.setInt(2,cId);
                preparedStatement.execute();
            }
        }catch (SQLException ex) {

        }
    }

    public List<Enrollment> fetchAllEntollment() {
        try(Statement statement = connection.createStatement()) {
            List<Enrollment> enrollment = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(ALL_ENROLLMENT);

            while (resultSet.next()) {
                Enrollment en = new Enrollment();
                en.setStudentId(resultSet.getInt("student_id"));
                en.setCourseId(resultSet.getInt("cource_id"));
                enrollment.add(en);
            }
            return enrollment;
        } catch (SQLException exception) {
            return null;
        }
    }
}
