package com.pembroke.corgishopappbackend.service;

import com.pembroke.corgishopappbackend.dao.CartRepository;
import com.pembroke.corgishopappbackend.entity.Cart;
import com.pembroke.corgishopappbackend.entity.Corgi;
import com.pembroke.corgishopappbackend.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pembroke.corgishopappbackend.dao.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Autowired
    public UserService(UserRepository userRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    public List<Corgi> findCorgisById(int id) {
        return userRepository.findCorgisByUserId(id);
    }

    public List<Item> findItemsById(int id) {
        return userRepository.findItemsByUserId(id);
    }

    public void save(Cart cart) {
        cartRepository.save(cart);
    }

}
