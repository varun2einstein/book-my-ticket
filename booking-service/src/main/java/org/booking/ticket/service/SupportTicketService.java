package org.booking.ticket.service;

import org.booking.ticket.model.SupportTicket;
import org.booking.ticket.utils.exception.EntityNotFoundException;

import java.util.List;

public interface SupportTicketService {
    SupportTicket saveSupportTicket(SupportTicket supportTicket);

    SupportTicket getSupportTicketById(String supportTicketId) throws EntityNotFoundException;

    List<SupportTicket> getAllSupportTickets();

    void deleteSupportTicket(String supportTicketId);
}
