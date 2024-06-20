package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.SupportTicketEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportTicketRepository extends MongoRepository<SupportTicketEntity, String> {
    // Custom query methods can be added here
}
