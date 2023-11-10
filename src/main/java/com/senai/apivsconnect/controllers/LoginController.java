package com.senai.apivsconnect.controllers;

import com.senai.apivsconnect.dtos.LoginDto;
import com.senai.apivsconnect.dtos.TokenDto;
import com.senai.apivsconnect.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto dados) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());

        var auth = authenticationManager.authenticate(userPassword);

        var token = tokenService. gerarToken( (UsuarioModel) auth.getPrincipal() );

        return ResponseEntity.status(HttpStatus.OK).body(new TokenDto(token));
    }

}
