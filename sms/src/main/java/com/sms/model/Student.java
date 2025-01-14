package com.sms.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String department;
    private String status;

    public Student() {
    }

    public Student(int id, String name, int age, String department, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.status = status;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
