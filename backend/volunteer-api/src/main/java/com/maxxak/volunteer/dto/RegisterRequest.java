package com.maxxak.volunteer.dto;

public class RegisterRequest {
    private String username;
    private String email;
    private String password;

    //Constructors, getters, and setters necessary for Spring Data JPA

    public RegisterRequest() {}

    public RegisterRequest(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUser(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPass(){
        return password;
    }

    public void setUsername(String newUser){
        this.username = newUser;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public void setPassword(String newPass){
        this.password = newPass;
    }
}
