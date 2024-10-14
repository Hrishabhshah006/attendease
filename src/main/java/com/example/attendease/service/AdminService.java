package com.example.attendease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendease.models.Admin;
import com.example.attendease.models.Attendance;
import com.example.attendease.repository.AdminRepository;
import com.example.attendease.repository.AttendanceRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private AttendanceRepository attendanceRepository;
    
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
    
    public String login(String userID, String password) {
//    	System.out.println(userID);
        Admin admin = adminRepository.findByUserID(userID);
//        System.out.println(admin);
        if (admin!= null && admin.getUserID().equals(userID) && admin.getPassword().equals(password)) {
            return "Login successful!";
        } else {
            return "Invalid username or password.";
        }       
}
//    
//    public List<Attendance> getAttendanceForStudent(Long studentId) {
//        return attendanceRepository.findByStudentId(studentId);
//    }
}