package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Wishlist;

public interface WishlistService {

    Wishlist addToWishlist(Long customerId, Long productId);

    List<Wishlist> getWishlistForCustomer(Long customerId);

    void removeFromWishlist(Long wishlistId);

    void moveToCart(Long wishlistId);
}