package com.pembroke.corgishopappbackend.dao;

import com.pembroke.corgishopappbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
