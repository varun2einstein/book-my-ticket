package org.booking.ticket.dao.model;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class MovieEntity extends BaseEntity{
    private String title;
    private String description;
    private int duration; // duration in minutes
    private String language;
    private String genre;
    private String releaseDate;
}
