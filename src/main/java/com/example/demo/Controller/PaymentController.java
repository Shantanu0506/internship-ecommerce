package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.PaymentService;
import com.example.demo.entities.Payment;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // 1. Process payment (create transaction)
    @PostMapping
    public Payment process(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }

    // 2. Dashboard - all payments
    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAllPayments();
    }

    // 3. Get by ID
    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // 4. Payments by Order
    @GetMapping("/order/{orderId}")
    public List<Payment> getByOrder(@PathVariable Long orderId) {
        return paymentService.getPaymentsByOrder(orderId);
    }

    // 5. Refund payment
    @PutMapping("/{id}/refund")
    public Payment refund(@PathVariable Long id) {
        return paymentService.refundPayment(id);
    }
}
