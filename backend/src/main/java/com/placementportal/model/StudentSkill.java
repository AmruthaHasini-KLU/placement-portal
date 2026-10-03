package com.placementportal.model;
import jakarta.persistence.*;
@Entity @Table(name = "student_skills")
public class StudentSkill {
    @EmbeddedId private StudentSkillId id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @MapsId("studentId") @JoinColumn(name = "student_id", nullable = false) private Student student;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @MapsId("skillId") @JoinColumn(name = "skill_id", nullable = false) private Skill skill;
    @Convert(converter = ProficiencyConverter.class) @Column(name = "proficiency", nullable = false, columnDefinition = "ENUM('Beginner','Intermediate','Advanced')") private Proficiency proficiency;
}
