package org.booking.ticket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends BaseBean {
    private Ticket ticket;
    private double amount;
    private String paymentMethod;
    private String paymentDate;
}
