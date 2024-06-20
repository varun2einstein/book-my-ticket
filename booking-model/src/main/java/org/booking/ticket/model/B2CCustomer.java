package org.booking.ticket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class B2CCustomer extends Customer {
    private String firstName;
    private String lastName;
    private String birthdate;
}
