package com.pembroke.corgishopappbackend.dao;

import com.pembroke.corgishopappbackend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByCategory_Id(int categoryId);
}
