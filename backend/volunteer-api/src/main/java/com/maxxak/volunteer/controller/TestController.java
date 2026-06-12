package com.maxxak.volunteer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxxak.volunteer.model.User;
import com.maxxak.volunteer.service.UserService;

@RestController
public class TestController {

    private final UserService userService;

    public TestController(UserService userService){
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/api/test")
    public String test() {
        return "Backend Works";
    }

    @GetMapping("/api/test-user")
    public String testUser(){
        User user = new User("test-user", "test-email@gmail.com", "password");

        userService.createUser(user);

        return "user created";
    }
}
