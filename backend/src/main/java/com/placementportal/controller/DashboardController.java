package com.placementportal.controller;
import com.placementportal.dto.Dtos.DashboardResponse; import com.placementportal.model.ApplicationStatus; import com.placementportal.service.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/dashboard")
public class DashboardController {
 private final StudentService students; private final CompanyService companies; private final JobService jobs; private final ApplicationService applications;
 public DashboardController(StudentService s,CompanyService c,JobService j,ApplicationService a){students=s;companies=c;jobs=j;applications=a;}
 @GetMapping("/stats") public DashboardResponse stats(){return new DashboardResponse(students.count(),companies.count(),jobs.count(),jobs.open(),applications.count(),applications.count(ApplicationStatus.SELECTED),applications.count(ApplicationStatus.SHORTLISTED),applications.count(ApplicationStatus.REJECTED),applications.count(ApplicationStatus.INTERVIEW),applications.count(ApplicationStatus.SELECTED));}
}
