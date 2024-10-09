package com.example.attendease.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendease.models.Teachers;

@Repository
public interface TeacherRepository extends JpaRepository<Teachers, Long> {
    Optional<Teachers> findByIdAndPassword(Long id, String password);
}
