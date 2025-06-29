package dev.fournier.motorcycle_maintenance.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Maintenance {

    private UUID id;
    private String motorcyclePlate;
    private LocalDate scheduledDate;
    private String description;
    private boolean notified; // campo persistido ou calculado

    public Maintenance() {
        // necessário para serialização (ex: Jackson)
    }

    public Maintenance(UUID id, String motorcyclePlate, LocalDate scheduledDate, String description, boolean notified) {
        this.id = id;
        this.motorcyclePlate = motorcyclePlate;
        this.scheduledDate = scheduledDate;
        this.description = description;
        this.notified = notified;
    }

    // Getters e setters

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

    // Método auxiliar
    public boolean isUpcomingWithinDays(int days) {
        return scheduledDate != null && !isNotified() && scheduledDate.isBefore(LocalDate.now().plusDays(days));
    }
}
