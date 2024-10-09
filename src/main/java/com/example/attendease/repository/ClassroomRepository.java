package com.example.attendease.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendease.models.Classroom;
import com.example.attendease.models.Teachers;
@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    Optional<Classroom> findByClassCode(String classCode);

	List<Classroom> findAllByTeacher_TeacherId(Long teacherId);
}
