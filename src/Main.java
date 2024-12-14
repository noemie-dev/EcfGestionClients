import entities.*;
import gestionlog.LoggerInit;
import view.UiAccueil2;

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

        UiAccueil2 uiAccueil2 = new UiAccueil2();
        uiAccueil2.setVisible(true);
       // new UiListe().setVisible(true);
        remplissage();

        LOGGER.log(Level.INFO, "Fermeture de l'application");


        }
    public static void remplissage() {
        try {

            Client client = new Client( "apple", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", 5454, 55);
            Client client2 = new Client( "microsoft", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", 5454, 55);
            Client client3 = new Client("aldi", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", 5454, 55);
            Client client4 = new Client ("lidl", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", 5454, 55);
            Prospect prospect = new Prospect( "google", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", " ", "27/08/1995", "OUI");
            Prospect prospect2 = new Prospect( "linux", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", "27/08/1995", "non");
            Prospect prospect3 = new Prospect("samsung", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", "27/08/1995", "non");
            Prospect prospect4 = new Prospect("leclerc", new Adresse("5", "liberation", "57670", "bobville"), "+3385562012", "email@email.com", "non", "27/08/1995", "non");
            Clients.clients.add(client);
            Clients.clients.add(client2);
            Clients.clients.add(client3);
            Clients.clients.add(client4);
            Prospects.prospects.add(prospect);
            Prospects.ajouterProspect(prospect2);
            Prospects.ajouterProspect(prospect3);
            Prospects.ajouterProspect(prospect4);

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
