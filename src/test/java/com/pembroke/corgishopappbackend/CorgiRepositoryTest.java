package com.pembroke.corgishopappbackend;

import static org.assertj.core.api.Assertions.assertThat;

import com.pembroke.corgishopappbackend.dao.CorgiRepository;
import com.pembroke.corgishopappbackend.entity.Corgi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class CorgiRepositoryTest {

    @Autowired
    private CorgiRepository corgiRepository;


    @Test
    public void testFindCorgiById() {
        Corgi corgi = new Corgi("Test Corgi", 100, "Test description", "test.jpg", null, "Brown", 10, 15, true);
        corgiRepository.save(corgi);
        Optional<Corgi> optionalCorgi = corgiRepository.findById(corgi.getId());
        assertThat(optionalCorgi).isPresent();
        assertThat(optionalCorgi.get()).isEqualTo(corgi);
    }


}
