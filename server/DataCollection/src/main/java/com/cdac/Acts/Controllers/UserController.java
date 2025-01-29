package com.cdac.Acts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cdac.Acts.Services.UserService;
import com.cdac.Acts.entities.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Get user details by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    // Edit user details
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User userDetails) {
        return userService.updateUser(userId, userDetails);
    }
}
