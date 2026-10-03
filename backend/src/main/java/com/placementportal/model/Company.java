package com.placementportal.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "companies")
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id") private Long companyId;
    @Column(name = "company_name", nullable = false, length = 150) private String companyName;
    @Column(name = "industry", nullable = false, length = 100) private String industry;
    @Column(name = "headquarters", nullable = false, length = 100) private String headquarters;
    @Column(name = "company_size") private Integer companySize;
    @Column(name = "created_at", insertable = false, updatable = false) private Instant createdAt;
    public Long getCompanyId() { return companyId; } public Long getId() { return companyId; }
    public String getCompanyName() { return companyName; } public void setCompanyName(String v) { companyName = v; }
    public String getIndustry() { return industry; } public void setIndustry(String v) { industry = v; }
    public String getHeadquarters() { return headquarters; } public void setHeadquarters(String v) { headquarters = v; }
    public Integer getCompanySize() { return companySize; } public void setCompanySize(Integer v) { companySize = v; }
    public Instant getCreatedAt() { return createdAt; }
}
