package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {
	 	User createUser(User user);

	    List<User> getAllUsers();

	    User getUserById(Long id);

	    User updateUser(Long id, User updatedUser);

	    void deactivateUser(Long id);
	}