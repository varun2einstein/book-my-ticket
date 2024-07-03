package org.booking.ticket.controller;

import org.booking.ticket.model.Movie;
import org.booking.ticket.model.Ticket;
import org.booking.ticket.service.MovieService;
import org.booking.ticket.service.TicketService;
import org.booking.ticket.utils.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(
            @RequestParam Optional<String> language,
            @RequestParam Optional<String> genre) {

        List<Movie> movies = movieService.findMovies(language, genre);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id) throws EntityNotFoundException {
        Movie movie = movieService.getMovieById(id);
        return Optional.ofNullable(movie).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/book")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket ticket) {
        Ticket bookedTicket = ticketService.bookTicket(ticket);
        return ResponseEntity.ok(bookedTicket);
    }
}
