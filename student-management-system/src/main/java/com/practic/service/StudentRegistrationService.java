package com.practic.service;

import com.practic.dao.StudentRegistrationRepository;
import com.practic.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentRegistrationService {
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    public List<Student> fetchAllStudents() {
        return studentRegistrationRepository.fetchAllStudents();
    }
}
