package com.cdac.Acts.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cdac.Acts.Repositories.UserRepository;
import com.cdac.Acts.entities.User;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public ResponseEntity<User> registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body(null); // Username already exists
        }

        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setActive(true); // Set the user to active on creation
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(201).body(savedUser);
    }

    // Get user details by ID
    public ResponseEntity<User> getUserById(Integer userId) {
        return userRepository.findById(userId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Edit user details
    public ResponseEntity<User> updateUser(Integer userId, User userDetails) {
        return userRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setUsername(userDetails.getUsername());
                    existingUser.setFullName(userDetails.getFullName());
                    existingUser.setRole(userDetails.getRole());
                    existingUser.setPasswordHash(userDetails.getPasswordHash());
                    existingUser.setRefreshToken(userDetails.getRefreshToken());
                    existingUser.setUpdatedAt(LocalDateTime.now());
                    User updatedUser = userRepository.save(existingUser);
                    return ResponseEntity.ok(updatedUser);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
