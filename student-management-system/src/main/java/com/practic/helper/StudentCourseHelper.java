package com.practic.helper;

import com.practic.dao.CourseRegistrationRepository;
import com.practic.dao.EnrollmentRepository;
import com.practic.dao.StudentRegistrationRepository;
import com.practic.model.Course;
import com.practic.model.Enrollment;
import com.practic.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentCourseHelper {
    private final Map<Student, List<Course>> studentListMap = new HashMap<>();
    private final Map<Course, List<Student>> courseListMap = new HashMap<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;
    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;


    public Map<Student, List<Course>> getStudentListMap() {
        List<Enrollment> enrollments = enrollmentRepository.fetchAllEntollment();
        List<Student> students = studentRegistrationRepository.fetchAllStudents();
        List<Course> courses = courseRegistrationRepository.fetchAllCource();

        for (Enrollment enrollment : enrollments) {
            int sId = enrollment.getStudentId();
            int cId = enrollment.getCourseId();
            Student s = null;
            Course c = null;
            for (Student student : students) {
                if (student.getId() == sId) {
                    s = student;
                    break;
                }
            }
            for (Course course : courses) {
                if (course.getCourseId() == cId) {
                    c = course;
                    break;
                }
            }
            if (studentListMap.containsKey(s)) {
                List<Course> co = studentListMap.get(s);
                co.add(c);
                studentListMap.put(s,co);
            } else  {
                List<Course> co = new ArrayList<>();
                co.add(c);
                studentListMap.put(s,co);
            }
        }
        return studentListMap;
    }

    public Map<Course, List<Student>> getCourseListMap() {
        return courseListMap;
    }

    public List<Student> getStudents() {
        return studentRegistrationRepository.fetchAllStudents();
    }

    public List<Course> getCourses() {
        return courseRegistrationRepository.fetchAllCource();
    }
}
