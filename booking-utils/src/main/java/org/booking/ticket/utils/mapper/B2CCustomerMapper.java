package org.booking.ticket.utils.mapper;

import org.booking.ticket.dao.model.B2CCustomerEntity;
import org.booking.ticket.model.B2CCustomer;
import org.booking.ticket.model.CustomerType;
import org.springframework.stereotype.Component;

@Component
public class B2CCustomerMapper {

    public static B2CCustomer toDomain(B2CCustomerEntity entity) {
        B2CCustomer customer = new B2CCustomer();
        customer.setId(entity.getId());
        customer.setCustomerType(CustomerType.valueOf(entity.getCustomerType().name()));
        customer.setEmail(entity.getEmail());
        customer.setPhone(entity.getPhone());
        customer.setAddress(entity.getAddress());
        customer.setFirstName(entity.getFirstName());
        customer.setLastName(entity.getLastName());
        customer.setBirthdate(entity.getBirthdate());
        return customer;
    }

    public static B2CCustomerEntity toEntity(B2CCustomer customer) {
        B2CCustomerEntity entity = new B2CCustomerEntity();
        entity.setId(customer.getId());
        entity.setCustomerType(org.booking.ticket.dao.model.CustomerType.valueOf(customer.getCustomerType().name()));
        entity.setEmail(customer.getEmail());
        entity.setPhone(customer.getPhone());
        entity.setAddress(customer.getAddress());
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setBirthdate(customer.getBirthdate());
        return entity;
    }
}
