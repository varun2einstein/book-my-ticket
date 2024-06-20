package org.booking.ticket.service.impl;

import org.booking.ticket.dao.model.PaymentEntity;
import org.booking.ticket.dao.repository.PaymentRepository;
import org.booking.ticket.model.Payment;
import org.booking.ticket.utils.exception.EntityNotFoundException;
import org.booking.ticket.utils.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements org.booking.ticket.service.PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(Payment payment) {
        PaymentEntity entity = PaymentMapper.toEntity(payment);
        entity = paymentRepository.save(entity);
        return PaymentMapper.toDomain(entity);
    }

    @Override
    public Payment getPaymentById(String paymentId) throws EntityNotFoundException {
        PaymentEntity entity = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with id: " + paymentId));
        return PaymentMapper.toDomain(entity);
    }

    @Override
    public List<Payment> getAllPayments() {
        List<PaymentEntity> entities = paymentRepository.findAll();
        return entities.stream().map(PaymentMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deletePayment(String paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
