package com.maxxak.volunteer.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import com.maxxak.volunteer.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtException;

@Service
public class JwtService {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(User user){
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date exp = new Date(nowMillis + 3600000);

        //decided users can only login with email for now, so email is the one included in the token
        return Jwts.builder().subject(user.getEmail()).issuedAt(now).expiration(exp).signWith(getSigningKey()).compact();
    }

    private Claims extractAllClaims(String token) {
    return Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    public String extractUsername(String token){
        return extractAllClaims(token).getSubject();
    }

    public Date extractExpiration(String token){
        return extractAllClaims(token).getExpiration();
    }

    public boolean isTokenValid(String token, String email){
        try {
            return extractUsername(token).equals(email)
                    && extractExpiration(token).after(new Date());

        } catch (JwtException e) {

        }
        return false;
    }

}
