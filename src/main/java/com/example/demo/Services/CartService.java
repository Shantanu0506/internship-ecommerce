package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Cart;

public interface CartService {

    Cart addToCart(Long customerId, Long productId, int quantity);

    List<Cart> getCustomerCart(Long customerId);

    Cart updateCart(Long cartId, int quantity);

    void removeFromCart(Long cartId);
}
