package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
    // Custom query methods can be added here
    CustomerEntity findByEmail(String username);
}
