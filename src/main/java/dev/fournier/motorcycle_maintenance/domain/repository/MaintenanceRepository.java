package dev.fournier.motorcycle_maintenance.domain.repository;

import dev.fournier.motorcycle_maintenance.domain.model.Maintenance;

import java.util.List;

public interface MaintenanceRepository {
    void save(Maintenance maintenance);
    List<Maintenance> findUpcoming();
}

