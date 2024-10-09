package com.example.attendease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendease.models.Student;
import com.example.attendease.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student login(String email, String password) {
        Student student = studentRepository.findByEmail();
        if (student != null && student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }

    // Additional methods for joining classrooms and viewing attendance can be added here.
}