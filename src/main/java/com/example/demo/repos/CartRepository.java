package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByCustomer_Id(Long customerId);

    Cart findByCustomer_IdAndProduct_Id(Long customerId, Long productId);
}
