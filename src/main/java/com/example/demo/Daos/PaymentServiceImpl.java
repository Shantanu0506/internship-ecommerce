package com.example.demo.Daos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Services.PaymentService;
import com.example.demo.entities.Payment;
import com.example.demo.repos.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment processPayment(Payment payment) {
        if (payment.getPaymentStatus() == null || payment.getPaymentStatus().isEmpty()) {
            payment.setPaymentStatus("PAID");   // simulate successful payment
        }
        payment.setCreatedAt(LocalDateTime.now());
        payment.setUpdatedAt(LocalDateTime.now());
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public List<Payment> getPaymentsByOrder(Long orderId) {
        return paymentRepository.findByOrder_Id(orderId);
    }

    @Override
    public Payment refundPayment(Long id) {
        Payment payment = getPaymentById(id);
        payment.setPaymentStatus("REFUNDED");
        payment.setUpdatedAt(LocalDateTime.now());
        return paymentRepository.save(payment);
    }
}