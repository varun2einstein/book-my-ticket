package org.booking.ticket.service;

import org.booking.ticket.model.B2CCustomer;
import org.booking.ticket.utils.exception.EntityNotFoundException;

import java.util.List;

public interface B2CCustomerService {
    B2CCustomer saveB2CCustomer(B2CCustomer b2cCustomer);

    B2CCustomer getB2CCustomerById(String customerId) throws EntityNotFoundException;

    List<B2CCustomer> getAllB2CCustomers();

    void deleteB2CCustomer(String customerId);
}
