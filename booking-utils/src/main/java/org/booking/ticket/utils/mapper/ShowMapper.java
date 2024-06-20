package org.booking.ticket.utils.mapper;

import org.booking.ticket.dao.model.ShowEntity;
import org.booking.ticket.model.Show;
import org.springframework.stereotype.Component;

@Component
public class ShowMapper {

    public static Show toDomain(ShowEntity entity) {
        Show show = new Show();
        show.setShowId(entity.getId());
        show.setScreens(TheatreMapper.screenEntityListToScreenList(entity.getScreens()));
        show.setMovie(MovieMapper.toDomain(entity.getMovie()));
        show.setShowTime(entity.getShowTime());
        show.setPrice(entity.getPrice());
        return show;
    }

    public static ShowEntity toEntity(Show show) {
        ShowEntity entity = new ShowEntity();
        entity.setId(show.getShowId());
        entity.setScreens(TheatreMapper.screenListToScreenEntityList(show.getScreens()));
        entity.setMovie(MovieMapper.toEntity(show.getMovie()));
        entity.setShowTime(show.getShowTime());
        entity.setPrice(show.getPrice());
        return entity;
    }
}
