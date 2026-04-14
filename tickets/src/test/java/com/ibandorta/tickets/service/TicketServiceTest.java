package com.ibandorta.tickets.service;
import com.ibandorta.tickets.dto.TicketDTO;
import com.ibandorta.tickets.entity.Ticket;
import com.ibandorta.tickets.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private TicketService ticketService;

    @Test
    void shouldCreateTicketAndSendToQueue(){

        //GIVEN
        TicketDTO dto = new TicketDTO("Test title","Test description");

        Ticket savedTicket = new Ticket();
        savedTicket.setTitle("Test title");
        savedTicket.setDescription("Test description");

        when(ticketRepository.save(any(Ticket.class)))
                .thenReturn(savedTicket);

        //WHEN
        Ticket result = ticketService.createTicket(dto);

        //THEN
        assertNotNull(result);
        assertEquals("Test title", result.getTitle());

        //Verifica que se guarda en BD
        verify(ticketRepository).save(any(Ticket.class));

        //Verifica que se envia a RabbitMQ

    }
}
