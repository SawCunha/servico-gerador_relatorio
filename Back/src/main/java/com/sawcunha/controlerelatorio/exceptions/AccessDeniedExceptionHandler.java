package com.sawcunha.controlerelatorio.exceptions;

import com.google.gson.Gson;
import com.sawcunha.controlerelatorio.model.dto.MessageErroDTO;
import com.sawcunha.controlerelatorio.security.JWTAuthenticationFilter;
import com.sawcunha.controlerelatorio.security.service.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedExceptionHandler implements AccessDeniedHandler {

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException ex) {
        MessageErroDTO message = tokenAuthenticationService.getMensageErroAccessDenied(403);
        message.setUrlAccess(request.getRequestURI());
        response.setStatus(message.getStatus());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(new Gson().toJson(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}