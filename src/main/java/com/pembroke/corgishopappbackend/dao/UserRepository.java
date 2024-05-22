package com.pembroke.corgishopappbackend.dao;

import com.pembroke.corgishopappbackend.entity.Cart;
import com.pembroke.corgishopappbackend.entity.Corgi;
import com.pembroke.corgishopappbackend.entity.Item;
import com.pembroke.corgishopappbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query("SELECT co" +
            " FROM User u, Cart c, Corgi co" +
            " WHERE u.id = ?1 AND u.cart.id = c.id AND c.id = co.cart.id")
    List<Corgi> findCorgisByUserId(int userId);

    @Query("SELECT i" +
            " FROM User u, Cart c, Item i" +
            " WHERE u.id = ?1 AND u.cart.id = c.id AND c.id = i.cart.id")
    List<Item> findItemsByUserId(int userId);

}
