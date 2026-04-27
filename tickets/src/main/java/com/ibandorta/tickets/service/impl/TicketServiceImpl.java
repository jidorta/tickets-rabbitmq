package com.ibandorta.tickets.service.impl;



import com.ibandorta.tickets.Enum.TickectStatus;
import com.ibandorta.tickets.dto.TicketRequestDTO;
import com.ibandorta.tickets.entity.Ticket;
import com.ibandorta.tickets.mapper.TicketMapper;
import com.ibandorta.tickets.messaging.producer.TicketProducer;
import com.ibandorta.tickets.repository.TicketRepository;
import com.ibandorta.tickets.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {


    private final TicketRepository repository;
    private final TicketProducer producer;
    private static final Logger log = LoggerFactory.getLogger(TicketServiceImpl.class);

    public TicketServiceImpl( TicketRepository repository, TicketProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }


    @Override
    public Ticket createTicket(TicketRequestDTO dto) {

        Ticket ticket = new Ticket(
                dto.getTitle(),
                dto.getDescription()
        );

        ticket.setStatus(TickectStatus.PENDING);

        Ticket saved = repository.save(ticket);
        log.info("Antes de enviar a RabbitMQ");
        producer.sendTicket(saved);
        log.info("Después de enviar a RabbitMQ");

        //enviamos a RabbitMQ
        return saved;

    }

    @Override
    public List<Ticket> getAllTickets() {
        return repository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
      return repository.findById(id)
              .orElseThrow(()-> new RuntimeException("Ticket no encontrado"));

    }
}
