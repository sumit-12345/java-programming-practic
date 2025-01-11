package com.practic;

import com.practic.config.ConnectionManager;
import com.practic.dao.CourseRegistrationRepository;
import com.practic.dao.StudentRegistrationRepository;
import com.practic.helper.StudentCourseHelper;
import com.practic.model.Course;
import com.practic.model.Student;
import com.practic.service.EnrollmentService;
import com.practic.service.StudentRegistrationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

/**
 * 101	Introduction to Programming	    1	M-W-F 9-10 AM
 * 102	Data Structures	                2	M-W-F 10-11 AM
 * 103	Discrete Mathematics	        3	T-Th 9-10:30 AM
 * 104	Algorithms	                    4	M-W 1-2:30 PM
 * 105	Operating Systems	            5	T-Th 11-12:30 PM
 * 106	Computer Networks	            6	M-W-F 12-1 PM
 * 107	Database Management         	7	M-W-F 2-3 PM
 * 108	Software Engineering	        8	T-Th 3-4:30 PM
 * 109	Theory of Computation       	9	M-W 3-4:30 PM
 * 110	Artificial Intelligence	        10	T-Th 1-2:30 PM
 *
 */

/*
1	Alice Johnson
2	Bob Smith
3	Charlie Brown
4	David Lee
5	Eva Green
6	Frank White
7	Grace Black
8	Henry Turner
9	Isabelle Lewis
10	Jack Wilson
11	Karen Scott
12	Leo Martinez
13	Mia Rodriguez
14	Nina Carter
15	Oliver Harris
 */
/*
    1. EnrollmentLimitExceededException
    2. StudentAlreadyEnrolledException
    3. DatabaseConnectionException
    4. InactiveCourseException
    5. InvalidStudentException
    6. InvalidCourseException
*/
public class App
{

    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConnectionManager.class);
        StudentRegistrationRepository studentRepoBean = context.getBean(StudentRegistrationRepository.class);
        CourseRegistrationRepository courserRepoBean = context.getBean(CourseRegistrationRepository.class);
        StudentRegistrationService studentServiceBean = context.getBean(StudentRegistrationService.class);
        EnrollmentService enrollmentService = context.getBean(EnrollmentService.class);
        StudentCourseHelper studentCourseHelper = context.getBean(StudentCourseHelper.class);

//        registerStudents(studentRepoBean);
//        registerCourse(courserRepoBean);
//        displayAllStudents(studentServiceBean);
//        displayStudentNamesByGroup(studentServiceBean);
//        enrollmentCourses(enrollmentService);
        Map<Student, List<Course>> studentListMap = studentCourseHelper.getStudentListMap();

        for (Student s : studentListMap.keySet()) {
            List<Course> courses = studentListMap.get(s);
            String str = "";
            for (Course c : courses) {
                str += c.getCourseName()+" || ";
            }
            System.out.println(s.getName() + "-> "+str);
        }

    }

    private static void enrollmentCourses(EnrollmentService enrollmentService) {
        List<Student> students = Student.generateStudents();
        List<Course> courses = Course.generateCourse();

        List<Course> bobCourse = new ArrayList<>();
        bobCourse.add(courses.get(3));
        bobCourse.add(courses.get(5));
        bobCourse.add(courses.get(6));
        enrollmentService.enrollStudentWithCourse(students.get(1),bobCourse);

        List<Course> davidCourse = new ArrayList<>();
        davidCourse.add(courses.get(1));
        davidCourse.add(courses.get(3));
        davidCourse.add(courses.get(9));
        enrollmentService.enrollStudentWithCourse(students.get(3),davidCourse);

        List<Course> frankCourse = new ArrayList<>();
        frankCourse.add(courses.get(0));
        frankCourse.add(courses.get(1));
        frankCourse.add(courses.get(2));
        frankCourse.add(courses.get(3));
        frankCourse.add(courses.get(4));
        frankCourse.add(courses.get(5));
        enrollmentService.enrollStudentWithCourse(students.get(5),frankCourse);
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


