package com.ipi.jva350.model;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.LinkedHashSet;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EntrepriseTest {

    @Test
    public void testEstDansPlage() {

        boolean vrai = Entreprise.estDansPlage(
                LocalDate.of(2026,02,05),
                LocalDate.of(2026,01,02),
                LocalDate.of(2026,04,20));

        Assertions.assertTrue(vrai);
    }

    @ParameterizedTest(name = "la date du {0} ne correspond pas à un jour férié.")
    @CsvSource({
            "'2026-01-10', false",
            "'2026-04-06', true"
    })
    public void testEstJourFerie(String jour, boolean expected) {
        Assertions.assertEquals(expected, Entreprise.estJourFerie(LocalDate.parse(jour)));
    }
}
