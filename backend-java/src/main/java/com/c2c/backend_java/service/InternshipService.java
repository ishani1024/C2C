package com.c2c.backend_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.c2c.backend_java.model.Industry;
import com.c2c.backend_java.model.Internship;
import com.c2c.backend_java.repository.IndustryRepository;
import com.c2c.backend_java.repository.InternshipRepository;

@Service
public class InternshipService {

    private final InternshipRepository internshipRepository;
    private final IndustryRepository industryRepository;

    public InternshipService(InternshipRepository internshipRepository,
                             IndustryRepository industryRepository) {
        this.internshipRepository = internshipRepository;
        this.industryRepository = industryRepository;
    }

    public Internship createInternship(Long industryId,
                                       Internship internship) {

        Industry industry = industryRepository.findById(industryId)
                .orElseThrow(() -> new RuntimeException("Industry not found"));

        internship.setIndustry(industry);

        return internshipRepository.save(internship);
    }

    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    public Internship getInternshipById(Long id) {
        return internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found"));
    }

    public List<Internship> getInternshipsByIndustry(Long industryId) {
        return internshipRepository.findByIndustryId(industryId);
    }

    public List<Internship> getOpenInternships() {
        return internshipRepository.findByStatus("OPEN");
    }

    public Internship updateInternship(Long id,
                                       Internship updatedInternship) {

        Internship existingInternship = getInternshipById(id);

        existingInternship.setTitle(updatedInternship.getTitle());
        existingInternship.setDescription(updatedInternship.getDescription());
        existingInternship.setLocation(updatedInternship.getLocation());
        existingInternship.setWorkMode(updatedInternship.getWorkMode());
        existingInternship.setDuration(updatedInternship.getDuration());
        existingInternship.setStipend(updatedInternship.getStipend());
        existingInternship.setApplicationDeadline(
                updatedInternship.getApplicationDeadline()
        );
        existingInternship.setStatus(updatedInternship.getStatus());

        return internshipRepository.save(existingInternship);
    }

    public void deleteInternship(Long id) {
        if (!internshipRepository.existsById(id)) {
            throw new RuntimeException("Internship not found");
        }

        internshipRepository.deleteById(id);
    }
}