package com.c2c.backend_java.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.c2c.backend_java.model.Application;
import com.c2c.backend_java.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/student/{studentId}/internship/{internshipId}")
    public ResponseEntity<Application> applyForInternship(
            @PathVariable Long studentId,
            @PathVariable Long internshipId) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(applicationService.applyForInternship(
                        studentId,
                        internshipId
                ));
    }

    @GetMapping
    public ResponseEntity<List<Application>> getApplicationsByStatus(
            @RequestParam(required = false) String status) {

        if (status != null && !status.isBlank()) {
            return ResponseEntity.ok(
                    applicationService.getApplicationsByStatus(status)
            );
        }

        return ResponseEntity.ok(
                applicationService.getApplicationsByStatus("APPLIED")
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                applicationService.getApplicationById(id)
        );
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Application>> getApplicationsByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                applicationService.getApplicationsByStudent(studentId)
        );
    }

    @GetMapping("/internship/{internshipId}")
    public ResponseEntity<List<Application>> getApplicationsByInternship(
            @PathVariable Long internshipId) {

        return ResponseEntity.ok(
                applicationService.getApplicationsByInternship(
                        internshipId
                )
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Application>> getApplicationsByStatusPath(
            @PathVariable String status) {

        return ResponseEntity.ok(
                applicationService.getApplicationsByStatus(status)
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Application> updateApplicationStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                applicationService.updateApplicationStatus(
                        id,
                        status
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(
            @PathVariable Long id) {

        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}