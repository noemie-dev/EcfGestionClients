import entities.*;
import gestionlog.LoggerInit;
import view.UiListe;

import java.io.IOException;
import java.time.DateTimeException;
import java.util.logging.Level;

import static gestionlog.LoggerInit.LOGGER;


public class Main {
    public static void main(String[] args) throws NullPointerException, SaisieException {

        try {
            new LoggerInit().initFileLogger();
            LOGGER.log(Level.INFO, "Lancement de l'application");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'initialisation du logger : " + e.getMessage());
            System.exit(1);
        }
        new UiListe().setVisible(true);
        remplissage();

        LOGGER.log(Level.INFO, "Fermeture de l'application");


        }
    public static void remplissage() {
        try {

            Client client = new Client(0, "apple", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", 5454, 55);
            Client client2 = new Client(0, "microsoft", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", 5454, 55);
            Prospect prospect = new Prospect(0, "google", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", " ", "27/08/1995", "OUI");
            Prospect prospect2 = new Prospect(0, "linux", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", "27/08/1995", "non");

            Clients.clients.add(client);
            Clients.clients.add(client2);
            Prospects.prospects.add(prospect);
            Prospects.ajouterProspect(prospect2);

        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());}

        catch (DateTimeException e) {
            System.out.println(e.getMessage());
        }
        catch (SaisieException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
