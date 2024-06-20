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
@Document(collection = "payments")
public class PaymentEntity extends BaseEntity{
    @Indexed
    private TicketEntity ticket;
    private double amount;
    private String paymentMethod;
    private String paymentDate;
}
