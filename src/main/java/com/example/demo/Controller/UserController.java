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

import com.example.demo.Services.UserService;
import com.example.demo.entities.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Add new customer
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    // List all customers
    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    // Get by ID
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Update customer
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Soft delete / deactivate
    @DeleteMapping("/{id}")
    public String deactivate(@PathVariable Long id) {
        userService.deactivateUser(id);
        return "Customer deactivated!";
    }
}