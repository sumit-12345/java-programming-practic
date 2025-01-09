package com.practic.model;

import java.util.ArrayList;
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
    public Student(int id, String name, int age, String department, String status){
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.status = status;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", status='" + status + '\'' +
                ", id=" + id +
                '}';
    }

    public static List<Student> generateStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice Johnson", 20, "Computer Science", "Active"));
        students.add(new Student(2, "Bob Smith", 22, "Electrical Engineering", "Active"));
        students.add(new Student(3, "Charlie Brown", 21, "Mechanical Engineering", "Inactive"));
        students.add(new Student(4, "David Lee", 23, "Computer Science", "Graduated"));
        students.add(new Student(5, "Eva Green", 20, "Civil Engineering", "Active"));
        students.add(new Student(6, "Frank White", 24, "Biology", "Graduated"));
        students.add(new Student(7, "Grace Black", 22, "Physics", "Active"));
        students.add(new Student(8, "Henry Turner", 21, "Mathematics", "Inactive"));
        students.add(new Student(9, "Isabelle Lewis", 23, "Computer Science", "Active"));
        students.add(new Student(10, "Jack Wilson", 25, "Mechanical Engineering", "Graduated"));
        students.add(new Student(11, "Karen Scott", 22, "Electrical Engineering", "Active"));
        students.add(new Student(12, "Leo Martinez", 21, "Architecture", "Inactive"));
        students.add(new Student(13, "Mia Rodriguez", 20, "Chemistry", "Active"));
        students.add(new Student(14, "Nina Carter", 23, "Psychology", "Graduated"));
        students.add(new Student(15, "Oliver Harris", 22, "Computer Science", "Active"));
        return students;
    }
}