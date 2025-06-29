package dev.fournier.motorcycle_maintenance.infrastructure.messaging;

import dev.fournier.motorcycle_maintenance.application.service.MaintenanceNotifier;
import dev.fournier.motorcycle_maintenance.domain.model.Maintenance;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RabbitMaintenanceNotifier implements MaintenanceNotifier {

    private final RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE = "maintenance.exchange";
    private static final String ROUTING_KEY = "maintenance.upcoming";

    public RabbitMaintenanceNotifier(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void notifyUpcoming(List<Maintenance> maintenances) {
        maintenances.stream()
                .filter(m -> !m.isNotified())
                .forEach(m -> rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, m));
    }
}


