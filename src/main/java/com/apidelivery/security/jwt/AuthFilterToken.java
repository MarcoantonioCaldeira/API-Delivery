package com.apidelivery.security.jwt;

import com.apidelivery.models.service.impl.ClienteDetailServiceImpl;
import com.apidelivery.models.service.impl.ClienteDetails;
import com.apidelivery.models.service.impl.ClienteDetailsImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthFilterToken extends OncePerRequestFilter{

    @Autowired
    private JwtUtils jwtUtil;

    @Autowired
    private ClienteDetailServiceImpl clienteDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

            try {
                String jwt = getToken(request);
                if (jwt != null && jwtUtil.validateJwtToken(jwt)) {

                    String username = jwtUtil.getUsernameToken(jwt);

                    ClienteDetailsImpl userDetails = clienteDetailService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(auth);
                }

            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao proecssar o token");
            }

            filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String headerToken = request.getHeader("Authorization");
        if(StringUtils.hasText(headerToken) && headerToken.startsWith("Bearer")) {
            return headerToken.replace("Bearer ","");
        }
        return null;
    }

}
