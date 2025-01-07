package com.practic;

import java.util.Objects;

public class Student implements Cloneable{
    String name;
    int rollNo;
    String grade;

    Student() {}

    Student(String name, int rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    public boolean equals(Student student) {
        if (student == null) return false;
        boolean isSameName = this.name.equals(student.name);
        boolean isSameRollNo = this.rollNo == student.rollNo;
        boolean isSameGrade = this.grade.equals(student.grade);
        return  isSameGrade && isSameName && isSameRollNo;
    }

    // Copy Constructor
    Student(Student student) {
        this.name = student.name;
        this.rollNo = student.rollNo;
        this.grade = student.grade;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", RollNo: " + rollNo + ", Grade: " + grade;
    }

    @Override
    protected Student clone(){
        Student student = new Student();
        student.setName(this.name);
        student.setRollNo(this.rollNo);
        student.setGrade(this.grade);
        return student;
    }


}
