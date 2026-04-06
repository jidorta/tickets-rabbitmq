package com.ibandorta.tickets.controller;
import com.ibandorta.tickets.dto.TicketDTO;
import com.ibandorta.tickets.TicketRepository;
import com.ibandorta.tickets.entity.Ticket;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/tickets")
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody TicketDTO ticketDTO){

        //Mapeo simple DTO -> Entity
        Ticket ticket = new Ticket();
        ticket.setTitle(ticketDTO.title());
        ticket.setDescription(ticketDTO.description());

        //Guardamos en la base de datos
        Ticket savedTicket = ticketRepository.save(ticket);

        return ResponseEntity.ok(savedTicket);
    }
}
