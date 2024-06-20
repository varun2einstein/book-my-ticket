package org.booking.ticket.utils.mapper;

import org.booking.ticket.dao.model.TheatreEntity;
import org.booking.ticket.model.Theatre;
import org.springframework.stereotype.Component;

@Component
public class ScreenMapper {

    public static Theatre.Screen toDomain(TheatreEntity.ScreenEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Theatre.Screen screen = new Theatre.Screen();
        screen.setId(entity.getId());
        screen.setName(entity.getName());
        screen.setCapacity(entity.getCapacity());
        // Map other fields as needed
        return screen;
    }

    public static TheatreEntity.ScreenEntity toEntity(Theatre.Screen screen) {
        if (screen == null) {
            return null;
        }
        
        TheatreEntity.ScreenEntity entity = new TheatreEntity.ScreenEntity();
        entity.setId(screen.getId());
        entity.setName(screen.getName());
        entity.setCapacity(screen.getCapacity());
        // Map other fields as needed
        return entity;
    }
}
