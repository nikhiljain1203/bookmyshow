package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.BookTicketRequestDto;
import com.example.bookmyshow.dtos.BookTicketResponseDto;
import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.models.Ticket;
import com.example.bookmyshow.services.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {

        return null;
    }
}
