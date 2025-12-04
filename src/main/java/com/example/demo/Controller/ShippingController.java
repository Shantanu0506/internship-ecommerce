package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Order;
import com.example.demo.entities.Shipping;
import com.example.demo.repos.OrderRepository;
import com.example.demo.repos.ShippingRepository;

@RestController
@RequestMapping("/api/shipping")
@CrossOrigin("*")
public class ShippingController {

    @Autowired
    private ShippingRepository shippingRepo;

    @Autowired
    private OrderRepository orderRepo;

    @PostMapping("/add/{orderId}")
    public Shipping addShipping(@PathVariable Integer orderId, @RequestBody Shipping shipping) {
        Order order = orderRepo.findById(orderId).orElse(null);
        if (order == null) return null;

        shipping.setOrder(order);
        return shippingRepo.save(shipping);
    }

    @GetMapping
    public List<Shipping> getAllShipping() {
        return shippingRepo.findAll();
    }

    @GetMapping("/order/{orderId}")
    public List<Shipping> getByOrder(@PathVariable Integer orderId) {
        return shippingRepo.findByOrder_Id(orderId);       // ✅ नवा method
    }


    @PutMapping("/{id}")
    public Shipping updateShipping(@PathVariable Integer id, @RequestBody Shipping updated) {
        Shipping sh = shippingRepo.findById(id).orElse(null);
        if (sh == null) return null;

        sh.setCourierService(updated.getCourierService());
        sh.setTrackingNumber(updated.getTrackingNumber());
        sh.setShippingStatus(updated.getShippingStatus());
        sh.setShippingCost(updated.getShippingCost());

        return shippingRepo.save(sh);
    }
}

