package com.example.demo.Services;

import java.util.List;

import com.example.demo.dto.CategoryDashboardDto;
import com.example.demo.entities.Category;


public interface CategoryService {

	Category createCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Integer id);

    Category updateCategory(Integer id, Category updatedCategory);

    void softDeleteCategory(Integer id);
    
    List<CategoryDashboardDto> getCategoryDashboard();

}
