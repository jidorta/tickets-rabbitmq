package com.ibandorta.tickets.dto;
import jakarta.validation.constraints.NotBlank;


public record TicketDTO(
       @NotBlank String title,
        String description
) {


}
