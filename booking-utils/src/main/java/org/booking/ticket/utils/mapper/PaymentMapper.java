package org.booking.ticket.utils.mapper;

import org.booking.ticket.dao.model.PaymentEntity;
import org.booking.ticket.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public static Payment toDomain(PaymentEntity entity) {
        Payment payment = new Payment();
        payment.setId(entity.getId());
        payment.setTicket(TicketMapper.toDomain(entity.getTicket()));
        payment.setAmount(entity.getAmount());
        payment.setPaymentMethod(entity.getPaymentMethod());
        payment.setPaymentDate(entity.getPaymentDate());
        return payment;
    }

    public static PaymentEntity toEntity(Payment payment) {
        PaymentEntity entity = new PaymentEntity();
        entity.setId(payment.getId());
        entity.setTicket(TicketMapper.toEntity(payment.getTicket()));
        entity.setAmount(payment.getAmount());
        entity.setPaymentMethod(payment.getPaymentMethod());
        entity.setPaymentDate(payment.getPaymentDate());
        return entity;
    }
}
