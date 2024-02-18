package com.apidelivery.models.service.impl;
import com.apidelivery.models.model.Cliente;
import com.apidelivery.models.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailService  implements UserDetailsService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(email);

        // Verifica se o cliente existe
        Cliente cliente = clienteOptional.orElseThrow(() ->
                new UsernameNotFoundException("User not found with email: " + email));

        // Retorna um UserDetails personalizado, se necessário
        return org.springframework.security.core.userdetails.User
                .withUsername(cliente.getEmail())
                .password(cliente.getSenha()) // Aqui você precisa fornecer a senha codificada, se estiver usando codificação
                .roles("USER") // Você pode definir os papéis do usuário aqui, se necessário
                .build();
    }

}
