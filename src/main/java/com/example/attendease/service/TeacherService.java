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

import java.util.List;
import java.time.LocalDate;

@Service
public class TeacherService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Attendance> takeAttendance(Long teacherId, Long classroomId, List<AttendanceData> attendanceData) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));

        LocalDate attendanceDate = LocalDate.now(); // Get current date or use the date from the first AttendanceData object

        for (AttendanceData data : attendanceData) {
            Student student = studentRepository.findById(data.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            Attendance attendance = attendanceRepository.findByStudentAndClassroomAndDate(student, classroom, attendanceDate);
                   
            attendance.setPresent(data.isPresent());
            attendance.setDate(attendanceDate);  // Update the date
            attendanceRepository.save(attendance);
        }

        return attendanceRepository.findByClassroomAndDate(classroom, attendanceDate); // Update to return based on date if necessary
    }

}
