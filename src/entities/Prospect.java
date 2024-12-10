package entities;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import utilities.OuiNon;


public class Prospect extends Societe {
    private static int compteurIdProspect = 1;
    String dateProspect;
    LocalDate dateProspection;
    private OuiNon reponseInteret;

    public Prospect() {
    }

    public Prospect(int id, String raisonSociale, Adresse adresse, String telephone, String email, String commentaire, String dateProspect, String interetProspect) throws NullPointerException, SaisieException {
        super(id, raisonSociale, adresse, telephone, email, commentaire);
        setId(compteurIdProspect++);
        setDateProspection(dateProspect);
        System.out.println(dateProspect);
        setInteretProspect(interetProspect);
        System.out.println(interetProspect);
    }

    public LocalDate getDateProspection() {
        return dateProspection;
    }

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

    // si dans mon enum oui non il y a la meme valeur que dans mon string interetprospect, alors je l'assigne dans ma propriété reponseInteret

    public void setInteretProspect(String interetProspect) throws SaisieException {
        try {
            this.reponseInteret = OuiNon.valueOf(interetProspect.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            throw new SaisieException(e.getMessage());
        }

    }

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
