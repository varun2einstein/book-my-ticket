package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.TicketEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends MongoRepository<TicketEntity, String> {
    // Custom query methods can be added here
}
