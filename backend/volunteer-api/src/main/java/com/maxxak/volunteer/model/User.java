package com.maxxak.volunteer.model;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    //JPA and Hibernate generated ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    //necessary default constructor for Spring Data JPA
    protected User() {}
    
    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.passwordHash = password;
    }

    //Prepersist method triggers before entity is inserted in database
    @PrePersist
    protected void onCreate(){
        this.createdAt = ZonedDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public String getUser(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassHash(){
        return passwordHash;
    }

    public ZonedDateTime getDateTime(){
        return createdAt;
    }

    public void setUsername(String newUser){
        this.username = newUser;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public void setPassHash(String newPass){
        this.passwordHash = newPass;
    }
    
}
