package org.booking.ticket.service.impl;

import org.booking.ticket.dao.model.B2BCustomerEntity;
import org.booking.ticket.dao.repository.B2BCustomerRepository;
import org.booking.ticket.model.B2BCustomer;
import org.booking.ticket.utils.exception.EntityNotFoundException;
import org.booking.ticket.utils.mapper.B2BCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class B2BCustomerServiceImpl implements org.booking.ticket.service.B2BCustomerService {

    @Autowired
    private B2BCustomerRepository b2bCustomerRepository;

    @Override
    public B2BCustomer saveB2BCustomer(B2BCustomer b2bCustomer) {
        B2BCustomerEntity entity = B2BCustomerMapper.toEntity(b2bCustomer);
        entity = b2bCustomerRepository.save(entity);
        return B2BCustomerMapper.toDomain(entity);
    }

    @Override
    public B2BCustomer getB2BCustomerById(String customerId) throws EntityNotFoundException {
        B2BCustomerEntity entity = b2bCustomerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("B2B Customer not found with id: " + customerId));
        return B2BCustomerMapper.toDomain(entity);
    }

    @Override
    public List<B2BCustomer> getAllB2BCustomers() {
        List<B2BCustomerEntity> entities = b2bCustomerRepository.findAll();
        return entities.stream().map(B2BCustomerMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteB2BCustomer(String customerId) {
        b2bCustomerRepository.deleteById(customerId);
    }
}
