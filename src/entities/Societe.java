package entities;

/** la classe mère Société abstraite. Ne peut pas instancier d'objet mais donne le modèle
 *  pour les classes filles Client et Prospect, auxquelles sont ajoutées des variables propres aux besoins de ces classes.
 */

// importation d'un pattern pour controler le format de saisie du téléphone et du mail
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

    // setter qui teste que la raison sociale ne soit ni nulle, ni vide, ni déjà présente dans une des deux Arraylists
    public void setRaisonSociale(String raisonSociale) throws NullPointerException, SaisieException {
        if (raisonSociale == null || raisonSociale.trim().isEmpty()) {
            throw new NullPointerException();
            // dans méthode à part : ! renvoie un boolean : recup liste client et prospect, puis .stream // fluidifie recherche en faisant sorting avec tableau, .anymatch pour tout chercher, .equalsignorecase fait en sorte d'ignorer la casse
        }
        if (RaisonSocialeClientDoublon(raisonSociale)) {
            throw new SaisieException("Erreur : Cette raison sociale est déjà enregistrée.");
        }
        if (RaisonSocialeProspectDoublon(raisonSociale)) {
            throw new SaisieException("Erreur : Cette raison sociale est déjà enregistrée.");
        }
        else this.raisonSociale = raisonSociale;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    // setter qui vérifie que l'adresse n'est pas vide avant d'être instanciée
    public void setAdresse(Adresse adresse) throws NullPointerException {
        if (adresse == null) {
            throw new NullPointerException();
        }
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    // setter qui contrôle que le champ téléphone n'est ni nul, ni vide, et respecte le pattern du téléphone
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

    // setter qui contrôle que le champ téléphone n'est ni nul, ni vide, et respecte le pattern du mail
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

    // méthodes qui parcourent chaque Arraylist pour vérifier que la raison sociale entrée n'est pas déjà présente dans la liste avant de l'instancier
    private boolean RaisonSocialeClientDoublon(String raisonSociale) {
        return Clients.getClients().stream().anyMatch(client -> client.getRaisonSociale().equalsIgnoreCase(raisonSociale) && !client.equals(this));
    }

    private boolean RaisonSocialeProspectDoublon(String raisonSociale) {
        return Prospects.getProspects().stream().anyMatch(prospect -> prospect.getRaisonSociale().equalsIgnoreCase(raisonSociale) && !prospect.equals(this));
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
