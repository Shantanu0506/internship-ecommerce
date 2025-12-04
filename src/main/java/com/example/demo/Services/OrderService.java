package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Order;

public interface OrderService {

    Order placeOrder(Order order);          // Place new order

    List<Order> getAllOrders();            // Order dashboard

    Order getOrderById(Long id);

    Order updateOrderStatus(Long id, String newStatus);  // Pending → Shipped etc.

    void cancelOrder(Long id);             // soft delete (Cancelled)
}
