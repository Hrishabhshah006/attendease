package com.example.attendease.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendease.models.Classroom;
import com.example.attendease.models.Admin;
import com.example.attendease.models.Attendance;
import com.example.attendease.service.AdminService;
import com.example.attendease.service.AttendanceService;
import com.example.attendease.service.ClassroomService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private ClassroomService classroomService;
    
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<>(adminService.createAdmin(admin), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> adminLogin(@RequestBody Admin request) {
        return ResponseEntity.ok("Admin logged in successfully");
    }
    
    @GetMapping("/classrooms")
    public ResponseEntity<List<Classroom>> getClassroomList() {
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        return ResponseEntity.ok(classrooms);
    }
   
    @PostMapping("/classroom")
    public ResponseEntity<Classroom> createClassroom(@RequestBody Classroom classroom) {
        return new ResponseEntity<>(classroomService.createClassroom(classroom), HttpStatus.CREATED);
    }

    @PostMapping("/classroom/{id}/attendance")
    public ResponseEntity<Void> markAttendance(
        @PathVariable Long id, 
        @RequestBody Attendance attendanceRequest) {
        
        attendanceService.markAttendance(id, attendanceRequest.getId(), attendanceRequest.getAttendanceDate(), attendanceRequest.getPresent());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}