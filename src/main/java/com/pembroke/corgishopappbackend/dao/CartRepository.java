package com.pembroke.corgishopappbackend.dao;

import com.pembroke.corgishopappbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Category, Integer> {

}
