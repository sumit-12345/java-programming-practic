package com.practic;

import java.util.Scanner;

public class StudentApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Insert a new student
        System.out.println("Enter student details:");

        Student student1 = new Student();

        System.out.print("Name: ");
        student1.setName(scanner.nextLine());  // Take Name as input

        System.out.print("Address: ");
        student1.setAddress(scanner.nextLine());  // Take Address as input

        System.out.print("Roll No: ");
        student1.setRollNo(scanner.nextLine());  // Take Roll Number as input

        System.out.print("Marks: ");
        student1.setMarks(scanner.nextInt());  // Take Marks as input

        // Inserting the student into the database
        boolean inserted = StudentDatabase.insertStudent(student1);
        System.out.println("Student inserted: " + inserted);

        // Display all students (should be called once)
        System.out.println("\nAll Students:");
        StudentDatabase.getAllStudents();  // This method should only be called once.

        // Update a student's marks (optional step)
        System.out.print("\nEnter student ID to update marks: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline left after nextInt()
        System.out.print("Updated Marks: ");
        int updatedMarks = scanner.nextInt();

        // Set the new values for student
        student1.setId(studentId);
        student1.setMarks(updatedMarks);

        // Update student in database
        boolean updated = StudentDatabase.updateStudent(student1);
        System.out.println("Student updated: " + updated);

        // Display all students again after update
        System.out.println("\nAll Students after update:");
        StudentDatabase.getAllStudents();

        // Close scanner to avoid resource leak
        scanner.close();
    }
}


