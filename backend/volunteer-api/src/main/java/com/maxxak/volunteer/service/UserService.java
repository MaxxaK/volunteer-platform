package com.maxxak.volunteer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maxxak.volunteer.dto.RegisterRequest;
import com.maxxak.volunteer.model.User;
import com.maxxak.volunteer.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository USER_REPO;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        USER_REPO = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest newRequest){

        String username = newRequest.getUsername();
        String email = newRequest.getEmail();
        String password = newRequest.getPass();

        if(validUsername(username)){
            throw new RuntimeException("Invalid username");
        } 
        
        if(validEmail(email)){
            throw new RuntimeException("Invalid email");
        }
        
        if(validPassword(password)){
            throw new RuntimeException("Invalid password");
        }
        
        if(usernameExists(username)){
            throw new RuntimeException("username already exists"); 
        }
        if(emailExists(email)){
            throw new RuntimeException("email already in use");
        }

        String hashedPassword = passwordEncoder.encode(password);

        User user = new User(username, email, hashedPassword);

        return USER_REPO.save(user);
    }

    public boolean usernameExists(String username){
        return USER_REPO.existsByUsername(username);
    }

    public boolean validUsername(String username){
        boolean validUser = true;
        //look into java RegEx as I literally just copied and pasted this from other user validation implementations
        String userRegex = "^(?i)(?!(admin|support|root|help)$)(?![a-zA-Z0-9_.-]*[._-]{2})[a-zA-Z][a-zA-Z0-9_.-]{4,23}[a-zA-Z0-9]$";

        if(!username.matches(userRegex))
            validUser = false;

        return validUser;
    }

    public boolean emailExists(String email){
        return USER_REPO.existsByEmail(email);
    }

    public boolean validEmail(String email){
        boolean validEmail = true;

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        if(!email.matches(emailRegex))
            validEmail = false;

        return validEmail;
    }

    public Optional<User> findUserByEmail(String email){
        return USER_REPO.findByEmail(email);
    }

    public boolean validPassword(String password){
        boolean validPassword = true;

        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,32}$";
        
        if(!password.matches(passwordRegex))
            validPassword = false;

        return validPassword;
    }

    public void createUser(User newUser){
        USER_REPO.save(newUser);
    }
}
