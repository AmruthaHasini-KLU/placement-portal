package com.placementportal.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name = "interviews")
public class Interview {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "interview_id") private Long interviewId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "application_id", nullable = false) private Application application;
    @Column(name = "interview_round", nullable = false) private Integer interviewRound;
    @Convert(converter = InterviewTypeConverter.class) @Column(name = "interview_type", nullable = false, columnDefinition = "ENUM('Online','Offline')") private InterviewType interviewType;
    @Column(name = "scheduled_at", nullable = false) private LocalDateTime scheduledAt;
    @Column(name = "interviewer_name", length = 100) private String interviewerName;
    @Convert(converter = InterviewResultConverter.class) @Column(name = "result", columnDefinition = "ENUM('Pending','Passed','Failed')") private InterviewResult result;
}
