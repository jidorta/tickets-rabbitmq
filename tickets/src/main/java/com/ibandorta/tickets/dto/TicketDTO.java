package com.ibandorta.tickets.dto;
import com.ibandorta.tickets.Enum.TickectStatus;
import jakarta.validation.constraints.NotBlank;


public record TicketDTO(
       @NotBlank String title,
        String description,
       TickectStatus status
) {


}
