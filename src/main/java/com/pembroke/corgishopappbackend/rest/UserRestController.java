package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.dto.LoginRequest;
import com.pembroke.corgishopappbackend.entity.Cart;
import com.pembroke.corgishopappbackend.entity.Corgi;
import com.pembroke.corgishopappbackend.entity.Item;
import com.pembroke.corgishopappbackend.security.BasicAuthenticationUtil;
import com.pembroke.corgishopappbackend.service.UserService;
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

import java.util.List;

@RestController
public class UserRestController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Autowired
    public UserRestController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
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


    @GetMapping("/user/cart/items")
    public ResponseEntity<List<Item>> getItemsInCart() {
        return ResponseEntity.ok(userService.findItemsById(1)); // Schlecht aber es gibt nur einen User also passt
    }

    @GetMapping("/user/cart/corgis")
    public ResponseEntity<List<Corgi>> getCorgisInCart() {
        return ResponseEntity.ok(userService.findCorgisById(1)); // Schlecht aber es gibt nur einen User also passt
    }

}
