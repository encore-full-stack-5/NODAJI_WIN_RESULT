package com.example.win.utils;

import com.example.win.global.domain.entity.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {
    private final SecretKey secretKey;
    public UserDto getByEmailFromTokenAndValidate(String token){
        Claims payload = (Claims) Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return new UserDto(
                payload.get("userId").toString(),
                payload.get("email").toString(),
                payload.get("name").toString());
    }

    public JwtUtil(
            @Value("${token.secret}") String secret
    ) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }
}
