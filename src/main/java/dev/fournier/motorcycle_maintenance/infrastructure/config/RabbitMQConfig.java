package dev.fournier.motorcycle_maintenance.infrastructure.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "maintenance.queue";
    public static final String EXCHANGE = "maintenance.exchange";
    public static final String ROUTING_KEY = "maintenance.upcoming";

    @Bean
    public Queue maintenanceQueue() {
        return QueueBuilder.durable(QUEUE).build();
    }

    @Bean
    public TopicExchange maintenanceExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding maintenanceBinding(Queue maintenanceQueue, TopicExchange maintenanceExchange) {
        return BindingBuilder
                .bind(maintenanceQueue)
                .to(maintenanceExchange)
                .with(ROUTING_KEY);
    }
}
