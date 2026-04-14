package com.ibandorta.tickets.consumer;


import com.ibandorta.tickets.dto.TicketDTO;
import com.ibandorta.tickets.service.TicketService;
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
    private TicketService ticketService;

    @InjectMocks
    private TicketConsumer ticketConsumer;

    @Test
    void shouldProcessTicketFromQueue(){

        TicketDTO dto = new TicketDTO("Test title", "Test description");
        ticketConsumer.receiveTicket(dto);

        verify(ticketService).createTicket(any(TicketDTO.class));

    }
}
