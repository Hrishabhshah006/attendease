package com.example.attendease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendease.models.Admin;
import com.example.attendease.models.Student;
import com.example.attendease.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public String login(String studentID, String password) {

        Student student = studentRepository.findByStudentID(studentID);

        if (student!= null && student.getStudentID().equals(studentID) && student.getPassword().equals(password)) {
            return "Login successful!";
        } else {
            return "Invalid username or password.";
        }
    }

    
    public List<Student> getStudentsInClassroom(Long classroomId) {
        return studentRepository.findByClassroomId(classroomId);
    }
}