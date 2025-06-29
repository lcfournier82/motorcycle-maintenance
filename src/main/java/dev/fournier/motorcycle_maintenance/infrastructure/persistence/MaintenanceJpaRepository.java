package dev.fournier.motorcycle_maintenance.infrastructure.persistence;

import dev.fournier.motorcycle_maintenance.infrastructure.persistence.entity.MaintenanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface MaintenanceJpaRepository extends JpaRepository<MaintenanceEntity, UUID> {

    @Query("SELECT m FROM MaintenanceEntity m WHERE m.scheduledDate <= :date AND m.notified = false")
    List<MaintenanceEntity> findUpcoming(LocalDate date);
}
