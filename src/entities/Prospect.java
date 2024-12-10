package entities;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import utilities.OuiNon;


public class Prospect extends Societe {
    private static int compteurIdProspect = 1;
    String dateProspect;
    LocalDate dateProspection;
    String interetProspect;
    private OuiNon reponseInteret;

    public Prospect() {
    }

    public Prospect(int id, String raisonSociale, Adresse adresse, String telephone, String email, String commentaire, String dateProspect, String interetProspect) throws NullPointerException, SaisieException {
        super(id, raisonSociale, adresse, telephone, email, commentaire);
        setId(compteurIdProspect++);
        setDateProspection(dateProspect);
        /*setInteretProspect(reponseInteret);*/
        setInteretProspect(interetProspect);
    }

    public LocalDate getDateProspection() {
        return dateProspection;
    }

    public void setDateProspection(String dateProspect) {
        this.dateProspection = LocalDate.parse(dateProspect, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public OuiNon getInteretProspect() {
        return reponseInteret;
    }

    /*public void setInteretProspect(OuiNon reponseInteret) {
        this.reponseInteret = OuiNon.valueOf(interetProspect.toUpperCase());
        }*/
    public void setInteretProspect(String interetProspect) {
        this.interetProspect = interetProspect;
    }

}
