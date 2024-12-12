package entities;

import java.util.ArrayList;
import java.util.List;

public class Clients {
    public static ArrayList<Client> clients = new ArrayList<>();

    public static void ajouterClient(Client client) {
        clients.add(client);
    }

    public static List<Client> getClients() {
        return clients;
    }
}

