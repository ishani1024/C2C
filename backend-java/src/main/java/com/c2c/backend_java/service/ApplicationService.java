package com.c2c.backend_java.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.c2c.backend_java.exception.ResourceNotFoundException;
import com.c2c.backend_java.model.Application;
import com.c2c.backend_java.model.Internship;
import com.c2c.backend_java.model.Student;
import com.c2c.backend_java.repository.ApplicationRepository;
import com.c2c.backend_java.repository.InternshipRepository;
import com.c2c.backend_java.repository.StudentRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final InternshipRepository internshipRepository;

    public ApplicationService(ApplicationRepository applicationRepository,
                              StudentRepository studentRepository,
                              InternshipRepository internshipRepository) {
        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.internshipRepository = internshipRepository;
    }

    public Application applyForInternship(Long studentId,
                                          Long internshipId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Internship internship = internshipRepository.findById(internshipId)
                .orElseThrow(() -> new ResourceNotFoundException("Internship not found"));

        if (applicationRepository.existsByStudentIdAndInternshipId(studentId, internshipId)) {
            throw new IllegalArgumentException("Application already exists");
        }

        Application application = new Application();

        application.setStudent(student);
        application.setInternship(internship);
        application.setStatus("APPLIED");
        application.setAppliedAt(LocalDateTime.now());

        return applicationRepository.save(application);
    }

    public List<Application> getApplicationsByStudent(Long studentId) {
        return applicationRepository.findByStudentId(studentId);
    }

    public List<Application> getApplicationsByInternship(Long internshipId) {
        return applicationRepository.findByInternshipId(internshipId);
    }

    public List<Application> getApplicationsByStatus(String status) {
        return applicationRepository.findByStatus(status);
    }

    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found"));
    }

    public Application updateApplicationStatus(Long id,
                                               String status) {

        Application application = getApplicationById(id);

        application.setStatus(status);

        return applicationRepository.save(application);
    }

    public void deleteApplication(Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Application not found");
        }

        applicationRepository.deleteById(id);
    }
}