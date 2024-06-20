package org.booking.ticket.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "b2b_customers")
public class B2BCustomerEntity extends CustomerEntity {
    private String companyName;
    private String industry;
    private String companySize;
    private String taxId;
}
