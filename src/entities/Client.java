package entities;

// classe fille de la classe abstraite société, classe soeur de Prospect. Gère les objets Client
public class Client extends Societe {
    private static int compteurIdClient = 1;
    long chiffreAffaires;
    int nbrEmployes;

    // rétablissement du constructeur implicite
    public Client() {
    }

    // lors de l'instanciation d'un nouvel objet client, l'id actuel est attribué, puis incrémenté pour le prochain objet instancié.

    public Client(String raisonSociale, Adresse adresse, String telephone, String email, String commentaire, long chiffreAffaires, int nbrEmployes) throws NullPointerException, SaisieException {
        super(compteurIdClient++, raisonSociale, adresse, telephone, email, commentaire);
        setChiffreAffaires(chiffreAffaires);
        setNbrEmployes(nbrEmployes);
    }


    public long getChiffreAffaires() {
        return chiffreAffaires;
    }

    // ce setter valide que le la valeur n'est ni nulle, ni inférieure à 200
    public void setChiffreAffaires(long chiffreAffaires) throws SaisieException {
        if (chiffreAffaires == 0 || chiffreAffaires < 200) {
            throw new SaisieException("chiffres d'affaires invalide");
        }
        this.chiffreAffaires = chiffreAffaires;
    }

    public int getNbrEmployes() {
        return nbrEmployes;
    }

    // ce setter valide que le la valeur n'est ni nulle, ni vide
    public void setNbrEmployes (int nbrEmployes) throws SaisieException {
            if (nbrEmployes <= 0) {
                throw new SaisieException("nbrEmployes invalide");
            }
        this.nbrEmployes = nbrEmployes;
        }

    // méthode static parce que methode "tampon" au sein de cette classe, servant à récuperer l'ID dans d'autres classes sans l'incrémentation
        public static int getCompteurIdClient() {
        return compteurIdClient;
        }

    // methode toString pour voir les valeurs contenues dans l'objet
    public String toString() {
        return "Client{"+super.toString()+"chiffre d'affaires :"+chiffreAffaires+"nombre employés" +nbrEmployes;
    }
}
