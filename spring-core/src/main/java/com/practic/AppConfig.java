package com.practic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Configuration
@ComponentScan("com.practic")
public class AppConfig {
    @Bean
    public List<Student> gradeA() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John",24,"A"));
        students.add(new Student("Mike",26,"A"));
        students.add(new Student("Jack",25,"A"));
        return students;
    }

    @Bean
    public List<Student> gradeB() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Salva",24,"B"));
        students.add(new Student("Mojo",26,"B"));
        students.add(new Student("Hanery",25,"B"));
        return students;
    }

    @Bean
    public List<Student> students(List<List<Student>> students) {
        List<Student> studentList = new ArrayList<>();
        for (List<Student> student : students) {
            studentList.addAll(student);
        }
        return studentList;
    }


}
