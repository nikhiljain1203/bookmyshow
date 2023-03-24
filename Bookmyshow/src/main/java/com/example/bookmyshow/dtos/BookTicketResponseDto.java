package com.example.bookmyshow.dtos;


import com.example.bookmyshow.models.Ticket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private ResponseStatus responseStatus;
    private Ticket ticket;
}

