package com.apidelivery.models.service.impl;

import com.apidelivery.models.model.Cliente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
public class ClienteDetailsImpl implements UserDetails {
    private Long id;
    private String email;
    private String Senha;

    public ClienteDetailsImpl (Long id, String email, String Senha
            Collection<? extends GrantedAuthority> authorities){
            super();
            this.id = id;
            this.email = email;
            this.Senha = Senha;
            this.authorities = authorities;
    }


    public static ClienteDetailsImpl build(Cliente cliente){

        return new ClienteDetailsImpl(
                cliente.getId(),
                cliente.getEmail(),
                cliente.getSenha(),
                new ArrayList<>()
        );
    }


    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
