package org.booking.ticket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show extends BaseBean {
    private String showId;
    private Theatre theatre;
    private List<Theatre.Screen> screens;
    private Movie movie;
    private String showTime;
    private double price;
}
