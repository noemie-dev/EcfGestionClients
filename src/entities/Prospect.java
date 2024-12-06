package entities;

import java.time.LocalDate;

public class Prospect extends Societe {
    private static int compteurIdProspect = 1;
    LocalDate dateProspection;
    String interetProspect;

    public Prospect() {
    }

    public Prospect(int id, String raisonSociale, Adresse adresse, String telephone, String email, String commentaire/*, LocalDate dateProspection*/, String interetProspect) {
        super(id, raisonSociale, adresse, telephone, email, commentaire);
        setId(compteurIdProspect++);
        //setDateProspection(dateProspection);
        setInteretProspect(interetProspect);
    }

    public LocalDate getDateProspection() {
        return dateProspection;
    }

    public void setDateProspection(LocalDate dateProspection) {
        this.dateProspection = dateProspection;
    }

    public String getInteretProspect() {
        return interetProspect;
    }

    public void setInteretProspect(String interetProspect) {
        this.interetProspect = interetProspect;
    }

}
