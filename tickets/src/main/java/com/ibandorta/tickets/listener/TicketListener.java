package com.ibandorta.tickets.listener;

import com.ibandorta.tickets.config.RabbitConfig;
import com.ibandorta.tickets.dto.TicketDTO;
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

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiveTicket(TicketDTO ticketDTO){
        //Lo envía al service para guardarlo
        ticketService.createTicket(ticketDTO);
        System.out.println("Ticket recibido: "  + ticketDTO.title());
    }



}
