package com.sawcunha.controlerelatorio.security;

import com.google.gson.Gson;
import com.sawcunha.controlerelatorio.model.dto.MessageErroDTO;
import com.sawcunha.controlerelatorio.security.model.JwtValidation;
import com.sawcunha.controlerelatorio.security.service.TokenAuthenticationService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Autowired
    private TokenAuthenticationService authenticationService;

    private final Gson gson = new Gson();

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        AtomicReference<Authentication> authentication = new AtomicReference<>(null);
        if(!request.getRequestURI().contains("/authentication")) {
            JwtValidation jwtValidation = authenticationService
                    .getAuthentication(request);

            if (jwtValidation.isValid()) {
                jwtValidation.getAuthenticationOptional().ifPresent(authentication::set);
                request.setAttribute("AAA", "jwtValidation.getAaa()");
            } else {
                setUnauthorizedResponse(response,jwtValidation.getJwtErro().getCod());
                return;
            }
        }

        SecurityContextHolder.getContext().setAuthentication(authentication.get());
        filterChain.doFilter(request, response);
    }

    public void setUnauthorizedResponse(HttpServletResponse response, int identificador) {
        MessageErroDTO message = authenticationService.getMensageErro(identificador);
        response.setStatus(message.getStatus());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(gson.toJson(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}