package com.example.attendease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.attendease.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	Student findByEmail(String email);
}
