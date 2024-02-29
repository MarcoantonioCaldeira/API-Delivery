package com.apidelivery.models.service.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SpringSecurityConfig {


    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf->csrf.disable())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .securityMatcher("/**")
                .authorizeHttpRequests(config ->
                        config.requestMatchers(ConfigProjeto.WHITE_LIST_URL).permitAll()
                                .requestMatchers(HttpMethod.POST, "rest/login").permitAll()
                                .requestMatchers(HttpMethod.GET, "/rest/cliente/save").hasRole("USER")
                                .anyRequest().authenticated()
                );

        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        var builder = http.getSharedObject(AuthenticationManagerBuilder.class);

        LdapAuthenticationProviderConfigurer.PasswordCompareConfigurer crypt;
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(crypt.passwordEncoder());

        return builder.build();
    }

}