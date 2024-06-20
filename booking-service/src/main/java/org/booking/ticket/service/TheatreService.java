package org.booking.ticket.service;

import org.booking.ticket.dao.model.TheatreEntity;
import org.booking.ticket.model.Theatre;
import org.booking.ticket.utils.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TheatreService {
    Theatre saveTheatre(Theatre theatre);

    List<Theatre> getAllTheatres();

    Theatre getTheatreById(String id) throws EntityNotFoundException;

    void deleteTheatreById(String id);
}
