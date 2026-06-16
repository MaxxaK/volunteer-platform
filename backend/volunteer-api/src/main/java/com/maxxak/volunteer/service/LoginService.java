package com.maxxak.volunteer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maxxak.volunteer.dto.LoginRequest;
import com.maxxak.volunteer.model.User;
import com.maxxak.volunteer.repository.UserRepository;

@Service
public class LoginService {
    private final UserRepository USER_REPO;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        USER_REPO = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(LoginRequest newRequest){

        String email = newRequest.getEmail();
        String password = newRequest.getPass();
        Optional<User> userOptional = USER_REPO.findByEmail(email);

        if(userOptional.isEmpty()){
            throw new RuntimeException("Could not find email");
        }
        
        User user = userOptional.get();
        String storedHash = user.getPassHash();

        if(!passwordEncoder.matches(password, storedHash)){
            throw new RuntimeException("Invalid credentials");
        }

        return user;

    }
}
