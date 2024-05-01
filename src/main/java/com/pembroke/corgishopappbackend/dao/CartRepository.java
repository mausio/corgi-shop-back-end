package com.pembroke.corgishopappbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pembroke.corgishopappbackend.dto.CartDTO;
import com.pembroke.corgishopappbackend.entity.Category;

import java.util.List;

public interface CartRepository extends JpaRepository<Category, Integer> {
    List<CartDTO> findByUserId(int userId);
    CartDTO findByUserIdAndCartId(int userId, int cartId);
}
