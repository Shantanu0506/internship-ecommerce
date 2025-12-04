package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Payment;

public interface PaymentService {

    Payment processPayment(Payment payment);  // create payment, mark as PAID or FAILED

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id);

    List<Payment> getPaymentsByOrder(Long orderId);

    Payment refundPayment(Long id);           // mark as REFUNDED
}