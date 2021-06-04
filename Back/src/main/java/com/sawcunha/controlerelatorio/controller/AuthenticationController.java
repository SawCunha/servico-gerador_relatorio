package com.sawcunha.controlerelatorio.controller;

import com.sawcunha.controlerelatorio.model.dto.AuthDTO;
import com.sawcunha.controlerelatorio.model.dto.AuthenticationDTO;
import com.sawcunha.controlerelatorio.redis.model.AuthToken;
import com.sawcunha.controlerelatorio.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationDTO> validAuthentication(@Valid @RequestBody AuthDTO authDTO){
        return ResponseEntity.ok(authenticationService.genareteToken(authDTO));
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthToken> validAuthentication(@RequestHeader(name = "Authorization")String token){
        return ResponseEntity.ok(authenticationService.getAuthToken(token));
    }

}
