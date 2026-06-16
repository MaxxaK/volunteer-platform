package com.maxxak.volunteer.dto;

public class LoginRequest {
    private String email;
    private String password;

    public LoginRequest() {}

    public LoginRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPass(){
        return password;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public void setPassword(String newPass){
        this.password = newPass;
    }
}
