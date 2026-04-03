package com.bank.manager.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET =
            "minha-chave-super-secreta-minha-chave-super-secreta";

    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60
                        )
                )

                .signWith(
                        SignatureAlgorithm.HS256,
                        SECRET.getBytes()
                )

                .compact();
    }

    public String extractUsername(String token) {

        Claims claims = Jwts.parser()

                .setSigningKey(SECRET.getBytes())

                .parseClaimsJws(token)

                .getBody();

        return claims.getSubject();
    }
}