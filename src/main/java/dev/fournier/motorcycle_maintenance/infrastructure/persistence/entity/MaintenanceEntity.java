package dev.fournier.motorcycle_maintenance.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "maintenance")
public class MaintenanceEntity {

    @Id
    private UUID id;

    @Column(name = "motorcycle_plate", nullable = false)
    private String motorcyclePlate;

    @Column(name = "scheduled_date", nullable = false)
    private LocalDate scheduledDate;

    @Column(name = "description")
    private String description;

    @Column(name = "notified")
    private boolean notified;

    public MaintenanceEntity() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMotorcyclePlate() {
        return motorcyclePlate;
    }

    public void setMotorcyclePlate(String motorcyclePlate) {
        this.motorcyclePlate = motorcyclePlate;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }
}

