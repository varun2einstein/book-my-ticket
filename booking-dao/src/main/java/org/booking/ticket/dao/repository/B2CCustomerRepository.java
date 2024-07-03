package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.B2CCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface B2CCustomerRepository extends JpaRepository<B2CCustomerEntity, String> {
}
