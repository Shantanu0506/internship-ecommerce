package com.example.demo.Controller;

import com.example.demo.Services.CouponService;
import com.example.demo.entities.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
@CrossOrigin
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/add")
    public Coupon addCoupon(@RequestBody Coupon c) {
        return couponService.createCoupon(c);
    }

    @GetMapping("/list")
    public List<Coupon> listCoupons() {
        return couponService.getAllCoupons();
    }

    @PutMapping("/update/{id}")
    public Coupon updateCoupon(@PathVariable Integer id, @RequestBody Coupon c) {
        return couponService.updateCoupon(id, c);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCoupon(@PathVariable Integer id) {
        boolean done = couponService.deleteCoupon(id);
        return done ? "Coupon Deactivated" : "Not Found";
    }

    // Example: /coupon/apply?code=NEW50&amount=1000
    @GetMapping("/apply")
    public Double applyCoupon(@RequestParam String code,
                              @RequestParam Double amount) {
        return couponService.applyCoupon(code, amount);
    }
}
