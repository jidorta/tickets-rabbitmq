package com.ibandorta.tickets.consumer;


import com.ibandorta.tickets.dto.TicketDTO;
import com.ibandorta.tickets.dto.TicketRequestDTO;
import com.ibandorta.tickets.entity.Ticket;
import com.ibandorta.tickets.messaging.consumer.TicketConsumer;
import com.ibandorta.tickets.service.impl.TicketServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TicketConsumerTest {

    @Mock
    private TicketServiceImpl ticketService;

    @InjectMocks
    private TicketConsumer ticketConsumer;

    @Test
    void shouldProcessTicketFromQueue(){

        TicketRequestDTO ticketdto = new TicketRequestDTO("Test title", "Test description");
        ticketConsumer.consume(ticketdto);

        verify(ticketService).createTicket(any(TicketRequestDTO.class));

    }
}
