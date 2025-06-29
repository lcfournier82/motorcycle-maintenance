package dev.fournier.motorcycle_maintenance.application.service;

import dev.fournier.motorcycle_maintenance.domain.model.Maintenance;

import java.util.List;

public interface MaintenanceNotifier {
    void notifyUpcoming(List<Maintenance> maintenances);
}
