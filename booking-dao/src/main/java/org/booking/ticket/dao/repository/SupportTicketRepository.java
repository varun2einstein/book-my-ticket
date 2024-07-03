package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.SupportTicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicketEntity, String> {
    // Custom query methods can be added here
}
