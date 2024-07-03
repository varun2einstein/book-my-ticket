package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, String> {
    // Custom query methods can be added here
}
