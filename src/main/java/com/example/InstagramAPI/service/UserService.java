package com.example.InstagramAPI.service;

import com.example.InstagramAPI.model.AuthenticationToken;
import com.example.InstagramAPI.model.User;
import com.example.InstagramAPI.repository.AuthenticationTokenRepository;
import com.example.InstagramAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationTokenRepository authTokenRepository;

    public String signIn(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("Invalid email or password");
        }

        // Check if the password matches
        if (!user.getPassword().equals(password)) {
            throw new Exception("Invalid email or password");
        }

        // Generate an authentication token and save it to the database
        String token = UUID.randomUUID().toString();
        AuthenticationToken authToken = new AuthenticationToken();
        authToken.setToken(token);
        authToken.setUser(user);
        authTokenRepository.save(authToken);

        return token;
    }

    public String signUp(String firstName, String lastName, String email, String password,
                         String phoneNumber, Integer age) throws Exception {
        // Check if the email is already taken
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            throw new Exception("Email already taken");
        }

        // Create a new user and save it to the database
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setAge(age);
        userRepository.save(user);

        // Generate an authentication token and save it to the database
        String token = UUID.randomUUID().toString();
        AuthenticationToken authToken = new AuthenticationToken();
        authToken.setToken(token);
        authToken.setUser(user);
        authTokenRepository.save(authToken);

        return token;
    }

    public void updateUser(Long id, String firstName, String lastName, String email,
                           String phoneNumber, Integer age) throws Exception {
        // Check if the user exists
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new Exception("User not found");
        }

        // Update the user details
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAge(age);
        userRepository.save(user);
    }
}
