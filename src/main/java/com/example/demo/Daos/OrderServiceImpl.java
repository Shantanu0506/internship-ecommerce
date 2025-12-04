package com.example.demo.Daos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Services.OrderService;
import com.example.demo.entities.Order;
import com.example.demo.repos.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order) {
        // default values
        if (order.getOrderStatus() == null || order.getOrderStatus().isEmpty()) {
            order.setOrderStatus("PENDING");
        }
        order.setStatus(true);
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order updateOrderStatus(Long id, String newStatus) {
        Order order = getOrderById(id);
        order.setOrderStatus(newStatus);
        order.setUpdatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Long id) {
        Order order = getOrderById(id);
        order.setOrderStatus("CANCELLED");
        order.setStatus(false);  // soft delete flag
        order.setUpdatedAt(LocalDateTime.now());
        orderRepository.save(order);
    }
}