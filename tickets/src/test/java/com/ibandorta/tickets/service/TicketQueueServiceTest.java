package com.ibandorta.tickets.service;


import com.ibandorta.tickets.dto.TicketDTO;
import com.ibandorta.tickets.entity.Ticket;
import com.ibandorta.tickets.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TicketQueueServiceTest {



    @Test
    void shouldSendTicketToQueue(){

       //Mock del RabbitTemplate
        RabbitTemplate rabbitTemplate = Mockito.mock(RabbitTemplate.class);

        TicketQueueService service = new TicketQueueService(rabbitTemplate);

        TicketDTO ticketDTO = new TicketDTO("Test title", "Test description");

        service.sendTicketToQueue(ticketDTO);

        //Verificamos que se haya llamado al método
        Mockito.verify(rabbitTemplate).convertAndSend("tickets-queue",ticketDTO );

    }
}
