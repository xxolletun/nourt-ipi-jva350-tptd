package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EntrepriseTest {


    // TDD, avant regarder méthode
    @Test
    public void testEstDansPlage() {

        boolean resultat = Entreprise.estDansPlage(
                LocalDate.of(2026,02,05),
                LocalDate.of(2026,01,02),
                LocalDate.of(2026,04,20));

        Assertions.assertEquals(true, resultat);
    }

    // Apres modifier méthode
    // test paramétrés pour tester tous les use case différents
    @ParameterizedTest(name = "la date du {0} ne se trouve pas dans la plage.")
    @CsvSource({
            "'2026-01-10', false",
            "'2026-04-06', true"
    })
    public void testEstJourFerie(String jour, boolean expected) {
        Assertions.assertEquals(expected, Entreprise.estJourFerie(LocalDate.parse(jour)));
    }


    // TP
    @ParameterizedTest(name = "la date du {0} ne correspond pas à un jour férié.")
    @CsvSource({
            "'2026-02-05', '2026-01-02', '2026-04-20', true", // normal
            "'2026-02-05', '2026-01-02', '2026-04-20', true", // date < debut
            "'2026-02-05', '2026-01-02', '2026-04-20', true", // date > fin
            "'2026-02-05', '2026-01-02', '2026-04-20', true", // date = debut
            "'2026-02-05', '2026-01-02', '2026-04-20', true", // date = fin
            "'2026-02-05', '2026-01-02', '2026-04-20', true", // date = debut = fin
            "'2026-02-05', '2026-01-02', '2026-04-20', true", // date!= (debut = fin)
    })
    public void testEstDansPlageCorrige(String date, String debut, String fin, boolean expected) {
        boolean resultat = Entreprise.estDansPlage(date,debut,fin);
        Assertions.assertEquals(expected, resultat);
    }
}
