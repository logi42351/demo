package com.example.innovation.utils;

import com.example.innovation.models.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {


    public String generateToken(UserInfo userInfo){
        return generateToken(userInfo.getUsername(), userInfo.getRoles());
    }

    private String generateToken(String username,String roles) {
        int JWT_EXPIRATION = 90000;
        return Jwts.builder()
                .subject(username)
                .claim("roles", roles)
                .signWith(getSigningKey())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ JWT_EXPIRATION))
                .compact();
    }

    private SecretKey getSigningKey(){
        String JWT_SECRET = "qwertyuiopokjhgfdsadfghjklmnbvcxzxghjklgtgfghkhujhdrftygh";
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWT_SECRET));
    }

    private Claims parseToken(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private <T> T extractClaim(String token, Function<Claims,T> claims){
        Claims claims1=parseToken(token);
        return claims.apply(claims1);
    }

    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    private Boolean isTokenExpired(String token) {
        return extractClaim(token,Claims::getExpiration).before(new Date(System.currentTimeMillis()));
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }
}
