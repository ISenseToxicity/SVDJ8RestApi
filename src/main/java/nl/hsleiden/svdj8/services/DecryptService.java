package nl.hsleiden.svdj8.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class DecryptService {

    DecryptService decryptService;


    public String decrypt(String token) {
        byte[] key = new byte[64];

        Jws<Claims> result = Jwts.parserBuilder()
                .requireAudience("Backend")
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

        return result.getBody().get("Class", String.class);
    }

    public DecryptService getInstance() {
        if (decryptService == null) {
            decryptService = new DecryptService();
        }
        return decryptService;
    }

}
