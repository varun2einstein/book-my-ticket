package org.booking.ticket.dao.model;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "support_ticket")
public class SupportTicketEntity extends BaseEntity{
    private CustomerEntity customer;
    private String issueType;
    private String priority;
    private String status;
    private String createdDate;
    private String resolvedDate;
    private String assignedTo;
}
