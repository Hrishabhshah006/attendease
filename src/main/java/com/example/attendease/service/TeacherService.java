package com.example.attendease.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendease.models.Attendance;
import com.example.attendease.models.Classroom;
import com.example.attendease.models.Student;
import com.example.attendease.models.Teachers;
import com.example.attendease.repository.AttendanceRepository;
import com.example.attendease.repository.ClassroomRepository;
import com.example.attendease.repository.StudentRepository;
import com.example.attendease.repository.TeacherRepository;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;
    
    @Autowired
    private StudentRepository studentRepository;

    public Teachers login(Long id, String password) {
        return teacherRepository.findByIdAndPassword(id, password)
                .orElseThrow(() -> new RuntimeException("Invalid login credentials"));
    }

    public List<Classroom> getClassrooms(Long teacherId) {
        return classroomRepository.findAllByTeacher_TeacherId(teacherId);
    }

    public Classroom createClassroom(Long teacherId, String className) {
        Teachers teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        Classroom classroom = new Classroom();
        classroom.setClassName(className);
        classroom.setClassCode(generateClassCode());
        classroom.setTeacher(teacher);
        return classroomRepository.save(classroom);
    }

    private String generateClassCode() {
        return UUID.randomUUID().toString();
    }

    public void takeAttendance(Long classroomId, LocalDate date, Map<Long, Boolean> attendanceData) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));
        for (Map.Entry<Long, Boolean> entry : attendanceData.entrySet()) {
            Student student = studentRepository.findById(entry.getKey())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            Attendance attendance = new Attendance();
            attendance.setClassroom(classroom);
            attendance.setStudent(student);
            attendance.setDate(date);
            attendance.setPresent(entry.getValue());
            attendanceRepository.save(attendance);
        }
    }
}
