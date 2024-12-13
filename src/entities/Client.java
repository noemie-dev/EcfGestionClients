package entities;

public class Client extends Societe {
    private static int compteurIdClient = 1;
    long chiffreAffaires;
    int nbrEmployes;


    public Client() {
    }

    public Client(String raisonSociale, Adresse adresse, String telephone, String email, String commentaire, long chiffreAffaires, int nbrEmployes) throws NullPointerException, SaisieException {
        super(compteurIdClient++, raisonSociale, adresse, telephone, email, commentaire);
        // lors de l'instanciation d'un nouvel objet client, l'id actuel est attribué, puis incrémenté pour le suivant.
        setChiffreAffaires(chiffreAffaires);
        setNbrEmployes(nbrEmployes);
    }


    public long getChiffreAffaires() {
        return chiffreAffaires;
    }

    public void setChiffreAffaires(long chiffreAffaires) throws SaisieException {
        if (chiffreAffaires == 0 || chiffreAffaires < 200) {
            throw new SaisieException("chiffres d'affaires invalide");
        }
        this.chiffreAffaires = chiffreAffaires;
    }

    public int getNbrEmployes() {
        return nbrEmployes;
    }

    public void setNbrEmployes (int nbrEmployes) throws SaisieException {
            if (nbrEmployes <= 0) {
                throw new SaisieException("nbrEmployes invalide");
            }
        this.nbrEmployes = nbrEmployes;
        }
        public static int getCompteurIdClient() { // en static parce que methode "tampon" au sein de cette classe pour récuperer l'ID sans l'incrémentation
        return compteurIdClient;
        }

    public String toString() {
        return "Client{"+super.toString()+"chiffre d'affaires :"+chiffreAffaires+"nombre employés" +nbrEmployes;
    }
}
