package org.booking.ticket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseBean {
    private CustomerType customerType; // "B2B" or "B2C"
    private String email;
    private String phone;
    private String passwordHash;
    private String address;
    private List<UserRole> roles;


}
