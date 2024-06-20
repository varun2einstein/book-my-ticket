package org.booking.ticket.utils.mapper;

import org.booking.ticket.dao.model.SupportTicketEntity;
import org.booking.ticket.model.SupportTicket;
import org.springframework.stereotype.Component;

@Component
public class SupportTicketMapper {

    public static SupportTicket toDomain(SupportTicketEntity entity) {
        SupportTicket supportTicket = new SupportTicket();
        supportTicket.setId(entity.getId());
        supportTicket.setCustomer(CustomerMapper.toDomain(entity.getCustomer()));
        supportTicket.setIssueType(entity.getIssueType());
        supportTicket.setPriority(entity.getPriority());
        supportTicket.setStatus(entity.getStatus());
        supportTicket.setCreatedDate(entity.getCreatedDate());
        supportTicket.setResolvedDate(entity.getResolvedDate());
        supportTicket.setAssignedTo(entity.getAssignedTo());
        return supportTicket;
    }

    public static SupportTicketEntity toEntity(SupportTicket supportTicket) {
        SupportTicketEntity entity = new SupportTicketEntity();
        entity.setId(supportTicket.getId());
        entity.setCustomer(CustomerMapper.toEntity(supportTicket.getCustomer()));
        entity.setIssueType(supportTicket.getIssueType());
        entity.setPriority(supportTicket.getPriority());
        entity.setStatus(supportTicket.getStatus());
        entity.setCreatedDate(supportTicket.getCreatedDate());
        entity.setResolvedDate(supportTicket.getResolvedDate());
        entity.setAssignedTo(supportTicket.getAssignedTo());
        return entity;
    }
}
