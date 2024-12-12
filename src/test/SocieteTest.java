package test;

import entities.Client;
import entities.SaisieException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SocieteTest {

    @Test
    void setRaisonSociale() {
    }

    @Test
    void setAdresse() {
    }

    @Test
    void setTelephone() {
    }

    @Test
    void setEmail() {
    }
}
/*
class SocieteTest {
    @Test
    void testSocieteVide() {
        Client client    = new Client();
        boolean test = false;
        try {
            client.setRaisonSociale(null);

        } catch (NullPointerException npe) {
            test = true;
            assertTrue(test);
        } catch (SaisieException se) {
            assertTrue(test);
        }
    }
}*/
/*client.setAdresse(null);
            client.setTelephone(null);
            client.setEmail(null);
            client.setChiffreAffaires(0);
            client.setNbrEmployes(0);*/

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
