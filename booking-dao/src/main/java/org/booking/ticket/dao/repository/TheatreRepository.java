package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.TheatreEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends MongoRepository<TheatreEntity, String> {
    // Custom query methods can be added here
}
