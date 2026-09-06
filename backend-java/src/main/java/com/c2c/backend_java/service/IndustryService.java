package com.c2c.backend_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.c2c.backend_java.model.Industry;
import com.c2c.backend_java.model.User;
import com.c2c.backend_java.repository.IndustryRepository;
import com.c2c.backend_java.repository.UserRepository;

@Service
public class IndustryService {

    private final IndustryRepository industryRepository;
    private final UserRepository userRepository;

    public IndustryService(IndustryRepository industryRepository,
                           UserRepository userRepository) {
        this.industryRepository = industryRepository;
        this.userRepository = userRepository;
    }

    public Industry createIndustry(Long userId, Industry industry) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (industryRepository.findByUserId(userId).isPresent()) {
            throw new RuntimeException("Industry profile already exists");
        }

        industry.setUser(user);

        return industryRepository.save(industry);
    }

    public List<Industry> getAllIndustries() {
        return industryRepository.findAll();
    }

    public Industry getIndustryById(Long id) {
        return industryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Industry not found"));
    }

    public Industry getIndustryByUserId(Long userId) {
        return industryRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Industry profile not found"));
    }

    public Industry updateIndustry(Long id, Industry updatedIndustry) {
        Industry existingIndustry = getIndustryById(id);

        existingIndustry.setCompanyName(updatedIndustry.getCompanyName());
        existingIndustry.setCompanyDescription(updatedIndustry.getCompanyDescription());
        existingIndustry.setIndustryType(updatedIndustry.getIndustryType());
        existingIndustry.setWebsite(updatedIndustry.getWebsite());
        existingIndustry.setLocation(updatedIndustry.getLocation());

        return industryRepository.save(existingIndustry);
    }

    public void deleteIndustry(Long id) {
        if (!industryRepository.existsById(id)) {
            throw new RuntimeException("Industry not found");
        }

        industryRepository.deleteById(id);
    }
}