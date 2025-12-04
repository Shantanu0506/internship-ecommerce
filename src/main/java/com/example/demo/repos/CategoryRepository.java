package com.example.demo.repos;

import com.example.demo.dto.CategoryDashboardDto;
import com.example.demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT new com.example.demo.dto.CategoryDashboardDto(" +
            "c.id, c.name, c.description, c.status, COUNT(p)) " +
            "FROM Category c " +
            "LEFT JOIN Product p ON p.category = c AND p.status = true " +
            "GROUP BY c.id, c.name, c.description, c.status")
    List<CategoryDashboardDto> getCategoryDashboardData();
}
