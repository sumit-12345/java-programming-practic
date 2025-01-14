package com.sms.constraints;

public class SMSQueryConstants {
    public static final String STUDENT_INSERT_QUERY = "INSERT INTO student (student_id, name, age, dept, status) " +
            "VALUES (?,?,?,?,?)";
    public static final String COURSE_INSERT_QUERY = "INSERT INTO cource (cource_id, cource_name, instructor_id, schedule) " +
            "VALUES (?,?,?,?)";
    public static final String ALL_STUDENT = "SELECT student_id,name,dept,age,status FROM student";
    public static final String ALL_ENROLLMENT = "SELECT * FROM enrolment";
    public static final String ALL_COURSES = "SELECT * FROM cource";
    public static final String ENROLLMENT_STUDENT_COURSE = "INSERT INTO enrolment(student_id, cource_id) values (?,?)";
    public static final String IS_STUDENT_ENROLLED = "SELECT COUNT(1) FROM ENROLLMENT WHERE STUDENT ID = ? AND COURCE_ID= ?";
}
