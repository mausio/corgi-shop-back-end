package com.pembroke.corgishopappbackend.service;

import com.pembroke.corgishopappbackend.entity.Corgi;
import com.pembroke.corgishopappbackend.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pembroke.corgishopappbackend.dao.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Corgi> findCorgisById(int id) {
        return userRepository.findCorgisByUserId(id);
    }

    public List<Item> findItemsById(int id) {
        return userRepository.findItemsByUserId(id);
    }

    // TODO: Create Method for saving and deleting Items/Corgis in Cart (UUID or ID?)
}
