package com.example.attendease.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.attendease.models.Attendance;
import com.example.attendease.models.Classroom;
import com.example.attendease.models.Student;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>{
	List<Attendance> findByClassroomIdAndDate(Long classroomId, Date date);
//	List<Attendance> findByClassroomAndDate(Classroom classroom, LocalDate date);
//    Attendance findByStudentAndClassroomAndDate(Student student, Classroom classroom,LocalDate attendanceDate);
}
