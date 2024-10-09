package com.example.attendease.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.attendease.dto.AttendanceData;
import com.example.attendease.models.Attendance;
import com.example.attendease.models.Classroom;
import com.example.attendease.models.Teachers;
import com.example.attendease.service.TeacherService;
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/login")
    public Teachers login(@RequestParam String email, @RequestParam String password) {
        return teacherService.login(email, password);
    }

    @PostMapping("/classroom")
    public Classroom createClassroom(@RequestBody Classroom classroom, @RequestParam Long teacherId) {
        return teacherService.createClassroom(classroom, teacherId);
    }

    @GetMapping("/classrooms")
    public List<Classroom> getClassrooms(@RequestParam Long teacherId) {
        return teacherService.getClassrooms(teacherId);
    }

    // Additional endpoints for taking attendance can be added here.
}