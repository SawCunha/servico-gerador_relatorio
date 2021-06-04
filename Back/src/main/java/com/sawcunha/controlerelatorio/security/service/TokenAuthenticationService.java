package com.sawcunha.controlerelatorio.security.service;

import com.sawcunha.controlerelatorio.mapper.MessageErroMapper;
import com.sawcunha.controlerelatorio.security.model.JwtValidation;
import com.sawcunha.controlerelatorio.model.MessageErro;
import com.sawcunha.controlerelatorio.model.dto.MessageErroDTO;
import com.sawcunha.controlerelatorio.repository.MessageErroRepository;
import com.sawcunha.controlerelatorio.security.model.eJWTErro;
import com.sawcunha.controlerelatorio.util.JwtTokenUtil;
import io.fusionauth.jwt.domain.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Component
public class TokenAuthenticationService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MessageErroRepository messageErroRepository;

    @Autowired
    private MessageErroMapper messageErroMapper;

    static final String HEADER_STRING = "Authorization";

    public JwtValidation getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        JwtValidation jwtValidation = new JwtValidation();
        if (token != null) {
            if(token.matches("(Bearer\\s)(.+)")) {
                JWT jwt = jwtTokenUtil.validToken(token.replace("Bearer ", ""), jwtValidation);
                if (jwt != null) {
                    jwtValidation.setValid(true);
                    jwtValidation.setAuthenticationOptional(new UsernamePasswordAuthenticationToken(jwt.subject, null, Collections.emptyList()));
                }
            }
        } else {
            jwtValidation.setJwtErro(eJWTErro.NOT_HAS_TOKEN);
        }
        return jwtValidation;
    }

    @Transactional(readOnly = true)
    public MessageErroDTO getMensageErro(Integer identificador){
        return messageErroMapper.mensagemToMensagemDTO(
                messageErroRepository.findByIdentifier(identificador)
                        .orElse(new MessageErro()));
    }

}
