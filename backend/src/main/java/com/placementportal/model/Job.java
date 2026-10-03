package com.placementportal.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "jobs")
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id") private Long jobId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false) private Company company;
    @Column(name = "job_title", nullable = false, length = 150) private String jobTitle;
    @Convert(converter = JobTypeConverter.class)
    @Column(name = "job_type", nullable = false, columnDefinition = "ENUM('Full-Time','Internship')") private JobType jobType;
    @Column(name = "location", nullable = false, length = 100) private String location;
    @Column(name = "min_package", precision = 10, scale = 2) private BigDecimal minPackage;
    @Column(name = "max_package", precision = 10, scale = 2) private BigDecimal maxPackage;
    @Column(name = "required_experience") private Integer requiredExperience;
    @Column(name = "openings", nullable = false) private Integer openings;
    @Column(name = "posted_at", insertable = false, updatable = false) private Instant postedAt;
    public Long getJobId() { return jobId; } public Long getId() { return jobId; }
    public Company getCompany() { return company; } public void setCompany(Company v) { company = v; }
    public String getJobTitle() { return jobTitle; } public void setJobTitle(String v) { jobTitle = v; }
    public JobType getJobType() { return jobType; } public void setJobType(JobType v) { jobType = v; }
    public String getLocation() { return location; } public void setLocation(String v) { location = v; }
    public BigDecimal getMinPackage() { return minPackage; } public void setMinPackage(BigDecimal v) { minPackage = v; }
    public BigDecimal getMaxPackage() { return maxPackage; } public void setMaxPackage(BigDecimal v) { maxPackage = v; }
    public Integer getRequiredExperience() { return requiredExperience; } public void setRequiredExperience(Integer v) { requiredExperience = v; }
    public Integer getOpenings() { return openings; } public void setOpenings(Integer v) { openings = v; }
    public Instant getPostedAt() { return postedAt; }
}
