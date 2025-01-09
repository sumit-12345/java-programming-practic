package com.practic;

import com.practic.config.ConnectionManager;
import com.practic.dao.CourseRegistrationRepository;
import com.practic.dao.StudentRegistrationRepository;
import com.practic.model.Course;
import com.practic.model.Student;
import com.practic.service.StudentRegistrationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConnectionManager.class);
        StudentRegistrationRepository studentRepoBean = context.getBean(StudentRegistrationRepository.class);
        CourseRegistrationRepository courserRepoBean = context.getBean(CourseRegistrationRepository.class);
        StudentRegistrationService studentServiceBean = context.getBean(StudentRegistrationService.class);

//        registerStudents(studentRepoBean);
//        registerCourse(courserRepoBean);
//        displayAllStudents(studentServiceBean);
        displayStudentNamesByGroup(studentServiceBean);

    }

    private static void registerStudents(StudentRegistrationRepository repo) {
        List<Student> students = Student.generateStudents();
        for (Student student : students) {
            boolean isAdded = repo.registerStudent(student);
            if (isAdded) {
                System.out.println("Student Registration Successful.");
            }else {
                System.out.println("Student Registration Failed.");
            }
        }
    }
    private static void registerCourse(CourseRegistrationRepository repo) {
        List<Course> courses = Course.generateCourse();
        for (Course course: courses) {
            boolean isAdded = repo.registerCourse(course);
            if (isAdded) {
                System.out.println("Course Registration Successful.");
            }else {
                System.out.println("Course Registration Failed.");
            }
        }
    }
    private static void displayAllStudents(StudentRegistrationService service) {
        List<Student> students = service.fetchAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
    private static void displayStudentNamesByGroup(StudentRegistrationService service) {
        List<Student> students = service.fetchAllStudents();
        Map<String,List<String>> map = new HashMap<>();
        for (Student student : students) {
            if (map.containsKey(student.getDepartment())) {
                List<String> nameList = map.get(student.getDepartment());
                nameList.add(student.getName());
                map.put(student.getDepartment(),nameList);
            } else {
                List<String> nameList = new ArrayList<>();
                nameList.add(student.getName());
                map.put(student.getDepartment(),nameList);
            }
        }
        for (String key : map.keySet()) {
            System.out.println(key+" -> "+map.get(key));
        }
    }
}
