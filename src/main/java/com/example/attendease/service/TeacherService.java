package com.example.attendease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendease.dto.AttendanceData;
import com.example.attendease.models.Attendance;
import com.example.attendease.models.Classroom;
import com.example.attendease.models.Student;
import com.example.attendease.models.Teachers;
import com.example.attendease.repository.AttendanceRepository;
import com.example.attendease.repository.ClassroomRepository;
import com.example.attendease.repository.StudentRepository;
import com.example.attendease.repository.TeacherRepository;

import java.util.List;
import java.time.LocalDate;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    public Teachers login(String email, String password) {
        Teachers teacher = teacherRepository.findByEmail(email);
        if (teacher != null && teacher.getPassword().equals(password)) {
            return teacher;
        }
        return null;
    }

    public Classroom createClassroom(Classroom classroom, Long teacherId) {
        Teachers teacher = teacherRepository.findById(teacherId).orElse(null);
        if (teacher != null) {
            classroom.setTeacher(teacher);
            return classroomRepository.save(classroom);
        }
        return null;
    }

    public List<Classroom> getClassrooms(Long teacherId) {
        return classroomRepository.findByTeacherId(teacherId);
    }
}