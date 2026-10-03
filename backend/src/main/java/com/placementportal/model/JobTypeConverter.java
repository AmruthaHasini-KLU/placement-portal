package com.placementportal.model;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
@Converter
public class JobTypeConverter implements AttributeConverter<JobType, String> {
    public String convertToDatabaseColumn(JobType value) { return value == null ? null : value == JobType.FULL_TIME ? "Full-Time" : "Internship"; }
    public JobType convertToEntityAttribute(String value) { return value == null ? null : "Full-Time".equals(value) ? JobType.FULL_TIME : JobType.INTERNSHIP; }
}
