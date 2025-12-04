package com.example.demo.Daos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Services.UserService;
import com.example.demo.entities.User;
import com.example.demo.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setStatus(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        User existing = getUserById(id);

        existing.setFirstName(updatedUser.getFirstName());
        existing.setLastName(updatedUser.getLastName());
        existing.setEmail(updatedUser.getEmail());
        existing.setPhone(updatedUser.getPhone());
        existing.setStatus(updatedUser.getStatus());
        existing.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(existing);
    }

    @Override
    public void deactivateUser(Long id) {
        User user = getUserById(id);
        user.setStatus(false);
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
    }
}
