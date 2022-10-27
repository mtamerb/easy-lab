package com.tamerb.easylab;


import com.tamerb.easylab.model.Laborant;
import com.tamerb.easylab.repository.LaborantRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class LaborantRepositoryTests {

    @Autowired
    private LaborantRepository laborantRepository;

    @Test
    public void testCreateLaborant() {
        Laborant laborant = laborantRepository.save(new Laborant("Eda","Kaymaz","1234567"));
        Assertions.assertThat(laborant.getId()).isGreaterThan(0);

    }
}
