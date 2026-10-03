package com.placementportal.model;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
@Converter public class InterviewResultConverter implements AttributeConverter<InterviewResult,String> {
 public String convertToDatabaseColumn(InterviewResult v){return v==null?null:switch(v){case PENDING->"Pending";case PASSED->"Passed";case FAILED->"Failed";};}
 public InterviewResult convertToEntityAttribute(String v){return v==null?null:InterviewResult.valueOf(v.toUpperCase());}
}
