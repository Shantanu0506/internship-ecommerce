package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.WishlistService;
import com.example.demo.entities.Wishlist;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    // 1. Add to wishlist
    @PostMapping("/add")
    public Wishlist addToWishlist(@RequestParam Long customerId,
                                  @RequestParam Long productId) {
        return wishlistService.addToWishlist(customerId, productId);
    }

    // 2. View wishlist of a customer
    @GetMapping("/{customerId}")
    public List<Wishlist> getWishlist(@PathVariable Long customerId) {
        return wishlistService.getWishlistForCustomer(customerId);
    }

    // 3. Remove from wishlist
    @DeleteMapping("/{wishlistId}")
    public String remove(@PathVariable Long wishlistId) {
        wishlistService.removeFromWishlist(wishlistId);
        return "Removed from wishlist";
    }

    // 4. Move from wishlist to cart
    @PostMapping("/{wishlistId}/move-to-cart")
    public String moveToCart(@PathVariable Long wishlistId) {
        wishlistService.moveToCart(wishlistId);
        return "Moved to cart";
    }
}
