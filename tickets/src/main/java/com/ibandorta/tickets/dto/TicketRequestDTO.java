package com.ibandorta.tickets.dto;

public class TicketRequestDTO {

    private String title;
    private String description;

    public TicketRequestDTO(String testTitle, String testDescription) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
