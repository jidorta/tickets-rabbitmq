package com.ibandorta.tickets.service;

import com.ibandorta.tickets.dto.TicketDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class TicketQueueService {

    private final RabbitTemplate rabbitTemplate;
    private static final String QUEUE_NAME ="tickets-queue";

    public TicketQueueService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTicketToQueue(TicketDTO ticketDTO){
        rabbitTemplate.convertAndSend(QUEUE_NAME, ticketDTO);
    }
}
