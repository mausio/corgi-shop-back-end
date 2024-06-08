package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.dao.CartRepository;
import com.pembroke.corgishopappbackend.dao.ItemRepository;
import com.pembroke.corgishopappbackend.dto.LoginRequest;
import com.pembroke.corgishopappbackend.entity.Cart;
import com.pembroke.corgishopappbackend.entity.Corgi;
import com.pembroke.corgishopappbackend.entity.Item;
import com.pembroke.corgishopappbackend.security.BasicAuthenticationUtil;
import com.pembroke.corgishopappbackend.service.CategoryService;
import com.pembroke.corgishopappbackend.service.CorgiService;
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
    private final CartRepository cartRepository;
    private final CategoryService categoryService;
    private final CorgiService corgiService;
    private final ItemRepository itemRepository;

    @Autowired
    public UserRestController(AuthenticationManager authenticationManager, UserService userService, CartRepository cartRepository, CategoryService categoryService, CorgiService corgiService, ItemRepository itemRepository) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.cartRepository = cartRepository;
        this.categoryService = categoryService;
        this.corgiService = corgiService;
        this.itemRepository = itemRepository;
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
        return ResponseEntity.ok(userService.findItemsById(userService.findUserByName("user").getId()));
    }

    @GetMapping("/user/cart/corgis")
    public ResponseEntity<List<Corgi>> getCorgisInCart() {
        return ResponseEntity.ok(userService.findCorgisById(userService.findUserByName("user").getId()));
    }

    @GetMapping("/user/cart/add/{uuid}")
    public ResponseEntity<Boolean> addItemToCart(@PathVariable String uuid) {

        Cart cart = cartRepository.findCartById(userService.findUserByName("user").getId());

        if (itemRepository.findItemByUuid(uuid) != null) {
            cart.getItems().add(itemRepository.findItemByUuid(uuid));
        } else {
            cart.getCorgis().add(corgiService.findCorgiByUuid(uuid));
        }

        cartRepository.save(cart);

        return ResponseEntity.ok(true);
    }

}
