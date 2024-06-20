package org.booking.ticket.utils.mapper;

import org.booking.ticket.dao.model.TicketEntity;
import org.booking.ticket.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public static Ticket toDomain(TicketEntity entity) {
        Ticket ticket = new Ticket();
        ticket.setId(entity.getId());
        ticket.setShow(ShowMapper.toDomain(entity.getShow()));
        ticket.setCustomer(CustomerMapper.toDomain(entity.getCustomer()));
        ticket.setBookingDate(entity.getBookingDate());
        ticket.setSeatNumber(entity.getSeatNumber());
        ticket.setPrice(entity.getPrice());
        return ticket;
    }

    public static TicketEntity toEntity(Ticket ticket) {
        TicketEntity entity = new TicketEntity();
        entity.setId(ticket.getId());
        entity.setShow(ShowMapper.toEntity(ticket.getShow()));
        entity.setCustomer(CustomerMapper.toEntity(ticket.getCustomer()));
        entity.setBookingDate(ticket.getBookingDate());
        entity.setSeatNumber(ticket.getSeatNumber());
        entity.setPrice(ticket.getPrice());
        return entity;
    }
}
