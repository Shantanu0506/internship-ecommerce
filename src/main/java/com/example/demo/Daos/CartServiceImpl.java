package com.example.demo.Daos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Services.CartService;
import com.example.demo.entities.Cart;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.repos.CartRepository;
import com.example.demo.repos.ProductRepository;
import com.example.demo.repos.UserRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart addToCart(Long customerId, Long productId, int quantity) {

        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart existing = cartRepository.findByCustomer_IdAndProduct_Id(customerId, productId);

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + quantity);
            existing.setTotalPrice(existing.getQuantity() * product.getPrice());
            existing.setUpdatedAt(LocalDateTime.now());
            return cartRepository.save(existing);
        }

        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setProduct(product);
        cart.setQuantity(quantity);
        cart.setTotalPrice(quantity * product.getPrice());
        cart.setCreatedAt(LocalDateTime.now());
        cart.setUpdatedAt(LocalDateTime.now());

        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCustomerCart(Long customerId) {
        return cartRepository.findByCustomer_Id(customerId);
    }

    @Override
    public Cart updateCart(Long cartId, int quantity) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        cart.setQuantity(quantity);
        cart.setTotalPrice(quantity * cart.getProduct().getPrice());
        cart.setUpdatedAt(LocalDateTime.now());

        return cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
