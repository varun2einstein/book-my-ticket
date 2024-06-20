package org.booking.ticket.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tickets")
public class TicketEntity extends BaseEntity{
    @Indexed
    private ShowEntity show;
    @Indexed
    private CustomerEntity customer;
    private String bookingDate;
    private String seatNumber;
    private double price;
}
