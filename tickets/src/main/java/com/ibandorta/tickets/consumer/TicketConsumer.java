package com.ibandorta.tickets.consumer;


import com.ibandorta.tickets.dto.TicketDTO;
import com.ibandorta.tickets.service.TicketService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TicketConsumer {

    private final TicketService ticketService;

    public TicketConsumer(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RabbitListener(queues = "tickets-queue")
    public void receiveTicket(TicketDTO ticketDTO){
        ticketService.createTicket(ticketDTO);
        System.out.println ("Ticket procesado: " + ticketDTO);

    }
}
