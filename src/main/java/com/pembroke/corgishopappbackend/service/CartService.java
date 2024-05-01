package com.pembroke.corgishopappbackend.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pembroke.corgishopappbackend.dao.CartRepository;
import com.pembroke.corgishopappbackend.dto.CartDTO;

@Service
public class CartService {
    
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CartService(CartRepository cartRepository, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.modelMapper = modelMapper;
    }

    public List<CartDTO> findAll() {
        return cartRepository.findAll().stream()
                .map(cart -> modelMapper.map(cart, CartDTO.class))
                .collect(java.util.stream.Collectors.toList());    
        }
}
