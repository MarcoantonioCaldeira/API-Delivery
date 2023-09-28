package com.apidelivery.config;

import com.apidelivery.models.model.Cliente;
import com.apidelivery.models.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    public DataInitializer(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Cliente cliente1 = new Cliente();

        cliente1.setNome("Marco Antonio");
        cliente1.setEmail("caldeiran391@gmail.com");
        cliente1.setTelefone("1899999999");
        cliente1.setSenha("123gfgfg");
        cliente1.setConfirmarSenha("123gfgfg");

        clienteRepository.save(cliente1);
    }

}


