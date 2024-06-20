package org.booking.ticket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class B2BCustomer extends Customer {
    private String companyName;
    private String industry;
    private String companySize;
    private String taxId;
}
