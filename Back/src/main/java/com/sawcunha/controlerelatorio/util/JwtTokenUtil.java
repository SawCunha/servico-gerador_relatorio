package com.sawcunha.controlerelatorio.util;

import com.sawcunha.controlerelatorio.security.model.JwtValidation;
import com.sawcunha.controlerelatorio.security.model.eJWTErro;
import io.fusionauth.jwt.*;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.valid}")
    private Integer valid;

    private Signer SIGNER512;

    @PostConstruct
    private void inicializa(){
        this.SIGNER512 = HMACSigner.newSHA512Signer(secret);
    }

    //gera token para user
    public String generateToken(UUID uuid) {
        return doGenerateToken(uuid.toString());
    }

    private String doGenerateToken(String uuid) {
        final Signer SIGNER512 = HMACSigner.newSHA512Signer(secret);
        JWT jwt = new JWT().setIssuer("Controle de Relatorio")
                .setIssuedAt(ZonedDateTime.now(ZoneOffset.UTC))
                .setSubject(uuid)
                .setExpiration(ZonedDateTime.now(ZoneOffset.UTC).plusMinutes(valid));
        return JWT.getEncoder().encode(jwt, SIGNER512);
    }

    public JWT validToken(String token) {
        Verifier verifier = HMACVerifier.newVerifier(secret);
        JWT jwt = null;
        try {
            jwt = JWT.getDecoder().decode(token, verifier);
        } catch (JWTException e){
            e.printStackTrace();
        }
        return jwt;
    }

    public JWT validToken(String token, JwtValidation jwtValidation) {
        Verifier verifier = HMACVerifier.newVerifier(secret);
        JWT jwt = null;
        try {
            jwt = JWT.getDecoder().decode(token, verifier);
        } catch (JWTSigningException jwtSigningException){
            jwtValidation.setJwtErro(eJWTErro.SIGNING_ERRO);
        } catch (JWTVerifierException jwtVerifierException){
            jwtValidation.setJwtErro(eJWTErro.VERIFIER_ERRO);
        } catch (JWTExpiredException jwtExpiredException){
            jwtValidation.setJwtErro(eJWTErro.EXPIRED);
        } catch (JWTException e){
            jwtValidation.setJwtErro(eJWTErro.GENERIC);
        }
        return jwt;
    }
}
