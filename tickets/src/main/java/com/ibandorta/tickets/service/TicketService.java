package com.ibandorta.tickets.service;

import com.ibandorta.tickets.dto.TicketRequestDTO;
import com.ibandorta.tickets.entity.Ticket;

import java.util.List;

public interface TicketService {

    Ticket createTicket(TicketRequestDTO dto);

    List<Ticket> getAllTickets();

    Ticket getTicketById(Long id);

}
