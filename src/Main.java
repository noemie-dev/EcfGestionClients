import entities.Adresse;
import entities.Client;
import entities.Prospect;
import entities.SaisieException;


public class Main {
    public static void main(String[] args) throws NullPointerException, SaisieException {
        System.out.println("Hello, World!");
        remplissage();

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
