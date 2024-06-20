package org.booking.ticket.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class CustomerEntity extends BaseEntity{
    private CustomerType customerType; // "B2B" or "B2C"
    private String email;
    private String phone;
    private String passwordHash;
    private String address;


}
