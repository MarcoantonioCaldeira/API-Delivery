package com.apidelivery.web.controllers;

import com.apidelivery.models.data.AuthRequest;
import com.apidelivery.models.service.impl.AuthClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthClienteService clienteService;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        String email = authRequest.getEmail();
        String senha = authRequest.getSenha();

        if(clienteService.autenticarCliente(email, senha)){
            return new ResponseEntity<>("Autenticação bem-sucedida", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
        }
    }
}
