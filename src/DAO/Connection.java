package DAO;

public class Connection {

        private static Connection instance; // Instance unique de la classe

        // Constructeur privé pour empêcher l'instanciation directe
        private Connection() {
            System.out.println("Nouvelle connexion créée !");
        }

        // Méthode de classe pour obtenir l'instance unique
        public static Connection getInstance() {
            if (instance == null) { // Vérifie si l'instance existe
                instance = new Connection(); // Crée une nouvelle instance
            } else {
                System.out.println("Instance existante retournée !");
            }
            return instance;
        }
    }

