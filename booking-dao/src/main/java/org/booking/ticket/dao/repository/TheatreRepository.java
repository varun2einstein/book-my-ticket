package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity, String> {
    // Custom query methods can be added here
}
