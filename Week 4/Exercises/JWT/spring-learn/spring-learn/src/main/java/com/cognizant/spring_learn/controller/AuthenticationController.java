package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;
import java.security.Key;

@RestController
public class AuthenticationController {

    private static final Key key = Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkey".getBytes());

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START - authenticate()");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String username = getUser(authHeader);
        String token = generateJwt(username);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("END - authenticate()");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("START - getUser()");
        
        // Remove "Basic " prefix
        String encodedCredentials = authHeader.substring("Basic ".length());
        
        // Decode base64 to username:password
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decoded = new String(decodedBytes);
        LOGGER.debug("Decoded Credentials: {}", decoded);
        
        // Extract username
        String username = decoded.split(":")[0];

        LOGGER.debug("Username: {}", username);
        LOGGER.debug("END - getUser()");

        return username;
    }

    private String generateJwt(String user) {
    LOGGER.debug("START - generateJwt()");

    String token = Jwts.builder()
            .setSubject(user)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)) // 20 minutes
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();

    LOGGER.debug("Generated Token: {}", token);
    LOGGER.debug("END - generateJwt()");
    return token;
}
}
