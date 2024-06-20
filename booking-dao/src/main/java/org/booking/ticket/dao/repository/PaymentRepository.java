package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentEntity, String> {
    // Custom query methods can be added here
}
