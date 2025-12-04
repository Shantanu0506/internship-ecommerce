package com.example.demo.repos;


import com.example.demo.entities.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {

    // हा नवा method वापर:
    List<Shipping> findByOrder_Id(Integer orderId);
}
