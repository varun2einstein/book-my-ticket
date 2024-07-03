package org.booking.ticket.dao.model;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "b2c_customer")
public class B2CCustomerEntity extends CustomerEntity {
    private String firstName;
    private String lastName;
    private String birthdate;
}
