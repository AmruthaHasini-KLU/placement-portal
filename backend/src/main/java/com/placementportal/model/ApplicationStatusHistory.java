package com.placementportal.model;
import jakarta.persistence.*;
import java.time.Instant;
@Entity @Table(name = "application_status_history")
public class ApplicationStatusHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "history_id") private Long historyId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "application_id", nullable = false) private Application application;
    @Column(name = "old_status", length = 30) private String oldStatus;
    @Column(name = "new_status", nullable = false, length = 30) private String newStatus;
    @Column(name = "changed_at", insertable = false, updatable = false) private Instant changedAt;
    @Column(name = "remarks", length = 255) private String remarks;
}
