package com.ibandorta.tickets.messaging.producer;

import com.ibandorta.tickets.entity.Ticket;
import com.ibandorta.tickets.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TicketProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;


    public TicketProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTicket(Ticket ticket){
        rabbitTemplate.convertAndSend(exchange,routingKey,ticket);
        System.out.println("Ticket enviado a RabbitMQ: " + ticket.getId());
    }
}
