package com.example.jwtspringbt.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {


    private final String SECRET_KEY = "4bb6d1dfbafb64a681139d1586b6f1160d18159afd57c8c79136d7490630407c";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public Boolean isValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String generateToken(UserDetails userDetails) {
        // Buat token JWT menggunakan jjwt
        String token = Jwts.builder()
                .setSubject(userDetails.getUsername()) // Atur subyek token sebagai username pengguna
                .setIssuedAt(new Date()) // Atur waktu token dikeluarkan
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Atur waktu kadaluarsa token (contohnya, 10 jam dari sekarang)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Tanda tangani token dengan kunci rahasia
                .compact(); // Kompresi token menjadi string

        return token; // Kembalikan token JWT yang telah dibuat
    }

}
