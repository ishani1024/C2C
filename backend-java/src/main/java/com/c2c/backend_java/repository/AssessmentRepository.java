package com.c2c.backend_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c2c.backend_java.model.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

    List<Assessment> findByStudentId(Long studentId);

    List<Assessment> findBySkillId(Long skillId);
}