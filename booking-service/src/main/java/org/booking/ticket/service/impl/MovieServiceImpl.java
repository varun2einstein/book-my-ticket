package org.booking.ticket.service.impl;

import org.booking.ticket.dao.model.MovieEntity;
import org.booking.ticket.dao.repository.MovieRepository;
import org.booking.ticket.model.Movie;
import org.booking.ticket.utils.exception.EntityNotFoundException;
import org.booking.ticket.utils.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements org.booking.ticket.service.MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie saveMovie(Movie movie) {
        MovieEntity entity = MovieMapper.toEntity(movie);
        entity = movieRepository.save(entity);
        return MovieMapper.toDomain(entity);
    }

    @Override
    public Movie getMovieById(String movieId) throws EntityNotFoundException {
        MovieEntity entity = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id: " + movieId));
        return MovieMapper.toDomain(entity);
    }

    @Override
    public List<Movie> getAllMovies() {
        List<MovieEntity> entities = movieRepository.findAll();
        return entities.stream().map(MovieMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public List<Movie> findMovies(Optional<String> language, Optional<String> genre) {
        return movieRepository.findMovies(language.orElse(null), genre.orElse(null)).stream().map(MovieMapper::toDomain).toList();
    }
}
