package com.apidelivery.models.service.impl;
import com.apidelivery.models.model.Cliente;
import com.apidelivery.models.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public boolean autenticarCliente(String email, String senha){
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(email);

        if(clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();

            if (cliente.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
