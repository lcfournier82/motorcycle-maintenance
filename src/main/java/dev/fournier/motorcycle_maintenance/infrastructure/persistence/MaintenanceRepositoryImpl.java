package dev.fournier.motorcycle_maintenance.infrastructure.persistence;

import dev.fournier.motorcycle_maintenance.domain.model.Maintenance;
import dev.fournier.motorcycle_maintenance.domain.repository.MaintenanceRepository;
import dev.fournier.motorcycle_maintenance.infrastructure.persistence.entity.MaintenanceEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MaintenanceRepositoryImpl implements MaintenanceRepository {

    private final MaintenanceJpaRepository jpaRepository;

    public MaintenanceRepositoryImpl(MaintenanceJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Maintenance maintenance) {
        jpaRepository.save(toEntity(maintenance));
    }

    @Override
    public List<Maintenance> findUpcoming() {
        return jpaRepository.findUpcoming(LocalDate.now().plusDays(7))
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private MaintenanceEntity toEntity(Maintenance m) {
        MaintenanceEntity e = new MaintenanceEntity();
        e.setId(m.getId());
        e.setMotorcyclePlate(m.getMotorcyclePlate());
        e.setScheduledDate(m.getScheduledDate());
        e.setDescription(m.getDescription());
        e.setNotified(m.isNotified());
        return e;
    }

    private Maintenance toDomain(MaintenanceEntity e) {
        return new Maintenance(
                e.getId(),
                e.getMotorcyclePlate(),
                e.getScheduledDate(),
                e.getDescription(),
                e.isNotified()
        );
    }
}

