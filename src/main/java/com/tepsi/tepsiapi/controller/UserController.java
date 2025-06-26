package com.tepsi.tepsiapi.controller;

import com.tepsi.tepsiapi.model.User;
import com.tepsi.tepsiapi.repository.UserRepository;

import jakarta.validation.Valid;

import com.tepsi.tepsiapi.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody User user) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        if (user.getUserpassword() != null) {
            user.setUserpassword(encoder.encode(user.getUserpassword()));    
        }
        else {
            throw new IllegalArgumentException("Password cannot be null");
        }

        User savedUser = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO(
            "User Created Successfully",
            savedUser.getUserId(),
            savedUser.getUseremail()
            );
        return ResponseEntity
            .created(URI.create("/users/" + savedUser.getUserId()))
            .body(response);
    }
}
