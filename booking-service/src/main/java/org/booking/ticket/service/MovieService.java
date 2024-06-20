package org.booking.ticket.service;

import org.booking.ticket.model.Movie;
import org.booking.ticket.utils.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie saveMovie(Movie movie);

    Movie getMovieById(String movieId) throws EntityNotFoundException;

    List<Movie> getAllMovies();

    void deleteMovie(String movieId);

    List<Movie> findMovies(Optional<String> city, Optional<String> language, Optional<String> genre);
}
