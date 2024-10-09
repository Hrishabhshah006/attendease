package com.example.attendease.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendease.models.Classroom;
import com.example.attendease.models.Teachers;
import com.example.attendease.service.TeacherService;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/login")
    public ResponseEntity<Teachers> login(@RequestParam Long id, @RequestParam String password) {
        Teachers teacher = teacherService.login(id, password);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/{teacherId}/classrooms")
    public ResponseEntity<List<Classroom>> getClassrooms(@PathVariable Long teacherId) {
        List<Classroom> classrooms = teacherService.getClassrooms(teacherId);
        return ResponseEntity.ok(classrooms);
    }

    @PostMapping("/{teacherId}/classrooms")
    public ResponseEntity<Classroom> createClassroom(@PathVariable Long teacherId, @RequestParam String className) {
        Classroom classroom = teacherService.createClassroom(teacherId, className);
        return ResponseEntity.ok(classroom);
    }

    @PostMapping("/{classroomId}/attendance")
    public ResponseEntity<Void> takeAttendance(
            @PathVariable Long classroomId,
            @RequestParam LocalDate date,
            @RequestBody Map<Long, Boolean> attendanceData) {
        teacherService.takeAttendance(classroomId, date, attendanceData);
        return ResponseEntity.ok().build();
    }
}
