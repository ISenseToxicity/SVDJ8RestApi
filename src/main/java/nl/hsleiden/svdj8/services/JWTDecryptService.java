package nl.hsleiden.svdj8.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JWTDecryptService {

    public String decryptToken(String token) {
        byte[] key = new byte[64];

        Jws<Claims> result = Jwts.parserBuilder()
                .requireAudience("Backend")
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

        return result.getBody().get("Json", String.class);
    }
}
