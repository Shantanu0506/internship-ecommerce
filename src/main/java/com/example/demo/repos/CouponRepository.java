package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    Coupon findByCouponCode(String couponCode);
}
