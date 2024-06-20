package org.booking.ticket.service.impl;

import org.booking.ticket.dao.model.SupportTicketEntity;
import org.booking.ticket.dao.repository.SupportTicketRepository;
import org.booking.ticket.model.SupportTicket;
import org.booking.ticket.utils.exception.EntityNotFoundException;
import org.booking.ticket.utils.mapper.SupportTicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupportTicketServiceImpl implements org.booking.ticket.service.SupportTicketService {

    @Autowired
    private SupportTicketRepository supportTicketRepository;

    @Override
    public SupportTicket saveSupportTicket(SupportTicket supportTicket) {
        SupportTicketEntity entity = SupportTicketMapper.toEntity(supportTicket);
        entity = supportTicketRepository.save(entity);
        return SupportTicketMapper.toDomain(entity);
    }

    @Override
    public SupportTicket getSupportTicketById(String supportTicketId) throws EntityNotFoundException {
        SupportTicketEntity entity = supportTicketRepository.findById(supportTicketId)
                .orElseThrow(() -> new EntityNotFoundException("Support Ticket not found with id: " + supportTicketId));
        return SupportTicketMapper.toDomain(entity);
    }

    @Override
    public List<SupportTicket> getAllSupportTickets() {
        List<SupportTicketEntity> entities = supportTicketRepository.findAll();
        return entities.stream().map(SupportTicketMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteSupportTicket(String supportTicketId) {
        supportTicketRepository.deleteById(supportTicketId);
    }
}
