package com.ipi.jva350.model;

import net.bytebuddy.asm.Advice;
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
}
