package com.aryan.BMS.controller;

import com.aryan.BMS.model.Ticket;
import com.aryan.BMS.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {
    @Autowired
    private TicketService ticketService;

    public Ticket bookTicket(Long showId, List<Long> showSeatIds, Long userId) {
        return ticketService.bookTicket(showId, showSeatIds, userId);
    }
}
