package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.B2BCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface B2BCustomerRepository extends JpaRepository<B2BCustomerEntity, String> {
    // Custom query methods can be added here
}
