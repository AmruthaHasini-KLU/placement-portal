package com.placementportal.model;
import jakarta.persistence.*;
@Converter
public class ProficiencyConverter implements AttributeConverter<Proficiency, String> {
    public String convertToDatabaseColumn(Proficiency v) { return v == null ? null : switch (v) { case BEGINNER -> "Beginner"; case INTERMEDIATE -> "Intermediate"; case ADVANCED -> "Advanced"; }; }
    public Proficiency convertToEntityAttribute(String v) { return v == null ? null : Proficiency.valueOf(v.toUpperCase()); }
}
