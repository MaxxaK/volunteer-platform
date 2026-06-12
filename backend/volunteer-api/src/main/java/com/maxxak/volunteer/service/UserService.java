package com.maxxak.volunteer.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maxxak.volunteer.dto.RegisterRequest;
import com.maxxak.volunteer.model.User;
import com.maxxak.volunteer.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository USER_REPO;

    public UserService(UserRepository userRepository){
        USER_REPO = userRepository;
    }

    public void register(RegisterRequest newRequest){

    }

    public boolean userExists(String username){
        return USER_REPO.existsByUsername(username);
    }

    public boolean emailExists(String email){
        return USER_REPO.existsByEmail(email);
    }

    public Optional<User> findUserByEmail(String email){
        return USER_REPO.findByEmail(email);
    }

    public void createUser(User newUser){
        USER_REPO.save(newUser);
    }
}
