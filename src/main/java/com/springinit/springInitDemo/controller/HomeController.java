package com.springinit.springInitDemo.controller;

import com.springinit.springInitDemo.model.Session;
import com.springinit.springInitDemo.model.User;
import com.springinit.springInitDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
//    @Autowired
//    private UserRepository userRepository;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

//    @PostMapping("user")
//    @ResponseStatus(HttpStatus.CREATED)
//    public User create(@RequestBody final User user) {
//        return userRepository.saveAndFlush(user);
//    }
}
