package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, String> {
    // Custom query methods can be added here
}
