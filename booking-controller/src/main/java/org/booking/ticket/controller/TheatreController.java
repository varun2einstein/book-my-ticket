package org.booking.ticket.controller;

import org.booking.ticket.model.Theatre;
import org.booking.ticket.service.TheatreService;
import org.booking.ticket.utils.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping
    public ResponseEntity<Theatre> createTheatre(@RequestBody Theatre theatre) {
        Theatre savedTheatre = theatreService.saveTheatre(theatre);
        return ResponseEntity.ok(savedTheatre);
    }

    @GetMapping
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        List<Theatre> theatres = theatreService.getAllTheatres();
        return ResponseEntity.ok(theatres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable String id) throws EntityNotFoundException {
        Theatre theatre = theatreService.getTheatreById(id);
        if (theatre != null) {
            return ResponseEntity.ok(theatre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theatre> updateTheatre(@PathVariable String id, @RequestBody Theatre theatreDetails) throws EntityNotFoundException {
        Theatre theatre = theatreService.getTheatreById(id);
        if (theatre != null) {
            Optional.ofNullable(theatreDetails.getName()).ifPresent(theatre::setName);
            Optional.ofNullable(theatreDetails.getContactInfo()).ifPresent(theatre::setContactInfo);
            Optional.ofNullable(theatreDetails.getScreens()).ifPresent(theatre::setScreens);
            Optional.ofNullable(theatreDetails.getB2bCustomer()).ifPresent(theatre::setB2bCustomer);
            Optional.ofNullable(theatreDetails.getCapacity()).ifPresent(theatre::setCapacity);
            Theatre updatedTheatre = theatreService.saveTheatre(theatre);
            return ResponseEntity.ok(updatedTheatre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable String id) {
        theatreService.deleteTheatreById(id);
        return ResponseEntity.noContent().build();
    }
}
