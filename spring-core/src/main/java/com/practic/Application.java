package com.practic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        List<Student> students = (List<Student>) context.getBean("students");
        for (Student student : students) {
            System.out.println("Name : " + student.getName() + ", Age: " + student.getAge() + ", Grade : " + student.getGrade());
        }

    }
}
