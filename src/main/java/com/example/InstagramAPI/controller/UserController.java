package com.example.InstagramAPI.controller;

import com.example.InstagramAPI.model.User;
import com.example.InstagramAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@Valid @RequestBody User request) {
        try {
            String token = userService.signIn(request.getEmail(), request.getPassword());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to sign in user: " + e.getMessage());
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody User request) {
        try {
            String token = userService.signUp(request.getFirstName(), request.getLastName(),
                    request.getEmail(), request.getPassword(),
                    request.getPhoneNumber(), request.getAge());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to sign up user: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @Valid @RequestBody User request) {
        try {
            userService.updateUser(id, request.getFirstName(), request.getLastName(),
                    request.getEmail(), request.getPhoneNumber(), request.getAge());
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update user: " + e.getMessage());
        }
    }



}
