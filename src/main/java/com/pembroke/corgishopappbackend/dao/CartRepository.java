package com.pembroke.corgishopappbackend.dao;

import com.pembroke.corgishopappbackend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findCartById(int id);

}
