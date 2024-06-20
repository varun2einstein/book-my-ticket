package org.booking.ticket.service.impl;

import org.booking.ticket.dao.model.CustomerEntity;
import org.booking.ticket.dao.repository.CustomerRepository;
import org.booking.ticket.model.Customer;
import org.booking.ticket.service.CustomerService;
import org.booking.ticket.utils.exception.EntityNotFoundException;
import org.booking.ticket.utils.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(){

    }

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity entity = CustomerMapper.toEntity(customer);
        entity = customerRepository.save(entity);
        return CustomerMapper.toDomain(entity);
    }

    @Override
    public Customer getCustomerById(String customerId) throws EntityNotFoundException {
        CustomerEntity entity = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));
        return CustomerMapper.toDomain(entity);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<CustomerEntity> entities = customerRepository.findAll();
        return entities.stream().map(CustomerMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer findByUsername(String username) {
        return CustomerMapper.toDomain(customerRepository.findByEmail(username));
    }
}
