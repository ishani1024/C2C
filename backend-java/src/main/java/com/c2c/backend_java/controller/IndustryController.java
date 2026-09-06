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

import com.c2c.backend_java.model.Industry;
import com.c2c.backend_java.service.IndustryService;

@RestController
@RequestMapping("/api/industries")
@CrossOrigin(origins = "*")
public class IndustryController {

    private final IndustryService industryService;

    public IndustryController(IndustryService industryService) {
        this.industryService = industryService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Industry> createIndustry(
            @PathVariable Long userId,
            @RequestBody Industry industry) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(industryService.createIndustry(userId, industry));
    }

    @GetMapping
    public ResponseEntity<List<Industry>> getAllIndustries() {
        return ResponseEntity.ok(industryService.getAllIndustries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Industry> getIndustryById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                industryService.getIndustryById(id)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Industry> getIndustryByUserId(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                industryService.getIndustryByUserId(userId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Industry> updateIndustry(
            @PathVariable Long id,
            @RequestBody Industry industry) {

        return ResponseEntity.ok(
                industryService.updateIndustry(id, industry)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIndustry(
            @PathVariable Long id) {

        industryService.deleteIndustry(id);
        return ResponseEntity.noContent().build();
    }
}