package com.example.attendease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendease.models.Admin;
import com.example.attendease.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
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
}