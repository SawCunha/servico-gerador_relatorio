package com.sawcunha.controlerelatorio.service;

import com.sawcunha.controlerelatorio.exceptions.NotFoundException;
import com.sawcunha.controlerelatorio.model.dto.AuthDTO;
import com.sawcunha.controlerelatorio.model.User;
import com.sawcunha.controlerelatorio.model.dto.AuthenticationDTO;
import com.sawcunha.controlerelatorio.redis.model.AuthToken;
import com.sawcunha.controlerelatorio.redis.repository.AuthTokenRepository;
import com.sawcunha.controlerelatorio.repository.UserRepository;
import com.sawcunha.controlerelatorio.util.JwtTokenUtil;
import io.fusionauth.jwt.domain.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthTokenRepository authTokenRepository;


    @Cacheable(value="tokens")
    @Transactional(readOnly = true)
    public AuthenticationDTO genareteToken(AuthDTO authDTO) {

        User user = userRepository
                .findByUsernameAndPasswordAndActive(authDTO.getUsername(),authDTO.getPassword(),true)
                .orElseThrow(() -> new NotFoundException("Erro ao obter usuario para gerar Token",50));

        AuthenticationDTO authenticationDTO = new AuthenticationDTO(jwtTokenUtil.generateToken(user.getIdentifier()));

        authTokenRepository.saveToken(user.getIdentifier(),new AuthToken(authenticationDTO.getToken(),user.getIdentifier()));

        return authenticationDTO;
    }

    public AuthToken getAuthToken(String token) {
        JWT jwt = jwtTokenUtil.validToken(token.replace("Bearer ",""));
        return authTokenRepository.get(jwt.subject);
    }
}
