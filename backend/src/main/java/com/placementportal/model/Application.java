package com.placementportal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "applications", uniqueConstraints = @UniqueConstraint(name = "uk_student_job", columnNames = {"student_id", "job_id"}))
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id") private Long applicationId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "student_id", nullable = false) private Student student;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "job_id", nullable = false) private Job job;
    @Column(name = "application_date", nullable = false) private LocalDate applicationDate;
    @Convert(converter = ApplicationStatusConverter.class)
    @Column(name = "current_status", nullable = false, columnDefinition = "ENUM('Applied','Shortlisted','Interview','Selected','Rejected','Withdrawn')")
    private ApplicationStatus currentStatus = ApplicationStatus.APPLIED;
    @PrePersist void onCreate() { if (applicationDate == null) applicationDate = LocalDate.now(); }
    public Long getApplicationId() { return applicationId; } public Long getId() { return applicationId; }
    public Student getStudent() { return student; } public void setStudent(Student v) { student = v; }
    public Job getJob() { return job; } public void setJob(Job v) { job = v; }
    public LocalDate getApplicationDate() { return applicationDate; } public LocalDate getAppliedAt() { return applicationDate; }
    public ApplicationStatus getCurrentStatus() { return currentStatus; } public ApplicationStatus getStatus() { return currentStatus; } public void setStatus(ApplicationStatus v) { currentStatus = v; }
}
