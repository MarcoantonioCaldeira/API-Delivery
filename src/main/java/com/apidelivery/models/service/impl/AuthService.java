package com.apidelivery.models.service.impl;


import com.apidelivery.models.model.Cliente;
import com.apidelivery.models.model.Restaurante;
import com.apidelivery.models.repository.ClienteRepository;
import com.apidelivery.models.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

//    @Autowired
//    private RestauranteRepository restauranteRepository;

    public boolean Autenticacao(String email, String senha){

        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(email);
//        Optional<Restaurante> restauranteOptional = restauranteRepository.findByEmail(email);

        if(clienteOptional.isPresent()) {

            Cliente cliente = clienteOptional.get();


            if (cliente.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

}
