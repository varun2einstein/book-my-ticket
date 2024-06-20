package org.booking.ticket.service;

import org.booking.ticket.model.B2BCustomer;
import org.booking.ticket.utils.exception.EntityNotFoundException;

import java.util.List;

public interface B2BCustomerService {
    B2BCustomer saveB2BCustomer(B2BCustomer b2bCustomer);

    B2BCustomer getB2BCustomerById(String customerId) throws EntityNotFoundException;

    List<B2BCustomer> getAllB2BCustomers();

    void deleteB2BCustomer(String customerId);
}
