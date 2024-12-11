package test;

import entities.Client;
import entities.SaisieException;
import entities.Societe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SocieteTest {
    @Test
    void testSocieteVide() {
        Client client    = new Client();
        boolean test = false;
        try {
            client.setRaisonSociale(null);
            client.setAdresse(null);
            client.setTelephone(null);
            client.setEmail(null);
            client.setChiffreAffaires(0);
            client.setNbrEmployes(0);
        } catch (NullPointerException npe) {
            test = true;
            assertTrue(test);
        } catch (SaisieException se) {
            assertTrue(test);
        }
    }
}

/*  @Test
void testAnimalVide() {
          Chien chien = new Chien();
           boolean test = false;
           try {
               chien.setNom(null);
           } catch (ExceptionPersonnalisee ep) {
               test = true;
           }
          assertTrue(test);
      }
}*/

/*
@ParameterizedTest
@ValueSource(strings = {""})
void testSetNomInvalide(String invalidValues) {
    assertThrows(ExceptionPersonnalisee.class    , () -> {
        new Chien().setNom(invalidValues);
    });
}

@ParameterizedTest
@ValueSource(strings = {"Toto", "tata","5"})
void testSetNomValide (String validValues){
    assertDoesNotThrow(() -> {
        new Chien().setNom(validValues);
    });
}*/
