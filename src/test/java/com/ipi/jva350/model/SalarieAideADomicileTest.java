package com.ipi.jva350.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;


public class SalarieAideADomicileTest {

    @Test
    public void testALegalementDroitADesCongesPayesTrue() {
        // Given : Mise en place de l'environnement du test et de ses données (hypothèses)
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(35);
        // When : Comportement à tester, en pratique une (ou des) méthode(s) à exécuter
        boolean droit = salarie.aLegalementDroitADesCongesPayes();
        // Then : Comparaison du résultat de la méthode ou de l'état final avec celui attendu
        Assertions.assertEquals(true, droit);
    }

    @Test
    public void testALegalementDroitADesCongesPayesFalse() {
        // Given : Mise en place de l'environnement du test et de ses données (hypothèses)
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(5);
        // When : Comportement à tester, en pratique une (ou des) méthode(s) à exécuter
        boolean droit = salarie.aLegalementDroitADesCongesPayes();
        // Then : Comparaison du résultat de la méthode ou de l'état final avec celui attendu
        Assertions.assertEquals(false, droit);
    }

    @Test
    public void testALegalementDroitADesCongesPayesValeurParDefaut() {
        // Valeur par defaut = 0

        // Given : Mise en place de l'environnement du test et de ses données (hypothèses)
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        // When : Comportement à tester, en pratique une (ou des) méthode(s) à exécuter
        boolean droit = salarie.aLegalementDroitADesCongesPayes();
        // Then : Comparaison du résultat de la méthode ou de l'état final avec celui attendu
        Assertions.assertEquals(false, droit);
    }

    @ParameterizedTest(name = "le test échoue lorsque")
    @CsvSource({
            "'2026-06-01', '2026-06-30', 26",
            "'2026-07-01', '2026-07-31', 27"
    })
    public void testCalculeJoursDeCongeDecomptesPourPlage(String debut, String fin, int expected) {
        /* Dans les exemples sur le site de pagesjaunes, on calcule le nombre de jours.
        Cette méthode retourne une LinkedHashSet des jours de congé de façon ordonnée.
        Pour ce test, on va donc compter le nombre de jours dans la liste.
        On peut aussi reprendre les mêmes exemples. */

        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        // When
        LinkedHashSet liste = salarie.calculeJoursDeCongeDecomptesPourPlage(
                LocalDate.parse(debut),
                LocalDate.parse(fin));

        // Then
        Assertions.assertEquals(expected, liste.size());
    }
}
