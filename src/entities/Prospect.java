package entities;


//importation du pattern pour la date de prospection et exception pour prévenir d'une saisie de date dans un mauvais format
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
// importation de l'énumération pour contrôler la saisie de l'intérêt du prospect dans une combobox
import utilities.OuiNon;

/** classe fille de la classe abstraite société, classe soeur de Client. Gère les objets Prospect.
 */
public class Prospect extends Societe {
    private static int compteurIdProspect = 1;
    String dateProspect;
    LocalDate dateProspection;
    private OuiNon reponseInteret;

// rétablissement du constructeur implicite
    public Prospect() {
    }

// constructeur qui reprend les paramètres de l'objet mère Société et ajoute les paramètres propres à l'objet Prospect
    public Prospect(String raisonSociale, Adresse adresse, String telephone, String email, String commentaire, String dateProspect, String interetProspect) throws NullPointerException, SaisieException {
        super(compteurIdProspect++, raisonSociale, adresse, telephone, email, commentaire);
        setDateProspection(dateProspect);
        setInteretProspect(interetProspect);

    }

    // getters et setters
    public LocalDate getDateProspection() {
        return dateProspection;
    }

    // setter qui contrôle l'entrée en string de la date et la convertit en LocalDate, en respectant un pattern
    public void setDateProspection(String dateProspect) throws SaisieException {
        try {
            this.dateProspection = LocalDate.parse(dateProspect, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeException e) {
            throw new SaisieException(e.getMessage());
        }
    }

    public OuiNon getInteretProspect() {
        return reponseInteret;
    }

    /* dans ce setter :   si le string interetProspect saisi par l'utilisateur comporte une des valeurs présentes dans l'enum OuiNon
     * alors je l'assigne dans la propriété reponseInteret
     * sinon cela renvoie une exception
     */
    public void setInteretProspect(String interetProspect) throws SaisieException {
        try {
            this.reponseInteret = OuiNon.valueOf(interetProspect.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            throw new SaisieException(e.getMessage());
        }

    }

    // la methode toString pour voir le contenu des variables de l'objet
    @Override
    public String toString() {
        return "Prospect{" +
                super.toString() +
                "dateProspect='" + dateProspect + '\'' +
                ", dateProspection=" + dateProspection +
                ", reponseInteret=" + reponseInteret +
                '}';
    }
}
