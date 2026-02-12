package com.ipi.jva350.repository;

import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SalarieAideADomicileRepositoryTest {

    @Autowired
    private SalarieAideADomicileRepository salarieRepository;

    @BeforeEach
    void before() {
        salarieRepository.deleteAll();
    }

    @Test
    void testFindByNomPresent(){
        SalarieAideADomicile caroline = new SalarieAideADomicile();
        caroline.setNom("Caroline");
        salarieRepository.save(caroline);
        SalarieAideADomicile result = salarieRepository.findByNom("Caroline");
        Assertions.assertEquals(caroline, result);
    }

    @Test
    void testFindByNomNonPresent(){
        SalarieAideADomicile caroline = salarieRepository.findByNom("Caroline");

        Assertions.assertNull(caroline);
    }
}
