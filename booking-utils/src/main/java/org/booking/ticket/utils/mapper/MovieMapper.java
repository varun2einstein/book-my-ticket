package org.booking.ticket.utils.mapper;

import org.booking.ticket.dao.model.MovieEntity;
import org.booking.ticket.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public static Movie toDomain(MovieEntity entity) {
        Movie movie = new Movie();
        movie.setId(entity.getId());
        movie.setTitle(entity.getTitle());
        movie.setDescription(entity.getDescription());
        movie.setDuration(entity.getDuration());
        movie.setLanguage(entity.getLanguage());
        movie.setGenre(entity.getGenre());
        movie.setReleaseDate(entity.getReleaseDate());
        return movie;
    }

    public static MovieEntity toEntity(Movie movie) {
        MovieEntity entity = new MovieEntity();
        entity.setId(movie.getId());
        entity.setTitle(movie.getTitle());
        entity.setDescription(movie.getDescription());
        entity.setDuration(movie.getDuration());
        entity.setLanguage(movie.getLanguage());
        entity.setGenre(movie.getGenre());
        entity.setReleaseDate(movie.getReleaseDate());
        return entity;
    }
}
