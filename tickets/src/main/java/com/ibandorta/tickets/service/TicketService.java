package com.ibandorta.tickets.service;


import com.ibandorta.tickets.entity.Ticket;
import com.ibandorta.tickets.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;


    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    //Crear un ticket
    public Ticket createTicket(Ticket ticket){
        ticket.setStatus("CREATED");
        return ticketRepository.save(ticket);
    }

    //Listar todos los tickects
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    //Obtener un ticket por ID
    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tickets no encontrado: " + id));
    }

    //Actualizar un ticket (opcional)
    public Ticket updateTicket(Ticket ticket){
        if (!ticketRepository.existsById(ticket.getId())){
            throw  new RuntimeException(("Ticket no encontrado: " ticket.getId()))
        }
        return ticketRepository.save(ticket);
    }

    //Eliminar un ticket (opcional)
    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }


}
