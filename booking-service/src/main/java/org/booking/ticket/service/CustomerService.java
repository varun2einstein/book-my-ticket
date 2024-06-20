package org.booking.ticket.service;

import org.booking.ticket.model.Customer;
import org.booking.ticket.utils.exception.EntityNotFoundException;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Customer getCustomerById(String customerId) throws EntityNotFoundException;

    List<Customer> getAllCustomers();

    void deleteCustomer(String customerId);

    Customer findByUsername(String username);
}
