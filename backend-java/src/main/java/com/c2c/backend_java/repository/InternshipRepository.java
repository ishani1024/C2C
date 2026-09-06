package com.c2c.backend_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c2c.backend_java.model.Internship;

public interface InternshipRepository extends JpaRepository<Internship, Long> {

    List<Internship> findByIndustryId(Long industryId);

    List<Internship> findByStatus(String status);
}