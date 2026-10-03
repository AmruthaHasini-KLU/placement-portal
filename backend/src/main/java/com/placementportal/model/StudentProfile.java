package com.placementportal.model;
import jakarta.persistence.*;
@Entity @Table(name = "student_profiles")
public class StudentProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "profile_id") private Long profileId;
    @OneToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "student_id", nullable = false, unique = true) private Student student;
    @Column(name = "phone", length = 20) private String phone;
    @Column(name = "city", length = 100) private String city;
    @Column(name = "degree", length = 100) private String degree;
    @Column(name = "specialization", length = 100) private String specialization;
    @Column(name = "bio", length = 500) private String bio;
}
