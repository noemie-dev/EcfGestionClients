package entities;

public class Adresse {
    private String rueNb;
    private String rueNom;
    private String codePostal;
    String ville;

    // rétablissement du constructeur implicite

    public Adresse() {

    }
    // constructeur avec tous les paramètres

    public Adresse(String rueNb, String rueNom, String codePostal, String ville) {
       setRueNb(rueNb);
        setRueNom(rueNom);
        setCodePostal(codePostal);
        setVille(ville);
    }
    // Getters et setters

    public String getRueNb() {
        return rueNb;
    }

    public void setRueNb(String rueNb) {
        this.rueNb = rueNb;
    }

    public String getRueNom() {
        return rueNom;
    }

    public void setRueNom(String rueNom) {
        this.rueNom = rueNom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    // methode ToString pour afficher les variables contenues dans l'objet

    @Override
    public String toString() {
        return "Adresse{" +
                "rueNb='" + rueNb + '\'' +
                ", rueNom='" + rueNom + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
