package com.example.attendease.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendease.models.Student;
import com.example.attendease.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public Student login(@RequestParam String email, @RequestParam String password) {
        return studentService.login(email, password);
    }

    // Additional endpoints for joining classrooms and viewing attendance can be added here.
}