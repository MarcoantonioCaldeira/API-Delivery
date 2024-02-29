package com.apidelivery.web.controllers;

import com.apidelivery.models.data.AuthRequest;
import com.apidelivery.models.model.Cliente;
import com.apidelivery.models.service.impl.AuthService;
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
    private AuthService clienteService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        String email = authRequest.getEmail();
        String senha = authRequest.getSenha();

        // Verifica se o email e a senha são fornecidos
        if (email != null && senha != null) {
            Cliente cliente = clienteService.Autenticacao(email, senha);

            if (cliente != null) {
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>("Email ou senha não fornecidos", HttpStatus.BAD_REQUEST);
        }
    }

}