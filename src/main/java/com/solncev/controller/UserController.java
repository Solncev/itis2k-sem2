package com.solncev.controller;

import com.solncev.model.User;
import com.solncev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/user")
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }
}
