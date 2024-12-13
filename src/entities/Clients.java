package entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clients {
    public static ArrayList<Client> clients = new ArrayList<>();

    public static void ajouterClient(Client client) {
        clients.add(client);
    }

    public static List<Client> getClients() {
        return clients;
    }

    public static List<Client> triRaisonSociale() {
        return clients.stream()
                .sorted(Comparator.comparing(Client::getRaisonSociale,String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }
}

