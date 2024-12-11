package com.practic;

public class Student {
    private int id;
    private String name;
    private String address;
    private int rollNo;
    private double mark;

    // Constructor to initialize the Student object
    public Student(int id, String name, String address, int rollNo, double mark) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rollNo = rollNo;
        this.mark = mark;
    }

    // Getter and Setter methods for each field
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
