package com.dam2.project.amazin.auth;

import com.dam2.project.amazin.model.Role;
import com.dam2.project.amazin.model.User;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    //@Value("${jwt.secret}")
   //private String jwtSecret;

    private SecretKey key;

    public String generateJwtToken(Authentication authentication) {
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("ROLE", userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(",")))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 60))
                .signWith(getSigningKey())
                .compact();
    }

    public SecretKey getSigningKey(){
        Dotenv dotenv = Dotenv.load();
        //return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
        key = Keys.hmacShaKeyFor(dotenv.get("JWT_SECRET").getBytes(StandardCharsets.UTF_8));

        return key;

    }

    public Claims getJwtPayload(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }

}
