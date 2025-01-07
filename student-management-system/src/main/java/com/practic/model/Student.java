package com.practic.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private int age;
    private String department;
    private String status; // Active, Inactive, Graduated
    private List<String> coursesEnrolled; // Courses student is enrolled in
    private List<Integer> grades; // Grades for various subjects
    private Map<String, Double> feeStatus; // Maps fee components to amounts
    private boolean scholarshipEligibility;

    public Student() {
    }

    public Student(int id, String name, int age, String department, String status, List<String> coursesEnrolled, List<Integer> grades, Map<String, Double> feeStatus, boolean scholarshipEligibility) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.status = status;
        this.coursesEnrolled = coursesEnrolled;
        this.grades = grades;
        this.feeStatus = feeStatus;
        this.scholarshipEligibility = scholarshipEligibility;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && scholarshipEligibility == student.scholarshipEligibility && Objects.equals(name, student.name) && Objects.equals(department, student.department) && Objects.equals(status, student.status) && Objects.equals(coursesEnrolled, student.coursesEnrolled) && Objects.equals(grades, student.grades) && Objects.equals(feeStatus, student.feeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, department, status, coursesEnrolled, grades, feeStatus, scholarshipEligibility);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public void setCoursesEnrolled(List<String> coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public Map<String, Double> getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(Map<String, Double> feeStatus) {
        this.feeStatus = feeStatus;
    }

    public boolean isScholarshipEligibility() {
        return scholarshipEligibility;
    }

    public void setScholarshipEligibility(boolean scholarshipEligibility) {
        this.scholarshipEligibility = scholarshipEligibility;
    }
}