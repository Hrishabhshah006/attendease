package com.example.attendease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendease.models.Student;
import com.example.attendease.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudentsInClassroom(Long classroomId) {
        return studentRepository.findByClassroomId(classroomId);
    }
}