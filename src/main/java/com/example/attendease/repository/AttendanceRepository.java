package com.example.attendease.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendease.models.Attendance;
import com.example.attendease.models.Classroom;
import com.example.attendease.models.Student;
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByClassroomAndDate(Classroom classroom, LocalDate date);
}
