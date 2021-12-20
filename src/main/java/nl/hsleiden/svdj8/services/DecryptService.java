package nl.hsleiden.svdj8.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import nl.hsleiden.svdj8.models.Data;
import nl.hsleiden.svdj8.models.User;
import nl.hsleiden.svdj8.models.tables.Admin;
import org.springframework.stereotype.Service;

@Service
public class DecryptService {

    public Admin decryptAdmin(String token) {
        byte[] key = new byte[64];

        Jws<Claims> result = Jwts.parserBuilder()
                .requireAudience("Backend")
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

        return result.getBody().get("Json", Admin.class);
    }

    public Data decryptUser(String token) {
        byte[] key = new byte[64];

        Jws<Claims> result = Jwts.parserBuilder()
                .requireAudience("FrontEnd")
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

        return result.getBody().get("Json", Data.class);
    }
}
