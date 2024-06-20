package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.B2CCustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface B2CCustomerRepository extends MongoRepository<B2CCustomerEntity, String> {
}
