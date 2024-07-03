package org.booking.ticket.dao.model;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
public class TicketEntity extends BaseEntity{
    private ShowEntity show;
    private CustomerEntity customer;
    private String bookingDate;
    private String seatNumber;
    private double price;
}
