package com.aryan.BMS.service;

import com.aryan.BMS.exception.ShowSeatNotAvailableException;
import com.aryan.BMS.model.ShowSeat;
import com.aryan.BMS.model.ShowSeatStatus;
import com.aryan.BMS.model.Ticket;
import com.aryan.BMS.repository.ShowRepository;
import com.aryan.BMS.repository.ShowSeatRepository;
import com.aryan.BMS.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long showId, List<Long> showSeatIds, Long userId) {
        // fetch all the given show seats from the table
        List<ShowSeat> showSeats = showSeatRepository.findByIdIn(showSeatIds);
        // Check if all of these are available
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new ShowSeatNotAvailableException("Show seat is not available");
            }
        }
        // if all are available then make them locked
        for (ShowSeat showSeat : showSeats) {
            showSeat.setSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }
        // wait for payment confirmation
        // assuming payment is done
        // create and return the ticket object
        Ticket ticket = new Ticket();
        ticket.setShowSeats(showSeats);
        ticket.setShow(showRepository.findById(showId).get());
        // mark them booked after ticket is done
        ticket = ticketRepository.save(ticket);
        for (ShowSeat showSeat : showSeats) {
            showSeat.setSeatStatus(ShowSeatStatus.BOOKED);
            showSeatRepository.save(showSeat);
        }
        return ticket;
    }
}
