package org.booking.ticket.utils.mapper;

import org.booking.ticket.dao.model.CustomerEntity;
import org.booking.ticket.dao.model.CustomerType;
import org.booking.ticket.model.Customer;

public class CustomerMapper {

    public static CustomerEntity toEntity(Customer customer) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(customer.getId());
        entity.setCustomerType(CustomerType.valueOf(customer.getCustomerType().name()));
        entity.setEmail(customer.getEmail());
        entity.setPhone(customer.getPhone());
        entity.setAddress(customer.getAddress());
        return entity;
    }

    public static Customer toDomain(CustomerEntity entity) {
        Customer customer = new Customer();
        customer.setId(entity.getId());
        customer.setCustomerType(org.booking.ticket.model.CustomerType.valueOf(entity.getCustomerType().name()));
        customer.setEmail(entity.getEmail());
        customer.setPhone(entity.getPhone());
        customer.setAddress(entity.getAddress());
        return customer;
    }
}
