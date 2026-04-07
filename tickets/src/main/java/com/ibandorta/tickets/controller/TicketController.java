package com.ibandorta.tickets.controller;
import com.ibandorta.tickets.dto.TicketDTO;

import com.ibandorta.tickets.entity.Ticket;
import com.ibandorta.tickets.repository.TicketRepository;
import com.ibandorta.tickets.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/tickets")
public class TicketController {

    private final RabbitTemplate rabbitTemplate;

    private final TicketRepository ticketRepository;

    public TicketController(RabbitTemplate rabbitTemplate, TicketRepository ticketRepository){
        this.rabbitTemplate = rabbitTemplate;
        this.ticketRepository = ticketRepository;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TicketDTO>> createTicket(@Valid @RequestBody TicketDTO ticketDTO){

        rabbitTemplate.convertAndSend("tickets-queue", ticketDTO);

        ApiResponse<TicketDTO> response = new ApiResponse<>(
                "OK",
                "Ticket enaviado a cola",
                ticketDTO
        );

        return ResponseEntity.ok(response);
    }
}
