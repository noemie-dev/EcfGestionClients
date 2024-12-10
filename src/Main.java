import entities.*;
import gestionlog.LoggerInit;

import java.io.IOException;
import java.util.logging.Level;

import static gestionlog.LoggerInit.LOGGER;


public class Main {
    public static void main(String[] args) throws NullPointerException, SaisieException {
        System.out.println("Hello, World!");

        try {
            new LoggerInit().initFileLogger();
            LOGGER.log(Level.INFO, "Lancement de l'application");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'initialisation du logger : " + e.getMessage());
            System.exit(1);
        }

        remplissage();

        LOGGER.log(Level.INFO, "Fermeture de l'application");
        System.exit(0);

        }
    public static void remplissage() {
        try {

            Client client = new Client(0, "bob", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", 5454, 55);
            Client client2 = new Client(0, "bob", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", 5454, 55);
            Prospect prospect = new Prospect(0, "bob", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", " ", "27/08/1995", "OUI");
            Prospect prospect2 = new Prospect(0, "bob", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", "27/08/1995", "non");
            System.out.println(client2);
            System.out.println(client);
            System.out.println(prospect);
            System.out.println(prospect2);

            Clients.clients.add(client);
            Clients.clients.add(client2);
            Prospects.prospects.add(prospect);

        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());}
        catch (SaisieException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
