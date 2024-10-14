package com.example.attendease.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendease.models.Attendance;
import com.example.attendease.repository.AttendanceRepository;
import com.example.attendease.repository.ClassroomRepository;
import com.example.attendease.repository.StudentRepository;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;
    
    @Autowired
    private ClassroomRepository classroomRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    

    public void markAttendance(Long classroomId, Long studentId, LocalDate date, Boolean present) {
        Attendance attendance = new Attendance();
        attendance.setClassroom(classroomRepository.findById(classroomId).get());
        attendance.setStudent(studentRepository.findById(studentId).get());
        attendance.setAttendanceDate(date);
        attendance.setPresent(present);
        attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceByDate(Long classroomId, LocalDate date) {
        return attendanceRepository.findByClassroomAndAttendanceDate(classroomRepository.findById(classroomId).get(), date);
    }
    
    public List<Attendance> getAttendanceForStudent(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }
}