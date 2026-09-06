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

import com.c2c.backend_java.model.Assessment;
import com.c2c.backend_java.service.AssessmentService;

@RestController
@RequestMapping("/api/assessments")
@CrossOrigin(origins = "*")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(
            AssessmentService assessmentService) {

        this.assessmentService = assessmentService;
    }

    @PostMapping("/student/{studentId}/skill/{skillId}")
    public ResponseEntity<Assessment> createAssessment(
            @PathVariable Long studentId,
            @PathVariable Long skillId,
            @RequestParam Double score) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(assessmentService.createAssessment(
                        studentId,
                        skillId,
                        score
                ));
    }

    @GetMapping
    public ResponseEntity<List<Assessment>> getAllAssessments() {

        return ResponseEntity.ok(
                assessmentService.getAllAssessments()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assessment> getAssessmentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                assessmentService.getAssessmentById(id)
        );
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Assessment>> getAssessmentsByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                assessmentService.getAssessmentsByStudent(studentId)
        );
    }

    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<Assessment>> getAssessmentsBySkill(
            @PathVariable Long skillId) {

        return ResponseEntity.ok(
                assessmentService.getAssessmentsBySkill(skillId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assessment> updateAssessment(
            @PathVariable Long id,
            @RequestParam Double score) {

        return ResponseEntity.ok(
                assessmentService.updateAssessment(
                        id,
                        score
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssessment(
            @PathVariable Long id) {

        assessmentService.deleteAssessment(id);
        return ResponseEntity.noContent().build();
    }
}