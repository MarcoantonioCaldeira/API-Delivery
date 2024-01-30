package com.apidelivery.models.service.impl;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtTokenProvider {

    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationInMs);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            // Tratamento para token inválido
        } catch (MalformedJwtException ex) {
            // Tratamento para token malformado
        } catch (ExpiredJwtException ex) {
            // Tratamento para token expirado
        } catch (UnsupportedJwtException ex) {
            // Tratamento para token não suportado
        } catch (IllegalArgumentException ex) {
            // Tratamento para argumento ilegal
        }
        return false;
    }
}
