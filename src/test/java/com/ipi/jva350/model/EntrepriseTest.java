package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EntrepriseTest {

    @Autowired
    Entreprise entreprise;

    @Test
    public void testEstDansPlage() {
        
        boolean vrai = Entreprise.estDansPlage(
                LocalDate.of(2026,02,05),
                LocalDate.of(2026,01,02),
                LocalDate.of(2026,04,20));

        Assertions.assertTrue(vrai);
    }

    @Test
    public void testALegalementDroitADesCongesPayesFalse() {
        double result = entreprise.proportionPondereeDuMois(LocalDate.of(2026,2,2));
        Assertions.assertEquals(12, result);
    }
    //Entreprise.estJourFerie() OU BIEN Entreprise.proportionPondereeDuMois() et Entreprise.getPremierJourAnneeDeConges().
}
