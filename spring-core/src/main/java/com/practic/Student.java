package com.practic;

import java.util.Objects;

public class Student {

    private String name;
    private int age;
    private String grade;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for grade
    public String getGrade() {
        return grade;
    }

    // Setter for grade
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // ToString method to display Student information
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(grade, student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, grade);
    }
}
