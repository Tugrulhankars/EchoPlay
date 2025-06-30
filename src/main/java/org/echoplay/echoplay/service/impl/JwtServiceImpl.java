package org.echoplay.echoplay.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtServiceImpl {
    private String SECRET_KEY="SECRET_KEY";

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims=new HashMap<>();
        return null;
    }

    private String createToken(Map<String,Object> claims,String email){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJwt(token)
                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolve){
        final Claims claims=extractAllClaims(token);
        return claimsResolve.apply(claims);
    }

    public String extractEmail(String token){
        return extractClaim(token,Claims::getSubject);
    }

    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token,UserDetails userDetails){
        final String email=extractEmail(token);
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
