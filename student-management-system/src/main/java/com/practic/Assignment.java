package com.practic;

import com.practic.config.ConnectionManager;
import com.practic.helper.StudentCourseHelper;
import com.practic.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConnectionManager.class);
        StudentCourseHelper studentCourseHelper = context.getBean(StudentCourseHelper.class);
        printActiveStudents(studentCourseHelper);
    }

    public static void printActiveStudents(StudentCourseHelper helper) {
        List<Student> students = helper.getStudents();
        List<Student> filterStudents = new ArrayList<>();
        for (Student s : students) {
            if (s.getStatus().equals("Active")){
                filterStudents.add(s);
            }
        }
        System.out.println(filterStudents);
    }
}
