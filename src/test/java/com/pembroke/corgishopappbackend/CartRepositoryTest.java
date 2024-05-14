package com.pembroke.corgishopappbackend;

import static org.assertj.core.api.Assertions.assertThat;

import com.pembroke.corgishopappbackend.dao.CartRepository;
import com.pembroke.corgishopappbackend.dto.CartDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testFindByUserId() {
        int userId = 123;

        List<CartDTO> carts = cartRepository.findByUserId(userId);

        assertThat(carts).isNotNull().isNotEmpty();
    }
}
