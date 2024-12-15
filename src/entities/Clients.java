package entities;
// importation de l'arraylist pour contenir les objets Clients instanciés
import java.util.ArrayList;
// importation du comparator pour trier l'Arraylist par ordre alphabetique de raison sociale
import java.util.Comparator;
import java.util.List;
// importation du stream qui permet de parcourir l'arraylist plus rapidement
import java.util.stream.Collectors;

public class Clients {

    // instanciation d'une nouvelle Arraylist Client
    public static ArrayList<Client> clients = new ArrayList<>();

    // methode de classe pour ajouter les clients instanciés dans l'Arraylist
    public static void ajouterClient(Client client) {
        clients.add(client);
    }

    // methode de classe pour récuperer la liste des clients
    public static List<Client> getClients() {
        return clients;
    }

    // méthode de classe permettant de trier la raison sociale
    public static List<Client> triRaisonSociale() {
        return clients.stream()
                .sorted(Comparator.comparing(Client::getRaisonSociale,String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }
}

