package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, String> {
    // Custom query methods can be added here
}
