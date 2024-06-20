package org.booking.ticket.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "shows")
public class ShowEntity extends BaseEntity{
    @Field("theatre")
    private String theatreId;

    @Field("screens")
    private List<TheatreEntity.ScreenEntity> screens;

    @Indexed
    private MovieEntity movie;
    @Indexed
    private String showTime;
    private double price;
}
