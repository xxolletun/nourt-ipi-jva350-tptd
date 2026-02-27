package com.ipi.jva350.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class) // Junit 4 : @RunWith(SpringRunner.class)
@SpringBootTest
public class SalarieAideADomicileServiceTest {

    @Autowired
    public SalarieAideADomicileService salarieService;

    @Test
    public void testCalculeLimiteEntrepriseCongesPermis(){

        salarieService.calculeLimiteEntrepriseCongesPermis(
                LocalDate.of(2026,2,1),
                7,
                LocalDate.of(2025,11,28),
                LocalDate.of(2026,1,4),
                LocalDate.of(2026,8,5));
    }
}
