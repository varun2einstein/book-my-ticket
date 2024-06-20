package org.booking.ticket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends BaseBean {
    private String title;
    private String description;
    private int duration; // duration in minutes
    private String language;
    private String genre;
    private String releaseDate;
}
