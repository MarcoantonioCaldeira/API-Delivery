package com.apidelivery.models.service.impl;

import com.apidelivery.models.model.Cliente;
import com.apidelivery.models.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ClienteDetailServiceImpl {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDetailsImpl loadUserByUsername(String nome) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByLogin(nome).get();
        return ClienteDetailsImpl.build(cliente);
    }
}
