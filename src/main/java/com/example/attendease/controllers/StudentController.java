package com.example.attendease.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendease.models.Classroom;
import com.example.attendease.models.Student;
import com.example.attendease.repository.ClassroomRepository;
import com.example.attendease.repository.StudentRepository;
import com.example.attendease.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private ClassroomRepository classroomRepository;

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.registerStudent(student), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> studentLogin(@RequestBody Student request) {
        return ResponseEntity.ok("Student logged in successfully");
    }

    @PostMapping("/join/{classCode}")
    public ResponseEntity<Void> joinClass(@PathVariable String classCode, @RequestBody Student student) {
        Classroom classroom = classroomRepository.findByClassCode(classCode).orElseThrow(() -> new RuntimeException("Invalid Class Code"));
        student.setClassroom(classroom);
        studentRepository.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}