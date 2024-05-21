package com.pembroke.corgishopappbackend;

import static org.assertj.core.api.Assertions.assertThat;

import com.pembroke.corgishopappbackend.dao.ItemRepository;
import com.pembroke.corgishopappbackend.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFindByName() {
        String itemName = "Test Item";

        List<Item> items = itemRepository.findByName(itemName);

        assertThat(items).isNotNull().isNotEmpty();
    }
}