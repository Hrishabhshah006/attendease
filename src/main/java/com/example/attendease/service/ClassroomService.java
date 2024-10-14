package com.example.attendease.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendease.models.Classroom;
import com.example.attendease.repository.ClassroomRepository;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    public Classroom createClassroom(Classroom classroom) {
        classroom.setClassCode(generateUniqueClassCode());
        return classroomRepository.save(classroom);
    }
    
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    private String generateUniqueClassCode() {
        // Logic to generate random, unique class code
        return UUID.randomUUID().toString().substring(0, 6);
    }
}