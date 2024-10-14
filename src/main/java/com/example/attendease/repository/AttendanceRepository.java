package com.example.attendease.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendease.models.Attendance;
import com.example.attendease.models.Classroom;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByClassroomAndAttendanceDate(Classroom classroom, LocalDate date);
    List<Attendance> findByStudentId(Long studentId);
}
