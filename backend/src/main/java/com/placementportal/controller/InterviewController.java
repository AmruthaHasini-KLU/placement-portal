package com.placementportal.controller;

import com.placementportal.dto.Dtos.ApplicationResponse;
import com.placementportal.model.ApplicationStatus;
import com.placementportal.service.ApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
    private final ApplicationService applications;

    public InterviewController(ApplicationService applications) {
        this.applications = applications;
    }

    @GetMapping
    public Page<ApplicationResponse> list(Pageable pageable) {
        return applications.list(null, null, ApplicationStatus.INTERVIEW, pageable);
    }
}
