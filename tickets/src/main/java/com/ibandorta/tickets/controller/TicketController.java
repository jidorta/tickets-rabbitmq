package com.ibandorta.tickets.controller;
import com.ibandorta.tickets.dto.TicketDTO;

import com.ibandorta.tickets.dto.TicketRequestDTO;
import com.ibandorta.tickets.entity.Ticket;
import com.ibandorta.tickets.repository.TicketRepository;
import com.ibandorta.tickets.response.ApiResponse;
import com.ibandorta.tickets.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/tickets")
public class TicketController {

   private final TicketService service;


    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public Ticket create(@RequestBody TicketRequestDTO dto){
        return service.createTicket(dto);
    }

    @GetMapping
    public List<Ticket> getAll(){
        return service.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getById(@PathVariable Long id){
        return service.getTicketById(id);
    }

}
