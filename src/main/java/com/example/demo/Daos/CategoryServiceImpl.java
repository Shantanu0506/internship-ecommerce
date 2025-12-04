package com.example.demo.Daos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Services.CategoryService;
import com.example.demo.dto.CategoryDashboardDto;
import com.example.demo.entities.Category;
import com.example.demo.repos.CategoryRepository;



@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());
        category.setStatus(true);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category Not Found"));
    }

    @Override
    public Category updateCategory(Integer id, Category updatedCategory) {
        Category existing = getCategoryById(id);

        existing.setName(updatedCategory.getName());
        existing.setDescription(updatedCategory.getDescription());

        // इथे status पण update करायचा आहे
        if (updatedCategory.getStatus() != null) {
            existing.setStatus(updatedCategory.getStatus());
        }

        existing.setUpdatedAt(LocalDateTime.now());

        return categoryRepository.save(existing);
    }


    @Override
    public void softDeleteCategory(Integer id) {
        Category existing = getCategoryById(id);
        existing.setStatus(false);
        existing.setUpdatedAt(LocalDateTime.now());
        categoryRepository.save(existing);
    }
    
    @Override
    public List<CategoryDashboardDto> getCategoryDashboard() {
        return categoryRepository.getCategoryDashboardData();
    }
}
