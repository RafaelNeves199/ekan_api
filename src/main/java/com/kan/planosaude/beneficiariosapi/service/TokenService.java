package com.kan.planosaude.beneficiariosapi.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.kan.planosaude.beneficiariosapi.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token}")
    private String secret;
    public String gerarToken(User user) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("Beneficiario-API")
                    .withSubject(user.getLogin())
                    .withExpiresAt(tempoDeExpiracao())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException ex){
            //criar excessao propria
            throw new RuntimeException("Erro ao gerar token", ex);
        }
    }

    public String validarToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("Beneficiario-API")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException ex){
            //criar excessao propria
            return "";
        }
    }



    private Instant tempoDeExpiracao(){
        return LocalDateTime.now().plusHours(6).toInstant(ZoneOffset.of("-03:00"));
    }
}
