package com.substring.helpdesk.service;


import com.substring.helpdesk.entity.Ticket;
import com.substring.helpdesk.repository.TicketRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
@Setter
public class TicketService {

    private final TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Ticket ticket){
        ticket.setId(null);
        return ticketRepository.save(ticket);
    }

    public Ticket getTicket(Long ticketId){
        return ticketRepository.findById(ticketId).orElse(null);
    }

    public Ticket getTicketByEmailId(String userName){
        return ticketRepository.findByEmail(userName).orElse(null);
    }
}
