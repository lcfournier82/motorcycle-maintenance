package dev.fournier.motorcycle_maintenance.infrastructure.controller;

import dev.fournier.motorcycle_maintenance.application.service.MaintenanceService;
import dev.fournier.motorcycle_maintenance.domain.model.Maintenance;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@Tag(name = "Manutenções", description = "Gerenciamento de manutenções de motocicletas")
public class MaintenanceController {

    private final MaintenanceService service;

    public MaintenanceController(MaintenanceService service) {
        this.service = service;
    }

    @GetMapping("/upcoming")
    @Operation(summary = "Listar manutenções próximas")
    public ResponseEntity<List<Maintenance>> getUpcomingMaintenances() {
        return ResponseEntity.ok(service.getUpcomingMaintenances());
    }

    @PostMapping
    @Operation(summary = "Agendar nova manutenção")
    public ResponseEntity<Void> schedule(@RequestBody @Valid Maintenance maintenance) {
        service.createMaintenance(maintenance);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

