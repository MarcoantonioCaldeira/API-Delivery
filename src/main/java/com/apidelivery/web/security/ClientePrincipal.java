//package com.apidelivery.web.security;
//
//import com.apidelivery.models.model.Cliente;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class ClientePrincipal implements UserDetails {
//
//    private String email;
//    private String senha;
//    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public ClientePrincipal(Cliente cliente) {
//        this.email = cliente.getEmail();
//        this.senha = cliente.getSenha();
//    }
//
//    public static ClientePrincipal create(Cliente cliente) {
//        return new ClientePrincipal(cliente);
//    }
//
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
