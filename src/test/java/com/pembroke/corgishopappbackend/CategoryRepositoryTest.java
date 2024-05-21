package com.pembroke.corgishopappbackend;

import static org.assertj.core.api.Assertions.assertThat;

import com.pembroke.corgishopappbackend.dao.CategoryRepository;
import com.pembroke.corgishopappbackend.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testFindByName() {
        String categoryName = "Test Category";

        Category category = categoryRepository.findByName(categoryName);

        assertThat(category).isNotNull();
    }
}
