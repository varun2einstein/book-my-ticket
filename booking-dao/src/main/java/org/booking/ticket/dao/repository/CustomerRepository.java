package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
    // Custom query methods can be added here
    CustomerEntity findByEmail(String username);
}
