package com.practic.constants;

public class SMSQueryConstants {
    public static final String STUDENT_INSERT_QUERY = "INSERT INTO student (student_id, name, age, dept, status) " +
            "VALUES (?,?,?,?,?)";
    public static final String COURSE_INSERT_QUERY = "INSERT INTO cource (cource_id, cource_name, instructor_id, schedule) " +
            "VALUES (?,?,?,?)";
    public static final String ALL_STUDENT = "SELECT student_id,name,dept,age,status FROM student";
}
