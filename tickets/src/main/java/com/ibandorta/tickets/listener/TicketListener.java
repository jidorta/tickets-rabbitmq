package com.ibandorta.tickets.listener;

import com.ibandorta.tickets.entity.Ticket;
import com.ibandorta.tickets.service.TicketService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TicketListener {

    private final TicketService ticketService;

    public TicketListener(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @RabbitListener(queues = "tickets-queue")
    public void receiveTicket(Ticket ticket){
        ticketService.createTicket(ticket);
        System.out.println("Ticket recibido y guardado: " + ticket.getId());
    }

}
