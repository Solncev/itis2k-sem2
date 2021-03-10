package com.solncev.controller;

import com.solncev.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello(@RequestParam Optional<String> name) {
        return String.format("Hello, %s!", name.orElse("name"));
    }

    @GetMapping("")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/sign_up")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }
}
