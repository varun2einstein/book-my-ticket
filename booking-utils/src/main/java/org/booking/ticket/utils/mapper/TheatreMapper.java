package org.booking.ticket.utils.mapper;

import org.booking.ticket.model.Theatre;
import org.booking.ticket.dao.model.TheatreEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TheatreMapper {

    public static TheatreEntity theatreToTheatreEntity(Theatre theatre) {
        if (theatre == null) {
            return null;
        }

        TheatreEntity theatreEntity = new TheatreEntity();
        theatreEntity.setId(theatre.getId());
        theatreEntity.setName(theatre.getName());
        theatreEntity.setCapacity(theatre.getCapacity());
        theatreEntity.setContactInfo(contactInfoToContactInfoEntity(theatre.getContactInfo()));
        theatreEntity.setScreens(screenListToScreenEntityList(theatre.getScreens()));
        theatreEntity.setB2bCustomer(B2BCustomerMapper.toEntity(theatre.getB2bCustomer()));

        return theatreEntity;
    }

    public static Theatre theatreEntityToTheatre(TheatreEntity theatreEntity) {
        if (theatreEntity == null) {
            return null;
        }

        Theatre theatre = new Theatre();
        theatre.setId(theatreEntity.getId());
        theatre.setName(theatreEntity.getName());
        theatre.setCapacity(theatreEntity.getCapacity());
        theatre.setContactInfo(contactInfoEntityToContactInfo(theatreEntity.getContactInfo()));
        theatre.setScreens(screenEntityListToScreenList(theatreEntity.getScreens()));
        theatre.setB2bCustomer(B2BCustomerMapper.toDomain(theatreEntity.getB2bCustomer()));

        return theatre;
    }

    private static Theatre.ContactInfo contactInfoEntityToContactInfo(TheatreEntity.ContactInfo contactInfoEntity) {
        if (contactInfoEntity == null) {
            return null;
        }

        Theatre.ContactInfo contactInfo = new Theatre.ContactInfo();
        contactInfo.setPhone(contactInfoEntity.getPhone());
        contactInfo.setEmail(contactInfoEntity.getEmail());
        contactInfo.setLocation(contactInfoEntity.getLocation());
        contactInfo.setAddress(contactInfoEntity.getAddress());

        return contactInfo;
    }

    private static TheatreEntity.ContactInfo contactInfoToContactInfoEntity(Theatre.ContactInfo contactInfo) {
        if (contactInfo == null) {
            return null;
        }

        TheatreEntity.ContactInfo contactInfoEntity = new TheatreEntity.ContactInfo();
        contactInfoEntity.setPhone(contactInfo.getPhone());
        contactInfoEntity.setEmail(contactInfo.getEmail());
        contactInfoEntity.setLocation(contactInfo.getLocation());
        contactInfoEntity.setAddress(contactInfo.getAddress());

        return contactInfoEntity;
    }

    public static List<TheatreEntity.ScreenEntity> screenListToScreenEntityList(List<Theatre.Screen> screens) {
        if (screens == null) {
            return null;
        }

        return screens.stream()
                .map(TheatreMapper::screenToScreenEntity)
                .collect(Collectors.toList());
    }

    public static List<Theatre.Screen> screenEntityListToScreenList(List<TheatreEntity.ScreenEntity> screenEntities) {
        if (screenEntities == null) {
            return null;
        }

        return screenEntities.stream()
                .map(TheatreMapper::screenEntityToScreen)
                .collect(Collectors.toList());
    }

    private static Theatre.Screen screenEntityToScreen(TheatreEntity.ScreenEntity screenEntity) {
        if (screenEntity == null) {
            return null;
        }

        Theatre.Screen screen = new Theatre.Screen();
        screen.setId(screenEntity.getId());
        screen.setName(screenEntity.getName());
        screen.setTheatre(theatreEntityToTheatre(screenEntity.getTheatre()));
        screen.setScreenNumber(screenEntity.getScreenNumber());
        screen.setCapacity(screenEntity.getCapacity());

        return screen;
    }

    private static TheatreEntity.ScreenEntity screenToScreenEntity(Theatre.Screen screen) {
        if (screen == null) {
            return null;
        }

        TheatreEntity.ScreenEntity screenEntity = new TheatreEntity.ScreenEntity();
        screenEntity.setId(screen.getId());
        screenEntity.setName(screen.getName());
        screenEntity.setTheatre(theatreToTheatreEntity(screen.getTheatre()));
        screenEntity.setScreenNumber(screen.getScreenNumber());
        screenEntity.setCapacity(screen.getCapacity());

        return screenEntity;
    }
}
