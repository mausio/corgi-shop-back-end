package com.pembroke.corgishopappbackend.security;


import com.pembroke.corgishopappbackend.service.UserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class BasicAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(BasicAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {

            String token = parseToken(request);
            if (token != null) {
                String decodedToken = new String(java.util.Base64.getDecoder().decode(token));
                String[] parts = decodedToken.split(":");

                if (parts.length != 0) {
                    String username = parts[0];
                    String password = parts[1];
                    logger.info("Username: {}", username);
                    logger.info("Password: {}", password);

                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                    logger.info("Encoded Password: {}", userDetails.getPassword());
                    logger.info("Coded Password: {}", password);

                    if (passwordEncoder.matches(password, userDetails.getPassword())) {
                        logger.info("Password matches");
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, List.of(new SimpleGrantedAuthority("ROLE_USER")));
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    } else {
                        logger.info("Password does not match");
                    }

                }

            }

        } catch (Exception e) {
            logger.error("Error: {}", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    private String parseToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Basic ")) {
            return header.replace("Basic ", "");
        }
        return null;
    }
}
