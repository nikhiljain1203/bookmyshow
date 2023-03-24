package com.example.bookmyshow.services;

import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatState;
import com.example.bookmyshow.models.Ticket;
import com.example.bookmyshow.models.TicketStatus;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.TicketRepository;
import com.example.bookmyshow.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;
    private UserRepository userRepository;

    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository,
                         TicketRepository ticketRepository,
                         UserRepository userRepository) {
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
   public Ticket bookTicket(List<Long> showSeatIds,
                      Long userId,
                      Long showId) throws ShowSeatNotAvailableException {
       // 1. Fetch show seats from the DB
       List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

       // 2. Check status of those show seats

       for (ShowSeat showSeat: showSeats) {
           if (!showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
               throw new ShowSeatNotAvailableException(showSeat.getId());
           }
       }

       // 3. If any of them is not in AVAIALBLE state throw exception
       // 4. Take a lock
       // 5. Again check if all are available./
       for (ShowSeat showSeat: showSeats) {
           showSeat.setState(ShowSeatState.LOCKED);
           showSeatRepository.save(showSeat);
       }

       // 6. If yes, create a new object of ticket and store
       Ticket ticket = new Ticket();

       Optional<User> userOptional = userRepository.findById(userId);


       ticket.setBookedBy(userOptional.get());
       ticket.setTicketStatus(TicketStatus.PENDING);
       ticket.setShowSeats(showSeats);

       return ticketRepository.save(ticket);
    }
}
