package com.example.attendease.controllers;


import java.time.LocalDate;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendease.models.Classroom;
import com.example.attendease.models.Student;
import com.example.attendease.models.Admin;
import com.example.attendease.service.AdminService;
import com.example.attendease.service.AttendanceService;
import com.example.attendease.service.ClassroomService;
import com.example.attendease.service.StudentService;



@CrossOrigin(origins = "http://localhost:4200")


@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private ClassroomService classroomService;
    
    @Autowired
    private AttendanceService attendanceService;
    
    @Autowired
    private StudentService studentService;

//    POST http://localhost:8080/api/admin/register
//    {   "userID": "29FGH89P",
//        "username": "Crystle",
//        "password": "joyful",
//        "email": "crystlemartinez@email.com"
//    }
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<>(adminService.createAdmin(admin), HttpStatus.CREATED);
    }
    
    
//    POST http://localhost:8080/api/admin/login?userID=29FGH89P&password=joyful
//    in param give userID and Password
    @PostMapping("/login")
    public ResponseEntity<String> adminLogin(@RequestParam String userID,@RequestParam String password) {
        String result = adminService.login(userID, password);
        return ResponseEntity.ok(result);
    }
    
    
//  GET http://localhost:8080/api/admin/classrooms
    @GetMapping("/classrooms")
    public ResponseEntity<List<Classroom>> getClassroomList() {
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        return ResponseEntity.ok(classrooms);
    }
   
    
//	POST http://localhost:8080/api/admin/classroom
//    {
//        "className": "Arrays"
//    }
    @PostMapping("/classroom")
    public ResponseEntity<Classroom> createClassroom(@RequestBody Classroom classroom) {
        return new ResponseEntity<>(classroomService.createClassroom(classroom), HttpStatus.CREATED);
    }
    
    
//    GET http://localhost:8080/api/admin/students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
//    GET http://localhost:8080/api/admin/7/students
    @GetMapping("/{classroomId}/students")
    public ResponseEntity<List<Student>> getStudentsByClassroomId(@PathVariable Long classroomId) {
        List<Student> students = studentService.getStudentsInClassroom(classroomId);
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

// POST http://localhost:8080/api/admin/classroom/7/attendance?classroomId=7&studentId=4&date=2024-10-09&present=true
    @PostMapping("/classroom/{id}/attendance")
    public ResponseEntity<String> markAttendance(@RequestParam Long classroomId,@RequestParam Long studentId, 
            @RequestParam LocalDate date, 
            @RequestParam Boolean present) {
    	attendanceService.markAttendance(classroomId, studentId, date, present);
        return ResponseEntity.ok("Attendance marked successfully.");
    }
}