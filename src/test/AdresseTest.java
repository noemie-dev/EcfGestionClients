package test;
// classe de tests de la classe Adresse, vérifie que les exceptions attendues se lèvent correctement.
import entities.Adresse;
import entities.SaisieException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AdresseTest {

    // Test constructeur avec des valeurs non autorisées, qui doivent lever une exception
    @Test
    void testConstructeurAvecValeursInvalides() {
        assertThrows(NullPointerException.class, () -> new Adresse(null, "rue", "75001", "Paris"));
        assertThrows(NullPointerException.class, () -> new Adresse("1", null, "75001", "Paris"));
        assertThrows(SaisieException.class, () -> new Adresse("1", "rue", "invalid", "Paris"));
        assertThrows(NullPointerException.class, () -> new Adresse("1", "rue", "75001", null));
    }

    // Test constructeur avec des valeurs autorisées, qui ne doivent pas lever une exception
    @Test
    void testConstructeurAvecValeursValides() {
        assertDoesNotThrow(() -> new Adresse("1", "Rue de Paris", "75001", "Paris"));
        assertDoesNotThrow(() -> new Adresse("10", "Avenue des Champs", "13001", "Marseille"));
        assertDoesNotThrow(() -> new Adresse("42A", "Boulevard Saint-Michel", "69001", "Lyon"));
    }

    // tests setters
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n"})
    void testSetRueNbInvalide(String invalidValue) {
        Adresse adresse = new Adresse();
        assertThrows(NullPointerException.class, () -> adresse.setRueNb(invalidValue));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10B", "42A"})
    void testSetRueNbValide(String validValue) {
        Adresse adresse = new Adresse();
        assertDoesNotThrow(() -> adresse.setRueNb(validValue));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n"})
    void testSetRueNomInvalide(String invalidValue) {
        Adresse adresse = new Adresse();
        assertThrows(NullPointerException.class, () -> adresse.setRueNom(invalidValue));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Rue de Paris", "Avenue des Champs", "Boulevard Saint-Michel"})
    void testSetRueNomValide(String validValue) {
        Adresse adresse = new Adresse();
        assertDoesNotThrow(() -> adresse.setRueNom(validValue));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1234", "ABCDE", "7500A"}) // Ajouter des codes postaux non valides
    void testSetCodePostalInvalide(String invalidValue) {
        Adresse adresse = new Adresse();
        assertThrows(SaisieException.class, () -> adresse.setCodePostal(invalidValue));
        assertThrows(NullPointerException.class, () -> adresse.setCodePostal(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "}) // Ajouter des codes postaux non valides
    void testSetCodePostalVide(String invalidValue) {
        Adresse adresse = new Adresse();
        assertThrows(NullPointerException.class, () -> adresse.setCodePostal(null));
    }


    @ParameterizedTest
    @ValueSource(strings = {"75001", "13001", "69001"}) // Ajouter des codes postaux valides
    void testSetCodePostalValide(String validValue) {
        Adresse adresse = new Adresse();
        assertDoesNotThrow(() -> adresse.setCodePostal(validValue));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n"})
    void testSetVilleInvalide(String invalidValue) {
        Adresse adresse = new Adresse();
        assertThrows(NullPointerException.class, () -> adresse.setVille(invalidValue));

    }

    @ParameterizedTest
    @ValueSource(strings = {"Paris", "Marseille", "Lyon"})
    void testSetVilleValide(String validValue) {
        Adresse adresse = new Adresse();
        assertDoesNotThrow(() -> adresse.setVille(validValue));
    }

    }

