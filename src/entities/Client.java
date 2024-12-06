package entities;

public class Client extends Societe {
    private static int compteurIdClient = 1;
    long chiffreAffaires;
    int nbrEmployes;


    public Client() {
    }

    public Client( int id, String raisonSociale, Adresse adresse, String telephone, String email, String commentaire, long chiffreAffaires, int nbrEmployes) {
        super(id, raisonSociale, adresse, telephone, email, commentaire);
        setId(compteurIdClient++); // lors de l'instanciation d'un nouvel objet client, l'id actuel est attribué, puis incrémenté pour le suivant.
        setChiffreAffaires(chiffreAffaires);
        setNbrEmployes(nbrEmployes);
    }


    public long getChiffreAffaires() {
        return chiffreAffaires;
    }

    public void setChiffreAffaires(long chiffreAffaires) {
        this.chiffreAffaires = chiffreAffaires;
    }

    public int getNbrEmployes() {
        return nbrEmployes;
    }

    public void setNbrEmployes(int nbrEmployes) {
        this.nbrEmployes = nbrEmployes;
    }

    public String toString() {
        return super.toString()+"chiffre d'affaires :"+chiffreAffaires+"nombre employés" +nbrEmployes;
    }
}
