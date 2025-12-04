package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // आत्ता कोणतेही extra custom methods नकोत
}

