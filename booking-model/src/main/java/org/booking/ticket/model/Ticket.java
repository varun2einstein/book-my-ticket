package org.booking.ticket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseBean {
    private Show show;
    private Customer customer;
    private String bookingDate;
    private String seatNumber;
    private double price;
}
