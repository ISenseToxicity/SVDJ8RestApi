package nl.hsleiden.svdj8.authetication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nl.hsleiden.svdj8.models.User;
import org.springframework.beans.factory.annotation.Value;

public class AuthUtil {

    @Value("${jwt.secret}")
    private String keyToHash;

    /**
     * This Changes the given header into a user. Then we can start to check if this user is Acceptable
     *
     * @param token
     * @return A User Object
     *
     * @author Eefje
     */
    public User parseToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(keyToHash)
                    .parseClaimsJws(token)
                    .getBody();

            User u = new User();
            u.setOrigin(body.getSubject());
            u.setId(Long.parseLong((String) body.get("userId")));
            u.setOrigin((String) body.get("type"));

            return u;

        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }

    /**
     * Turns EveryThing into a JWTToken,
     * The  Hashcode to use is 256-Sha
     *
     * @param user
     * @return JWT Token
     * @author Eefje
     */
    public String generateToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getOrigin());
        claims.put("userId", user.getId() + "");
        claims.put("type", user.getType());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, keyToHash)
                .compact();
    }

}
