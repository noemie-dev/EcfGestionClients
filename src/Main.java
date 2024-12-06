import entities.Adresse;
import entities.Client;
import entities.Prospect;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Client client = new Client(0,"bob",new Adresse( "5","liberation","57","bobville"),"085562012","email@email.com","non",5454,55);
        Client client2 = new Client (0,"bob",new Adresse( "5","liberation","57","bobville"),"085562012","email@email.com","non",5454,55);
        Prospect prospect = new Prospect(0,"bob",new Adresse( "5","liberation","57","bobville"),"085562012","email@email.com","non","oui");
        Prospect prospect2 = new Prospect(0,"bob",new Adresse( "5","liberation","57","bobville"),"085562012","email@email.com","non","oui");
        System.out.println(client2);
        System.out.println(client);
        System.out.println(prospect);
        System.out.println(prospect2);
    }
}
