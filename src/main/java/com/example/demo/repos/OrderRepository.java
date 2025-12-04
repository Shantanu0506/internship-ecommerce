package com.example.demo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // status filter करायचा असल्यास पुढे वापरू शकतो
    List<Order> findByOrderStatus(String orderStatus);
    List<Order> findByCustomer_Id(Long customerId);
	Optional<Order> findById(Integer orderId);

}
