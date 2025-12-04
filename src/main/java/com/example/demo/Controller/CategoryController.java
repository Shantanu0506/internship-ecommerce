package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.CategoryService;
import com.example.demo.dto.CategoryDashboardDto;
import com.example.demo.entities.Category;



@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Create
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    // Get All
    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    // Get By ID
    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    // Soft Delete
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        categoryService.softDeleteCategory(id);
        return "Category deactivated successfully!";
    }
    
    @GetMapping("/dashboard")
    public List<CategoryDashboardDto> getDashboard() {
        return categoryService.getCategoryDashboard();
    }
}
