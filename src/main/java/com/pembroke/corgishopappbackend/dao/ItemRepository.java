package com.pembroke.corgishopappbackend.dao;

import com.pembroke.corgishopappbackend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
