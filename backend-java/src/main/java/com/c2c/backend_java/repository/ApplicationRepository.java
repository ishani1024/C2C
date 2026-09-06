package com.c2c.backend_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c2c.backend_java.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByStudentId(Long studentId);

    List<Application> findByInternshipId(Long internshipId);

    List<Application> findByStatus(String status);

    boolean existsByStudentIdAndInternshipId(Long studentId, Long internshipId);
}