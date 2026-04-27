package com.ibandorta.tickets.messaging.consumer;

import com.ibandorta.tickets.Enum.TickectStatus;
import com.ibandorta.tickets.dto.TicketRequestDTO;
import com.ibandorta.tickets.entity.Ticket;
import com.ibandorta.tickets.repository.TicketRepository;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.ibandorta.tickets.config.RabbitConfig.QUEUE;

@Service
public class TicketConsumer {

    private final TicketRepository repository;

    public TicketConsumer(TicketRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = QUEUE)
    public void consume(TicketRequestDTO dto){

        System.out.println ("Recibido desde RabbitMQ: " + dto.getDescription());
        Ticket ticket = new Ticket();
        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setStatus(TickectStatus.PENDING);
        repository.save(ticket);

    }
}
