package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    // दिलेल्या product साठी सर्व reviews
    @Query(value = "SELECT * FROM reviews WHERE product_id = :productId", nativeQuery = true)
    List<Review> findByProductId(@Param("productId") Integer productId);
}
