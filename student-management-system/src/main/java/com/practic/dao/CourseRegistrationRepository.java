package com.practic.dao;

import com.practic.config.ConnectionManager;
import com.practic.model.Course;
import com.practic.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.practic.constants.SMSQueryConstants.COURSE_INSERT_QUERY;
@Repository
public class CourseRegistrationRepository {
    @Autowired
    private Connection connection;
    public boolean registerCourse(Course course) {
        try  {
            PreparedStatement preparedStatement = connection.prepareStatement(COURSE_INSERT_QUERY);
            preparedStatement.setInt(1,course.getCourseId());
            preparedStatement.setString(2,course.getCourseName());
            preparedStatement.setInt(3,course.getInstructorId());
            preparedStatement.setString(4,course.getSchedule());
            int id = preparedStatement.executeUpdate();
            System.out.println("Course inserted with id : "+ id);
            return true;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
