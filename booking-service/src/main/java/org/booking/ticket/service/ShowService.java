package org.booking.ticket.service;

import org.booking.ticket.model.Show;
import org.booking.ticket.utils.exception.EntityNotFoundException;

import java.util.List;

public interface ShowService {
    Show saveShow(Show show);

    Show getShowById(String showId) throws EntityNotFoundException;

    List<Show> getAllShows();

    void deleteShow(String showId);
}
