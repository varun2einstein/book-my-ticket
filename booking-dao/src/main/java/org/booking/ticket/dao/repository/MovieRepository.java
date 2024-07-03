package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, String> {

    @Query("SELECT m FROM Movie m WHERE m.language = :language AND m.genre = : genre")
    List<MovieEntity> findMovies(String language, String genre);
}
