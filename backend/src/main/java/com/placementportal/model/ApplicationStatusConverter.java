package com.placementportal.model;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Locale;

@Converter
public class ApplicationStatusConverter implements AttributeConverter<ApplicationStatus, String> {
    public String convertToDatabaseColumn(ApplicationStatus value) { return value == null ? null : value.name().substring(0, 1) + value.name().substring(1).toLowerCase(Locale.ROOT); }
    public ApplicationStatus convertToEntityAttribute(String value) { return value == null ? null : ApplicationStatus.valueOf(value.toUpperCase(Locale.ROOT)); }
}
