package com.apidelivery.web.controllers;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@RestController
public class AuthController {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private MyUserDetailService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authentication -> {
            String email = authentication.getName();
            String senha = authentication.getCredentials().toString();
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            if (!userDetails.getPassword().equals(senha)) {
                throw new BadCredentialsException("Invalid username/password");
            }
            return new UsernamePasswordAuthenticationToken(userDetails, senha, userDetails.getAuthorities());
        };
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getSenha())
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());

            String token = Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .claim("authorities", userDetails.getAuthorities())
                    .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecretKey())
                    .compact();

            return token;
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Incorrect username or password", e);
        }
    }

}
