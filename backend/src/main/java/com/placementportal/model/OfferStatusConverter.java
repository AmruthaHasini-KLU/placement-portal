package com.placementportal.model;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
@Converter public class OfferStatusConverter implements AttributeConverter<OfferStatus,String> {
 public String convertToDatabaseColumn(OfferStatus v){return v==null?null:switch(v){case PENDING->"Pending";case ACCEPTED->"Accepted";case DECLINED->"Declined";};}
 public OfferStatus convertToEntityAttribute(String v){return v==null?null:OfferStatus.valueOf(v.toUpperCase());}
}
