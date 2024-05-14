package com.pembroke.corgishopappbackend.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pembroke.corgishopappbackend.dao.CartRepository;

@Service
public class CartService {
    

    private CartRepository cartRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CartService(CartRepository cartRepository, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.modelMapper = modelMapper;
    }

}
