package org.booking.ticket.dao.repository;

import org.booking.ticket.dao.model.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<MovieEntity, String> {

    @Query("{ 'city': ?0, 'language': ?1, 'genre': ?2 }")
    List<MovieEntity> findMovies(String city, String language, String genre);
}
