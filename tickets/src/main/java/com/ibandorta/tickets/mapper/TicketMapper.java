package com.ibandorta.tickets.mapper;

import com.ibandorta.tickets.dto.TicketDTO;
import com.ibandorta.tickets.entity.Ticket;

public class TicketMapper {

    public static Ticket toEntity(TicketDTO dto){
        Ticket ticket = new Ticket();
        ticket.setTitle(dto.title());
        ticket.setDescription(dto.description());
        ticket.setStatus("CREATED");
        return ticket;
    }
}
