package org.booking.ticket.utils.mapper;

import org.booking.ticket.dao.model.B2BCustomerEntity;
import org.booking.ticket.model.B2BCustomer;
import org.booking.ticket.model.CustomerType;
import org.springframework.stereotype.Component;

@Component
public class B2BCustomerMapper {

    public static B2BCustomer toDomain(B2BCustomerEntity entity) {
        B2BCustomer customer = new B2BCustomer();
        customer.setId(entity.getId());
        customer.setCustomerType(CustomerType.valueOf(entity.getCustomerType().name()));
        customer.setEmail(entity.getEmail());
        customer.setPhone(entity.getPhone());
        customer.setAddress(entity.getAddress());
        customer.setCompanyName(entity.getCompanyName());
        customer.setIndustry(entity.getIndustry());
        customer.setCompanySize(entity.getCompanySize());
        customer.setTaxId(entity.getTaxId());
        return customer;
    }

    public static B2BCustomerEntity toEntity(B2BCustomer customer) {
        B2BCustomerEntity entity = new B2BCustomerEntity();
        entity.setId(customer.getId());
        entity.setCustomerType(org.booking.ticket.dao.model.CustomerType.valueOf(customer.getCustomerType().name()));
        entity.setEmail(customer.getEmail());
        entity.setPhone(customer.getPhone());
        entity.setAddress(customer.getAddress());
        entity.setCompanyName(customer.getCompanyName());
        entity.setIndustry(customer.getIndustry());
        entity.setCompanySize(customer.getCompanySize());
        entity.setTaxId(customer.getTaxId());
        return entity;
    }
}
