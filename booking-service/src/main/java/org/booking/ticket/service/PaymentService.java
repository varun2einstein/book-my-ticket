package org.booking.ticket.service;

import org.booking.ticket.model.Payment;
import org.booking.ticket.utils.exception.EntityNotFoundException;

import java.util.List;

public interface PaymentService {
    Payment savePayment(Payment payment);

    Payment getPaymentById(String paymentId) throws EntityNotFoundException;

    List<Payment> getAllPayments();

    void deletePayment(String paymentId);
}
