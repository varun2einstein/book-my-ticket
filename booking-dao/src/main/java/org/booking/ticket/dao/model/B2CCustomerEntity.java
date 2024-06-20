package org.booking.ticket.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "b2c_customers")
public class B2CCustomerEntity extends CustomerEntity {
    private String firstName;
    private String lastName;
    private String birthdate;
}
