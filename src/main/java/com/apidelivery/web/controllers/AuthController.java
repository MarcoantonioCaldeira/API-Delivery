package com.apidelivery.web.controllers;

import com.apidelivery.models.data.AuthRequest;
import com.apidelivery.models.model.Cliente;
import com.apidelivery.models.service.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthService clienteService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        String email = authRequest.getEmail();
        String senha = authRequest.getSenha();
        Cliente cliente = clienteService.Autenticacao(email, senha);
        return new ResponseEntity<>(cliente, authService.login(authRequest), HttpStatus.OK);
    }

}