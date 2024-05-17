package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.dto.LoginRequest;
import com.pembroke.corgishopappbackend.security.BasicAuthenticationUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserRestController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/user/signIn")
    public ResponseEntity<Boolean> signInUser(@RequestBody LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getPlayerName(), loginRequest.getPassword()));

            BasicAuthenticationUtil.getBasicAuthenticationHeader(loginRequest.getPlayerName(), loginRequest.getPassword());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return ResponseEntity.ok(true);
        } catch (AuthenticationException exception) {
            return ResponseEntity.ok(false);
        }
    }

}
