package org.booking.ticket.dao.model;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "show")
public class ShowEntity extends BaseEntity{
    private String theatreId;
    private List<TheatreEntity.ScreenEntity> screens;
    private MovieEntity movie;
    private String showTime;
    private double price;
    private String city;
}
