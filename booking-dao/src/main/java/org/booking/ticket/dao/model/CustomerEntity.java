package org.booking.ticket.dao.model;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{
    private CustomerType customerType; // "B2B" or "B2C"
    private String email;
    private String phone;
    private String passwordHash;
    private String address;


}
