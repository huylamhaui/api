package lamph11.api.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtService {

    private static final String SECRET = "allJFioijEf838&^*y";
    private static final long EXPIRE_TIME = 3 * 60 * 60 * 60 * 1000;


    public static String generateToken(Authentication authentication) {
        String name = authentication.getName();
        List<String> roles = authentication.getAuthorities()
            .stream().map(item -> item.getAuthority())
            .collect(Collectors.toList());
        
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + EXPIRE_TIME);
        String token = Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .setIssuedAt(now)
            .setExpiration(expireDate)
            .setSubject(name)
            .claim("roles", roles)
            .compact();
        return token;
    }


    public static Authentication generateAuthentication(String token) {
        return new UsernamePasswordAuthenticationToken(
            "username", 
            "password",
            Collections.emptyList()
        );
    }
}
