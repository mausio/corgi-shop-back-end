package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.dto.CartDTO;
import com.pembroke.corgishopappbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartRestController {
    
    private final CartService cartService;

    @Autowired
    public CartRestController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public ResponseEntity<List<CartDTO>> getCart() {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.findAll());
    }
}
