package org.booking.ticket.service.impl;

import org.booking.ticket.dao.model.TicketEntity;
import org.booking.ticket.dao.repository.TicketRepository;
import org.booking.ticket.model.Ticket;
import org.booking.ticket.utils.exception.EntityNotFoundException;
import org.booking.ticket.utils.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements org.booking.ticket.service.TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket saveTicket(Ticket ticket) {
        TicketEntity entity = TicketMapper.toEntity(ticket);
        entity = ticketRepository.save(entity);
        return TicketMapper.toDomain(entity);
    }

    @Override
    public Ticket getTicketById(String ticketId) throws EntityNotFoundException {
        TicketEntity entity = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found with id: " + ticketId));
        return TicketMapper.toDomain(entity);
    }

    @Override
    public List<Ticket> getAllTickets() {
        List<TicketEntity> entities = ticketRepository.findAll();
        return entities.stream().map(TicketMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteTicket(String ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    @Override
    public Ticket bookTicket(Ticket ticket) {
        return TicketMapper.toDomain(ticketRepository.save(TicketMapper.toEntity(ticket)));
    }
}
