package com.cdac.Acts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD

import com.cdac.Acts.services.UserService;
=======
import com.cdac.Acts.Services.UserService;
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
import com.cdac.Acts.dto.LoginRequest;
import com.cdac.Acts.dto.SignUpRequest;
import com.cdac.Acts.entities.User;

<<<<<<< HEAD
=======
//Controller to Handles user registration, authentication, and profile management
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
<<<<<<< HEAD

=======
    
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody SignUpRequest signUpRequest ) {
        return userService.registerUser(signUpRequest);
    }

    //Sign In a new user
    @PostMapping("/signin")
    public ResponseEntity<?> signInUser(@RequestBody LoginRequest loginRequest ) {
        Object response = userService.signInUser(loginRequest);
        return ResponseEntity.ok(response);
    }

    // Get user details by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    // Edit user details
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User userDetails) {
        return userService.updateUser(userId, userDetails);
    }
}
