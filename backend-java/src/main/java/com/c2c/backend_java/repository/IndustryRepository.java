package com.c2c.backend_java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c2c.backend_java.model.Industry;

public interface IndustryRepository extends JpaRepository<Industry, Long> {

    Optional<Industry> findByUserId(Long userId);
}
