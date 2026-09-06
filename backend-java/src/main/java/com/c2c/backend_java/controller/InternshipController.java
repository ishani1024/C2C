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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c2c.backend_java.model.Internship;
import com.c2c.backend_java.service.InternshipService;

@RestController
@RequestMapping("/api/internships")
@CrossOrigin(origins = "*")
public class InternshipController {

    private final InternshipService internshipService;

    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }

    @PostMapping("/industry/{industryId}")
    public ResponseEntity<Internship> createInternship(
            @PathVariable Long industryId,
            @RequestBody Internship internship) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(internshipService.createInternship(
                        industryId,
                        internship
                ));
    }

    @GetMapping
    public ResponseEntity<List<Internship>> getAllInternships() {
        return ResponseEntity.ok(
                internshipService.getAllInternships()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Internship> getInternshipById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                internshipService.getInternshipById(id)
        );
    }

    @GetMapping("/industry/{industryId}")
    public ResponseEntity<List<Internship>> getInternshipsByIndustry(
            @PathVariable Long industryId) {

        return ResponseEntity.ok(
                internshipService.getInternshipsByIndustry(industryId)
        );
    }

    @GetMapping("/open")
    public ResponseEntity<List<Internship>> getOpenInternships() {
        return ResponseEntity.ok(
                internshipService.getOpenInternships()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Internship> updateInternship(
            @PathVariable Long id,
            @RequestBody Internship internship) {

        return ResponseEntity.ok(
                internshipService.updateInternship(id, internship)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInternship(
            @PathVariable Long id) {

        internshipService.deleteInternship(id);
        return ResponseEntity.noContent().build();
    }
}