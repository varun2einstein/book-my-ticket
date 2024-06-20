package org.booking.ticket.service.impl;

import org.booking.ticket.dao.model.B2CCustomerEntity;
import org.booking.ticket.dao.repository.B2CCustomerRepository;
import org.booking.ticket.model.B2CCustomer;
import org.booking.ticket.utils.exception.EntityNotFoundException;
import org.booking.ticket.utils.mapper.B2CCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class B2CCustomerServiceImpl implements org.booking.ticket.service.B2CCustomerService {

    @Autowired
    private B2CCustomerRepository b2cCustomerRepository;

    @Override
    public B2CCustomer saveB2CCustomer(B2CCustomer b2cCustomer) {
        B2CCustomerEntity entity = B2CCustomerMapper.toEntity(b2cCustomer);
        entity = b2cCustomerRepository.save(entity);
        return B2CCustomerMapper.toDomain(entity);
    }

    @Override
    public B2CCustomer getB2CCustomerById(String customerId) throws EntityNotFoundException {
        B2CCustomerEntity entity = b2cCustomerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("B2C Customer not found with id: " + customerId));
        return B2CCustomerMapper.toDomain(entity);
    }

    @Override
    public List<B2CCustomer> getAllB2CCustomers() {
        List<B2CCustomerEntity> entities = b2cCustomerRepository.findAll();
        return entities.stream().map(B2CCustomerMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteB2CCustomer(String customerId) {
        b2cCustomerRepository.deleteById(customerId);
    }
}
