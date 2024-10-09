package com.example.attendease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.attendease.models.Teachers;

public interface TeacherRepository extends JpaRepository<Teachers, Long>{
	 Teachers findByEmail(String email);

}
