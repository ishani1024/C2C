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

import com.c2c.backend_java.model.LearningResource;
import com.c2c.backend_java.service.LearningResourceService;

@RestController
@RequestMapping("/api/learning-resources")
@CrossOrigin(origins = "*")
public class LearningResourceController {

    private final LearningResourceService learningResourceService;

    public LearningResourceController(
            LearningResourceService learningResourceService) {

        this.learningResourceService = learningResourceService;
    }

    @PostMapping("/skill/{skillId}")
    public ResponseEntity<LearningResource> createResource(
            @PathVariable Long skillId,
            @RequestBody LearningResource resource) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(learningResourceService.createResource(
                        skillId,
                        resource
                ));
    }

    @GetMapping
    public ResponseEntity<List<LearningResource>> getAllResources() {
        return ResponseEntity.ok(
                learningResourceService.getAllResources()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningResource> getResourceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                learningResourceService.getResourceById(id)
        );
    }

    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<LearningResource>> getResourcesBySkill(
            @PathVariable Long skillId) {

        return ResponseEntity.ok(
                learningResourceService.getResourcesBySkill(skillId)
        );
    }

    @GetMapping("/provider/{provider}")
    public ResponseEntity<List<LearningResource>> getResourcesByProvider(
            @PathVariable String provider) {

        return ResponseEntity.ok(
                learningResourceService.getResourcesByProvider(provider)
        );
    }

    @GetMapping("/type/{resourceType}")
    public ResponseEntity<List<LearningResource>> getResourcesByType(
            @PathVariable String resourceType) {

        return ResponseEntity.ok(
                learningResourceService.getResourcesByType(
                        resourceType
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningResource> updateResource(
            @PathVariable Long id,
            @RequestBody LearningResource resource) {

        return ResponseEntity.ok(
                learningResourceService.updateResource(
                        id,
                        resource
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(
            @PathVariable Long id) {

        learningResourceService.deleteResource(id);
        return ResponseEntity.noContent().build();
    }
}