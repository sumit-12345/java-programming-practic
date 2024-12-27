package com.practic;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Person person = new Person(10, "b", "1234", "USA");
        Person person1 = new Person(1, "y", "1282", "UK");
        Person person2 = new Person(101, "y", "12456", "SA");

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        personList.add(person2);
        System.out.println(personList);
        PersonComparator personComparator = new PersonComparator();
        personList.sort(personComparator);
        System.out.println(personList);
    }

    public static List<Student> generateStudents() {
        List<Student> students = new CopyOnWriteArrayList<>();

        // Add 30 students with some sample values
        for (int i = 1; i <= 30; i++) {
            // Example: Creating students with names like "Student1", "Student2", etc.
            String name = "Student" + i;
            int rollNo = i;
            String grade = (i % 2 == 0) ? "A" : "B"; // Alternating grades for example

            students.add(new Student(name, rollNo, grade));
        }

        return students;
    }
}
