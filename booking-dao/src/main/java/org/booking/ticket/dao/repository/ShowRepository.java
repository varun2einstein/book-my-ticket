package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.ShowEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends MongoRepository<ShowEntity, String> {
    // Custom query methods can be added here
}
