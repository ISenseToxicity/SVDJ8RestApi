package nl.hsleiden.svdj8.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class EncryptService {

    EncryptService encryptService;

    public String encrypt(String json) {
        Instant now = Instant.now();
        byte[] thisShouldBeASecretKey = "5HQ0CgAg4Y".getBytes();

        return Jwts.builder()
                .setSubject("Backend")
                .setAudience("Frontend")
                .claim("JsonString", json)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.MINUTES)))
                .signWith(Keys.hmacShaKeyFor(thisShouldBeASecretKey))
                .compact();
    }
}
