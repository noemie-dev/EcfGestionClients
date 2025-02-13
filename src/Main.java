import DAO.Connection;
import entities.*;
import gestionlog.LoggerInit;
import utilities.OuiNon;
import view.UiAccueil2;

import java.io.IOException;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.logging.Level;

import static gestionlog.LoggerInit.LOGGER;


public class Main {
    public static void main(String[] args) {
        try {
            new LoggerInit().initFileLogger();
            LOGGER.log(Level.INFO, "Lancement de l'application");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'initialisation du logger : " + e.getMessage());
            System.exit(1);
        }

        Connection c1 = Connection.getInstance(); // Doit créer une nouvelle instance
        Connection c2 = Connection.getInstance(); // Doit retourner la même instance

        // Vérifier si c1 et c2 pointent bien vers la même instance
        if (c1 == c2) {
            System.out.println("Les deux objets sont identiques (singleton fonctionne).");
        } else {
            System.out.println("Erreur : deux instances différentes existent !");
        }
    }
}


    /*    UiAccueil2 uiAccueil2 = new UiAccueil2();
        uiAccueil2.setVisible(true);
        remplissage();

        LOGGER.log(Level.INFO, "Fermeture de l'application");


        }
    public static void remplissage() {
        try {

            Client client = new Client( "apple",
                    new Adresse("5", "liberation", "57670", "bobville"),
                    "+3385562012", "email@email.com", "non", 5454, 55);
            Client client2 = new Client( "microsoft",
                    new Adresse("5", "liberation", "57670", "bobville"),
                    "+3385562012", "email@email.com", "non", 5454, 55);
            Client client3 = new Client("aldi",
                    new Adresse("5", "liberation", "57670", "bobville"),
                    "+3385562012", "email@email.com", "non", 5454, 55);
            Client client4 = new Client ("lidl",
                    new Adresse("5", "liberation", "57670", "bobville"),
                    "+3385562012", "email@email.com", "non", 5454, 55);
            Prospect prospect = new Prospect( "google",
                    new Adresse("5", "liberation", "57670", "bobville"),
                    "+3385562012", "email@email.com", " ",
                    LocalDate.parse("27/08/1995"), OuiNon.OUI);
            Prospect prospect2 = new Prospect( "linux",
                    new Adresse("5", "liberation", "57670", "bobville"),
                    "+3385562012", "email@email.com", "non",
                    LocalDate.parse("25/07/1995"), OuiNon.NON);
            Prospect prospect3 = new Prospect("samsung",
                    new Adresse("5", "liberation", "57670", "bobville"),
                    "+3385562012", "email@email.com", "non",
                    LocalDate.parse("25/07/1995"), OuiNon.OUI);
            Prospect prospect4 = new Prospect("leclerc",
                    new Adresse("5", "liberation", "57670", "bobville"),
                    "+3385562012", "email@email.com", "non",
                    LocalDate.parse("25/07/1995"), OuiNon.NON);


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
*/