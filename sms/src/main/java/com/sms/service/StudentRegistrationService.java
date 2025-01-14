package com.sms.service;

import com.sms.dao.StudentRegistrationRepository;
import com.sms.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationService {
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    public boolean registerStudent(Student student) {
        return this.studentRegistrationRepository.registerStudent(student);
    }
    public List<Student> fetchAllStudents() {
        return studentRegistrationRepository.fetchAllStudents();
    }

    public boolean deleteStudent(Student student) {
          return studentRegistrationRepository.deleteStudent(student.getId());
    }
}
