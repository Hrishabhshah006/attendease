package com.example.attendease.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendease.models.Admin;
import com.example.attendease.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
   Optional<Student> findByUsername(String username);
	List<Student> findByClassroomId(Long classroomId);
	 Student findByStudentID(String studentID);
}