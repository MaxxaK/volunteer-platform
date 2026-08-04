package com.maxxak.volunteer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxxak.volunteer.dto.LoginRequest;
import com.maxxak.volunteer.dto.RegisterRequest;
import com.maxxak.volunteer.model.User;
import com.maxxak.volunteer.service.LoginService;
import com.maxxak.volunteer.service.UserService;
import com.maxxak.volunteer.service.JwtService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final LoginService loginService;
    private final JwtService jwtService;

    public AuthController(UserService userService, LoginService loginService, JwtService jwtService){
        this.userService = userService;
        this.loginService = loginService;
        this.jwtService = jwtService;
    }

    // @CrossOrigin(origins = "http://localhost:5173")
    // @GetMapping("/api/test")
    // public String test() {
    //     return "Backend Works";
    // }

    @PostMapping("/register")
    public User testRegister(@RequestBody RegisterRequest request){
        return userService.register(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest request){
        User user = loginService.login(request);
        String token = jwtService.generateToken(user);
        System.out.println(jwtService.extractUsername(token));
        System.out.println(jwtService.isTokenValid(token, user.getEmail()));
        return new AuthenticationResponse(token);
        //return loginService.login(request);
    }

    public record AuthenticationResponse(String token) {}
}
