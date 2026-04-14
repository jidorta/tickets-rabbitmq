package com.ibandorta.tickets.integration;

import com.ibandorta.tickets.entity.Ticket;
import com.ibandorta.tickets.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketIntegrationTest {

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void shouldCreateTicketEndToEnd() throws Exception{

        //limpiar BD
        ticketRepository.deleteAll();

        String json = """
            {
              "title" : "Integration test",
              "description": "Testing full flow"
            }
        """;

        mocMvc.perform(post("/api/tickets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());


        //IMPORTANTE: esperar un poco a Rabbit async
        Thread.sleep(10000);
        List<Ticket> tickets = ticketRepository.findAll();

        assertEquals(1, tickets.size());
        assertEquals("Integration test", tickets.get(0).getTitle());
    }
}
