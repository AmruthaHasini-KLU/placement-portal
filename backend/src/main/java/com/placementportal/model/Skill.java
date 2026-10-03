package com.placementportal.model;
import jakarta.persistence.*;
@Entity @Table(name = "skills")
public class Skill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "skill_id") private Long skillId;
    @Column(name = "skill_name", nullable = false, unique = true, length = 100) private String skillName;
    @Column(name = "category", nullable = false, length = 50) private String category;
}
