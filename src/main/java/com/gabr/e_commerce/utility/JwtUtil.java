package com.gabr.e_commerce.utility;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class JwtUtil {
    public static final String SECRET_KEY = "62e0b10e3524bd7c112a432eca099a9238e877c94d17c" +
            "f9143b676eb44b27375";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> map = new HashMap<>();
        String role = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(", "));
       map.put("role", role);
       return Jwts.builder()
               .addClaims(map)
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date(System.currentTimeMillis()+(1000 * 60 * 60 * 24)))
               .setSubject(userDetails.getUsername())
               .signWith(getSignKey(), SignatureAlgorithm.HS256)
               .compact();

}

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }
    public String extractUsername(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }
    public <T> T extractClaim(String token , Function<Claims, T> claimsResolver) {
        final Claims   claims = extractAllClims(token);
        return claimsResolver.apply(claims);
    }
    public Claims extractAllClims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public boolean  isTokenValid(String token , UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    private boolean  isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token) {
            return extractClaim(token,Claims ::getExpiration);
    }


}

