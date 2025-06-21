package lk.ijse.cmjd109.LostAndFoundApplication.secureConfig;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Configuration
public class JWTUtils {
    @Value("${signature}")
    private String signature;

    private SecretKey key(){
       return Keys.hmacShaKeyFor(signature.getBytes());
    }
    public String generateToken(String username, Collection<? extends GrantedAuthority> authorities) {
       String roles = authorities.stream()
               .map(GrantedAuthority::getAuthority)
               .collect(Collectors.joining(","));
        return Jwts.builder()
                .subject(username)
                .claim("roles", roles)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(key())
                .compact();
    }

    public boolean validateToken(String token) {
        try{
            Jwts.parser()
                    .verifyWith(key()).build().parse(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public String getUserNameFrommToken(String token) {
        return Jwts.parser()
                .verifyWith(key()).build()
                .parseSignedClaims(token)
                .getPayload().getSubject();
    }
}
