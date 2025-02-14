
import DAO.DaoClient;
import gestionlog.LoggerInit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

import static DAO.ConnexionManager.getConnection;
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

        System.out.println(getConnection());
        try {
            DaoClient.findall(getConnection(),"ecf_bdd");
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
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