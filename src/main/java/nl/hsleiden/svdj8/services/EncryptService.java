package nl.hsleiden.svdj8.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class EncryptService {

    EncryptService encryptService;

    public String encrypt(String json) {
        Instant now = Instant.now();
        byte[] thisShouldBeASecretKey = new byte[64];

        return Jwts.builder()
                .setSubject("Backend")
                .setAudience("Frontend")
                .claim("JsonString", json)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.MINUTES)))
                .signWith(Keys.hmacShaKeyFor(thisShouldBeASecretKey))
                .compact();
    }

    public EncryptService getInstance() {
        if (encryptService == null) {
            encryptService = new EncryptService();
        }
        return encryptService;
    }

}
