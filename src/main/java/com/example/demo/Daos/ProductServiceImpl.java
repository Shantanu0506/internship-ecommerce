package com.example.demo.Daos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Services.ProductService;
import com.example.demo.entities.Product;
import com.example.demo.repos.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        if (product.getStatus() == null) {
            product.setStatus(true);
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);

        existing.setName(updatedProduct.getName());
        existing.setDescription(updatedProduct.getDescription());
        existing.setPrice(updatedProduct.getPrice());
        existing.setSku(updatedProduct.getSku());
        existing.setInventoryCount(updatedProduct.getInventoryCount());
        existing.setCategory(updatedProduct.getCategory());
        existing.setStatus(updatedProduct.getStatus());
        existing.setUpdatedAt(LocalDateTime.now());

        return productRepository.save(existing);
    }

    @Override
    public void softDeleteProduct(Long id) {
        Product product = getProductById(id);
        product.setStatus(false);
        product.setUpdatedAt(LocalDateTime.now());
        productRepository.save(product);
    }
    
}
