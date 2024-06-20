package org.booking.ticket.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.booking.ticket.dao.model.B2BCustomerEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface B2BCustomerRepository extends MongoRepository<B2BCustomerEntity, String> {
    // Custom query methods can be added here
}
