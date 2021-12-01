package nl.hsleiden.svdj8.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JWTEncryptService {

    public String getToken(String json) {
        Instant now = Instant.now();
        byte[] key = new byte[64];

        return Jwts.builder()
                .setSubject("Backend")
                .setAudience("Frontend")
                .claim("JsonString", json)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(30, ChronoUnit.MINUTES)))
                .signWith(Keys.hmacShaKeyFor(key))
                .compact();
    }
}
