package com.practic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private int courseId;
    private String courseName;
    private int instructorId;
    private String schedule;

    public Course() {
    }

    public Course(int courseId, String courseName, int instructorId, String schedule) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course cource = (Course) o;
        return courseId == cource.courseId && instructorId == cource.instructorId && Objects.equals(courseName, cource.courseName) && Objects.equals(schedule, cource.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, instructorId, schedule);
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public static List<Course> generateCourse() {
        List<Course> cources = new ArrayList<>();
        cources.add(new Course(101, "Introduction to Programming", 1, "M-W-F 9-10 AM"));
        cources.add(new Course(102, "Data Structures", 2, "M-W-F 10-11 AM"));
        cources.add(new Course(103, "Discrete Mathematics", 3, "T-Th 9-10:30 AM"));
        cources.add(new Course(104, "Algorithms", 4, "M-W 1-2:30 PM"));
        cources.add(new Course(105, "Operating Systems", 5, "T-Th 11-12:30 PM"));
        cources.add(new Course(106, "Computer Networks", 6, "M-W-F 12-1 PM"));
        cources.add(new Course(107, "Database Management", 7, "M-W-F 2-3 PM"));
        cources.add(new Course(108, "Software Engineering", 8, "T-Th 3-4:30 PM"));
        cources.add(new Course(109, "Theory of Computation", 9, "M-W 3-4:30 PM"));
        cources.add(new Course(110, "Artificial Intelligence", 10, "T-Th 1-2:30 PM"));
        return cources;
    }
}
