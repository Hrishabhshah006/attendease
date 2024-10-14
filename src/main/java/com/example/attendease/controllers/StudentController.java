package com.example.attendease.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendease.models.Attendance;
import com.example.attendease.models.Classroom;
import com.example.attendease.models.Student;
import com.example.attendease.repository.ClassroomRepository;
import com.example.attendease.repository.StudentRepository;
import com.example.attendease.service.AttendanceService;
import com.example.attendease.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private AttendanceService attendanceService;
    
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private ClassroomRepository classroomRepository;

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.registerStudent(student), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> studentLogin(@RequestParam String studentID,@RequestParam String password) {
        String result = studentService.login(studentID, password);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/joinclassroom")
    public ResponseEntity<String> joinClass(@RequestParam String classCode,@RequestParam String studentID,@RequestParam String userName) {
       	String result = studentService.updateStudent(classCode,studentID,userName);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/{studentId}")
    public ResponseEntity<List<Attendance>> getAttendanceForStudent(@PathVariable Long studentId) {
        List<Attendance> attendanceList = attendanceService.getAttendanceForStudent(studentId);
        return ResponseEntity.ok(attendanceList);
    }
}