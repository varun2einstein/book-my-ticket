package org.booking.ticket.service.impl;

import org.booking.ticket.dao.model.ShowEntity;
import org.booking.ticket.dao.repository.ShowRepository;
import org.booking.ticket.model.Show;
import org.booking.ticket.utils.exception.EntityNotFoundException;
import org.booking.ticket.utils.mapper.ShowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements org.booking.ticket.service.ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Override
    public Show saveShow(Show show) {
        ShowEntity entity = ShowMapper.toEntity(show);
        entity = showRepository.save(entity);
        return ShowMapper.toDomain(entity);
    }

    @Override
    public Show getShowById(String showId) throws EntityNotFoundException {
        ShowEntity entity = showRepository.findById(showId)
                .orElseThrow(() -> new EntityNotFoundException("Show not found with id: " + showId));
        return ShowMapper.toDomain(entity);
    }

    @Override
    public List<Show> getAllShows() {
        List<ShowEntity> entities = showRepository.findAll();
        return entities.stream().map(ShowMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteShow(String showId) {
        showRepository.deleteById(showId);
    }
}
