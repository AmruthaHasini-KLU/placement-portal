package com.placementportal.model;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
@Converter public class InterviewTypeConverter implements AttributeConverter<InterviewType,String> {
 public String convertToDatabaseColumn(InterviewType v){return v==null?null:v==InterviewType.ONLINE?"Online":"Offline";}
 public InterviewType convertToEntityAttribute(String v){return v==null?null:"Online".equals(v)?InterviewType.ONLINE:InterviewType.OFFLINE;}
}
