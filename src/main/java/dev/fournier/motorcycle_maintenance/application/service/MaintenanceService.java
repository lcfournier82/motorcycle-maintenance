package dev.fournier.motorcycle_maintenance.application.service;

import dev.fournier.motorcycle_maintenance.domain.model.Maintenance;
import dev.fournier.motorcycle_maintenance.domain.repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {

    private final MaintenanceRepository repository;
    private final MaintenanceNotifier notifier;
    private final CacheService cacheService;

    public MaintenanceService(MaintenanceRepository repository, MaintenanceNotifier notifier, CacheService cacheService) {
        this.repository = repository;
        this.notifier = notifier;
        this.cacheService = cacheService;
    }

    public List<Maintenance> getUpcomingMaintenances() {
        return cacheService.getOrLoad("upcoming_maintenances", () -> {
            List<Maintenance> maintenances = repository.findUpcoming();
            notifier.notifyUpcoming(maintenances);
            return maintenances;
        });
    }

    public void createMaintenance(Maintenance maintenance) {
        repository.save(maintenance);
        cacheService.evict("upcoming_maintenances");
    }
}
