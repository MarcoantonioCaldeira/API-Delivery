//package com.apidelivery.web.security;
//
//import com.apidelivery.models.model.Cliente;
//import com.apidelivery.models.repository.ClienteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    ClienteRepository clienteRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
//
//        Cliente existsUser = clienteRepository.findByNome(nome);
//
//        if (existsUser == null) {
//            throw new Error("User does not exists!");
//        }
//
//        return ClientePrincipal.create(existsUser);
//    }
//}
