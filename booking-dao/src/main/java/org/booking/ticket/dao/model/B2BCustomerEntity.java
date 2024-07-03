package org.booking.ticket.dao.model;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "b2b_customer")
public class B2BCustomerEntity extends CustomerEntity {
    private String companyName;
    private String industry;
    private String companySize;
    private String taxId;
}
