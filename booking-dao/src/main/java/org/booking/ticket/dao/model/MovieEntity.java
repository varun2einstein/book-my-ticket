package org.booking.ticket.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movies")
public class MovieEntity extends BaseEntity{
    private String title;
    private String description;
    private int duration; // duration in minutes
    private String language;
    private String genre;
    private String releaseDate;
}
