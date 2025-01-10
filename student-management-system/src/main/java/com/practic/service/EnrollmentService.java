package com.practic.service;

import com.practic.dao.EnrollmentRepository;
import com.practic.model.Course;
import com.practic.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public boolean enrollStudentWithCourse(Student student, List<Course> courses) {
        try {
            List<Integer> courseId = new ArrayList<>();
            for (Course course : courses)
                courseId.add(course.getCourseId());
            this.enrollmentRepository.enrollStudent(student.getId(), courseId);
            System.out.println("Student : "+student.getName()+" is enroll for "+courses.size()+" courses.");
            return true;
        } catch (RuntimeException ex) {
            System.out.println("Can't enroll student "+student.getName()+" because its already enrolled with given course.");
            return false;
        }
    }
}
