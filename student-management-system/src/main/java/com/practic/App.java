package com.practic;

import com.practic.config.ConnectionManager;
import com.practic.dao.StudentRegistrationRepository;
import com.practic.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConnectionManager.class);
        StudentRegistrationRepository repo = context.getBean(StudentRegistrationRepository.class);
        Student student = new Student();
        student.setName("John");
        student.setAge(18);
        student.setDepartment("CS");
        student.setStatus("Active");
        boolean isAdded = repo.registrStudent(student);
        if (isAdded) {
            System.out.println("Student Registration Successful.");
        }else {
            System.out.println("Student Registration Failed.");
        }
    }
}
