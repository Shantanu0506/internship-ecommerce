package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Product;

public interface ProductService {
	
	Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Long id, Product updatedProduct);

    void softDeleteProduct(Long id);

}
