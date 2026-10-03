package com.placementportal.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "name", nullable = false, length = 100) private String name;
    @Column(name = "email", nullable = false, unique = true, length = 150) private String email;
    @Column(name = "branch", nullable = false, length = 50) private String branch;
    @Column(name = "graduation_year", nullable = false) private Integer graduationYear;
    @Column(name = "cgpa", nullable = false, precision = 3, scale = 2) private BigDecimal cgpa;

    public Long getStudentId() { return studentId; } public Long getId() { return studentId; }
    public String getName() { return name; } public void setName(String v) { name = v; }
    public String getEmail() { return email; } public void setEmail(String v) { email = v; }
    public String getBranch() { return branch; } public void setBranch(String v) { branch = v; }
    public Integer getGraduationYear() { return graduationYear; } public void setGraduationYear(Integer v) { graduationYear = v; }
    public BigDecimal getCgpa() { return cgpa; } public void setCgpa(BigDecimal v) { cgpa = v; }
}
