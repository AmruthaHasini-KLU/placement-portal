package com.placementportal.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name = "offers")
public class Offer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "offer_id") private Long offerId;
    @OneToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "application_id", nullable = false, unique = true) private Application application;
    @Column(name = "offered_role", nullable = false, length = 150) private String offeredRole;
    @Column(name = "annual_package", nullable = false, precision = 10, scale = 2) private BigDecimal annualPackage;
    @Column(name = "offer_date", nullable = false) private LocalDate offerDate;
    @Column(name = "joining_date") private LocalDate joiningDate;
    @Convert(converter = OfferStatusConverter.class) @Column(name = "offer_status", columnDefinition = "ENUM('Pending','Accepted','Declined')") private OfferStatus offerStatus;
}
