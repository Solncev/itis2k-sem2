package com.solncev.controller;

import com.solncev.model.User;
import com.solncev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserController(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/user")
    @ResponseBody
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    @ResponseBody
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute User user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "sign_up_success";
    }
}
