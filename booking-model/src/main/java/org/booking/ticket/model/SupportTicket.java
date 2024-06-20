package org.booking.ticket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportTicket extends BaseBean {
    private Customer customer;
    private String issueType;
    private String priority;
    private String status;
    private String createdDate;
    private String resolvedDate;
    private String assignedTo;
}
