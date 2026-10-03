package com.placementportal.model;
import jakarta.persistence.*;
import java.io.Serializable;
@Embeddable
public class StudentSkillId implements Serializable {
    @Column(name = "student_id") private Long studentId;
    @Column(name = "skill_id") private Long skillId;
    public StudentSkillId() {}
    public StudentSkillId(Long studentId, Long skillId) { this.studentId = studentId; this.skillId = skillId; }
    public Long getStudentId() { return studentId; } public Long getSkillId() { return skillId; }
    @Override public boolean equals(Object o) { if (this == o) return true; if (!(o instanceof StudentSkillId other)) return false; return java.util.Objects.equals(studentId, other.studentId) && java.util.Objects.equals(skillId, other.skillId); }
    @Override public int hashCode() { return java.util.Objects.hash(studentId, skillId); }
}
