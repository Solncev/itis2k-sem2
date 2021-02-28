package com.solncev.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam Optional<String> name) {
        return String.format("Hello, %s!", name.orElse("name"));
    }
}
