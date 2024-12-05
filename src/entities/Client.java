package entities;

public class Client extends Societe {
    int compteurIdClient;
    long chiffreAffaires;
    int nbrEmployes;


    public Client() {
    }

    public Client(int id, String raisonSociale, Adresse adresse, String telephone, String email, String commentaire, long chiffreAffaires, int nbrEmployes) {
        super(id, raisonSociale, adresse, telephone, email, commentaire);
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
