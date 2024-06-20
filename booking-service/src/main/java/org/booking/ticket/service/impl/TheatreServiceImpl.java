package org.booking.ticket.service.impl;

import org.booking.ticket.dao.model.TheatreEntity;
import org.booking.ticket.model.Theatre;
import org.booking.ticket.dao.repository.TheatreRepository;
import org.booking.ticket.utils.exception.EntityNotFoundException;
import org.booking.ticket.utils.mapper.TheatreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements org.booking.ticket.service.TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    public Theatre saveTheatre(Theatre theatre) {
        TheatreEntity theatreEntity = TheatreMapper.theatreToTheatreEntity(theatre);
        theatreEntity = theatreRepository.save(theatreEntity);
        return TheatreMapper.theatreEntityToTheatre(theatreEntity);
    }

    @Override
    public List<Theatre> getAllTheatres() {
        List<TheatreEntity> entities = theatreRepository.findAll();
        return entities.stream().map(TheatreMapper::theatreEntityToTheatre).collect(Collectors.toList());
    }

    @Override
    public Theatre getTheatreById(String id) throws EntityNotFoundException {
        TheatreEntity entity = theatreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Support Ticket not found with id: " + id));
        return TheatreMapper.theatreEntityToTheatre(entity);
    }

    @Override
    public void deleteTheatreById(String id) {
        theatreRepository.deleteById(id);
    }
}
