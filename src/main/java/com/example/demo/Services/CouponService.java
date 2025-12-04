package com.example.demo.Services;

import com.example.demo.entities.Coupon;
import com.example.demo.repos.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepo;

    // CREATE
    public Coupon createCoupon(Coupon c) {
        c.setCreatedAt(LocalDateTime.now());
        c.setUpdatedAt(LocalDateTime.now());
        return couponRepo.save(c);
    }

    // LIST ALL
    public List<Coupon> getAllCoupons() {
        return couponRepo.findAll();
    }

    // UPDATE
    public Coupon updateCoupon(Integer id, Coupon c) {
        Coupon old = couponRepo.findById(id).orElse(null);
        if (old == null) return null;

        old.setCouponCode(c.getCouponCode());
        old.setDiscountType(c.getDiscountType());
        old.setDiscountValue(c.getDiscountValue());
        old.setValidFrom(c.getValidFrom());
        old.setValidTo(c.getValidTo());
        old.setUsageLimit(c.getUsageLimit());
        old.setStatus(c.getStatus());
        old.setUpdatedAt(LocalDateTime.now());

        return couponRepo.save(old);
    }

    // DELETE / DEACTIVATE (soft delete)
    public boolean deleteCoupon(Integer id) {
        Coupon c = couponRepo.findById(id).orElse(null);
        if (c == null) return false;

        c.setStatus(false);
        couponRepo.save(c);
        return true;
    }

    // APPLY COUPON
    public Double applyCoupon(String code, Double amount) {

        Coupon c = couponRepo.findByCouponCode(code);

        // coupon सापडला नाही किंवा inactive असेल
        if (c == null || !Boolean.TRUE.equals(c.getStatus())) {
            return amount;
        }

        LocalDateTime now = LocalDateTime.now();

        // date null नसेल तेव्हाच check कर
        if (c.getValidFrom() != null && now.isBefore(c.getValidFrom())) {
            return amount;
        }
        if (c.getValidTo() != null && now.isAfter(c.getValidTo())) {
            return amount;
        }

        // usage limit check
        if (c.getUsageLimit() != null && c.getUsed() != null
                && c.getUsed() >= c.getUsageLimit()) {
            return amount;
        }

        double finalAmount = amount;

        if (c.getDiscountType() != null && c.getDiscountValue() != null) {
            if ("Percentage".equalsIgnoreCase(c.getDiscountType())) {
                finalAmount = amount - (amount * c.getDiscountValue() / 100.0);
            } else if ("Fixed".equalsIgnoreCase(c.getDiscountType())) {
                finalAmount = amount - c.getDiscountValue();
            }
        }

        // negative नको
        if (finalAmount < 0) {
            finalAmount = 0.0;
        }

        // usage counter वाढव
        if (c.getUsed() == null) {
            c.setUsed(0);
        }
        c.setUsed(c.getUsed() + 1);
        c.setUpdatedAt(LocalDateTime.now());
        couponRepo.save(c);

        return finalAmount;
    }
}
