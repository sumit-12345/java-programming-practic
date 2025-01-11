package com.practic.dao;

import com.practic.config.ConnectionManager;
import com.practic.model.Course;
import com.practic.model.Enrollment;
import com.practic.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.practic.constants.SMSQueryConstants.*;

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

    public List<Course> fetchAllCource() {
        try(Statement statement = connection.createStatement()) {
            List<Course> courses = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(ALL_COURSES);
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("cource_id"));
                course.setCourseName(resultSet.getString("cource_name"));
                course.setSchedule(resultSet.getString("schedule"));
                course.setInstructorId(resultSet.getInt("instructor_id"));
                courses.add(course);
            }
            return courses;
        } catch (SQLException ex) {
            return null;
        }
    }
}
