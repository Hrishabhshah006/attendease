package com.example.attendease.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.attendease.models.Classroom;
import com.example.attendease.models.Teachers;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>{
	List<Classroom> findByTeachers(Teachers teacher);
}
