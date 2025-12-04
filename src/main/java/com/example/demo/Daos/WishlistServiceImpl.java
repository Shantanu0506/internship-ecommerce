package com.example.demo.Daos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Services.CartService;
import com.example.demo.Services.WishlistService;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.entities.Wishlist;
import com.example.demo.repos.ProductRepository;
import com.example.demo.repos.UserRepository;
import com.example.demo.repos.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    // CartService आपण आधीच केले आहे (addToCart वगैरे)
    @Autowired
    private CartService cartService;

    @Override
    public Wishlist addToWishlist(Long customerId, Long productId) {

        // आधीच wishlist मध्ये असेल तर पुन्हा add नको
        Wishlist existing = wishlistRepository
                .findByCustomer_IdAndProduct_Id(customerId, productId);

        if (existing != null) {
            return existing;
        }

        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Wishlist wishlist = new Wishlist();
        wishlist.setCustomer(customer);
        wishlist.setProduct(product);
        wishlist.setCreatedAt(LocalDateTime.now());
        wishlist.setUpdatedAt(LocalDateTime.now());

        return wishlistRepository.save(wishlist);
    }

    @Override
    public List<Wishlist> getWishlistForCustomer(Long customerId) {
        return wishlistRepository.findByCustomer_Id(customerId);
    }

    @Override
    public void removeFromWishlist(Long wishlistId) {
        wishlistRepository.deleteById(wishlistId);
    }

    @Override
    public void moveToCart(Long wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new RuntimeException("Wishlist item not found"));

        Long customerId = wishlist.getCustomer().getId();
        Long productId = wishlist.getProduct().getId();

        // cart मध्ये 1 quantity ने add कर (तुझी CartService)
        cartService.addToCart(customerId, productId, 1);

        // wishlist मधून remove
        wishlistRepository.deleteById(wishlistId);
    }
}
