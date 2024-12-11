package entities;

import static entities.Clients.clients;
import static utilities.Regex.PATTERN_TELEPHONE;
import static utilities.Regex.PATTERN_EMAIL;

public abstract class Societe {
    private int id; // identifiant de la société
    private String raisonSociale;
    private Adresse adresse;
    private String telephone;
    private String email;
    private String commentaire = " ";

    // rétablissement du constructeur implicite

    public Societe() {
    }

    // constructeur avec tous les paramètres

    public Societe(int id, String raisonSociale, Adresse adresse, String telephone, String email, String commentaire) throws NullPointerException, SaisieException {
        setId(id);
        setRaisonSociale(raisonSociale);
        setAdresse(adresse);
        setTelephone(telephone);
        setEmail(email);
        setCommentaire(commentaire);
    }

    // Getters et setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) throws NullPointerException, SaisieException {
        if (raisonSociale == null || raisonSociale.trim().isEmpty()) {
            throw new NullPointerException();
            // dans méthode à part : ! renvoie un boolean : recup liste client et prospect, puis .stream // fluidifie recherche en faisant sorting avec tableau, .anymatch pour tout chercher, .equalsignorecase fait en sorte d'ignorer la casse
        }
        if (clients.contains(raisonSociale)) {
            throw new SaisieException("Erreur : cette r  aison sociale existe déjà");

        }
        else this.raisonSociale = raisonSociale;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) throws NullPointerException {
        if (adresse == null) {
            throw new NullPointerException();
        }
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) throws NullPointerException, SaisieException {
        if (telephone == null || telephone.trim().isEmpty()) {
            throw new NullPointerException();
        }
        if (PATTERN_TELEPHONE.matcher(telephone).matches()) {
            this.telephone = telephone;
        }
        else {
            throw new SaisieException("Erreur : Telephone invalide");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws NullPointerException, SaisieException {
        if (email == null || email.trim().isEmpty()) {
            throw new NullPointerException();
        }
        if (PATTERN_EMAIL.matcher(email).matches()) {
            this.email = email;
        }
        else
        {throw new SaisieException( "Erreur : Email invalide");
        };
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    // methode ToString pour afficher les variables contenues dans l'objet

    @Override
    public String toString() {
        return "Societe{" +
                "id=" + id +
                ", raisonSociale='" + raisonSociale + '\'' +
                ", adresse=" + adresse +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }


}
