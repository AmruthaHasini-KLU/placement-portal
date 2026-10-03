package com.placementportal.dto;

import com.placementportal.model.*;
import jakarta.validation.constraints.*;
import java.time.*;
import java.math.BigDecimal;

public final class Dtos {
    private Dtos() {}
    public record StudentRequest(@NotBlank String name, @NotBlank @Email String email, String phone,
                                 @NotBlank String course, @Min(2000) Integer graduationYear,
                                 @DecimalMin("0.0") @DecimalMax("10.0") Double cgpa, String skills) {}
    public record StudentResponse(Long id, String name, String email, String phone, String course,
                                  Integer graduationYear, Double cgpa, String skills, Instant createdAt) {
        public static StudentResponse of(Student s) { return new StudentResponse(s.getId(),s.getName(),s.getEmail(),null,s.getBranch(),s.getGraduationYear(),s.getCgpa() == null ? null : s.getCgpa().doubleValue(),null,null); }
    }
    public record CompanyRequest(@NotBlank String name, String description, @Size(max=500) String website,
                                 @NotBlank @Email String email, String industry, String location) {}
    public record CompanyResponse(Long id, String name, String description, String website, String email,
                                  String industry, String location, Instant createdAt) {
        public static CompanyResponse of(Company c) { return new CompanyResponse(c.getId(),c.getCompanyName(),null,null,null,c.getIndustry(),c.getHeadquarters(),c.getCreatedAt()); }
    }
    public record JobRequest(@NotBlank String title, @NotBlank @Size(max=4000) String description, String location,
                             String employmentType, @PositiveOrZero Double salaryMin, @PositiveOrZero Double salaryMax,
                             String skills, JobStatus status, @NotNull @FutureOrPresent LocalDate applicationDeadline,
                             @NotNull Long companyId) {}
    public record JobResponse(Long id, String title, String description, String location, String employmentType,
                              Double salaryMin, Double salaryMax, String skills, JobStatus status, LocalDate applicationDeadline,
                              Long companyId, String companyName, Instant createdAt) {
        public static JobResponse of(Job j) { return new JobResponse(j.getId(),j.getJobTitle(),null,j.getLocation(),j.getJobType() == null ? null : j.getJobType().name(),j.getMinPackage() == null ? null : j.getMinPackage().doubleValue(),j.getMaxPackage() == null ? null : j.getMaxPackage().doubleValue(),null,JobStatus.OPEN,null,j.getCompany().getId(),j.getCompany().getCompanyName(),j.getPostedAt()); }
    }
    public record ApplicationRequest(@NotNull Long studentId, @NotNull Long jobId, String coverNote) {}
    public record ApplicationStatusRequest(@NotNull ApplicationStatus status) {}
    public record ApplicationResponse(Long id, Long studentId, String studentName, Long jobId, String jobTitle,
                                      Long companyId, String companyName, ApplicationStatus status, String coverNote, LocalDate appliedAt) {
        public static ApplicationResponse of(Application a) { return new ApplicationResponse(a.getId(),a.getStudent().getId(),a.getStudent().getName(),a.getJob().getId(),a.getJob().getJobTitle(),a.getJob().getCompany().getId(),a.getJob().getCompany().getCompanyName(),a.getStatus(),null,a.getAppliedAt()); }
    }
    public record DashboardResponse(long students, long companies, long jobs, long openJobs, long applications,
                                    long selected, long shortlisted, long rejected, long interviews, long offers) {}
}
