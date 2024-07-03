package org.booking.ticket.dao.model;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class PaymentEntity extends BaseEntity{
    private TicketEntity ticket;
    private double amount;
    private String paymentMethod;
    private String paymentDate;
}
