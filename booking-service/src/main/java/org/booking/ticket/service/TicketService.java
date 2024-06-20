package org.booking.ticket.service;

import org.booking.ticket.model.Ticket;
import org.booking.ticket.utils.exception.EntityNotFoundException;

import java.util.List;

public interface TicketService {
    Ticket saveTicket(Ticket ticket);

    Ticket getTicketById(String ticketId) throws EntityNotFoundException;

    List<Ticket> getAllTickets();

    void deleteTicket(String ticketId);

    Ticket bookTicket(Ticket ticket);
}
