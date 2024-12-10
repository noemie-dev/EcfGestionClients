package entities;
import static utilities.Regex.PATTERN_CODE_POSTAL;

public class Adresse {
    private String rueNb;
    private String rueNom;
    private String codePostal;
    String ville;

    // rétablissement du constructeur implicite

    public Adresse() {

    }
    // constructeur avec tous les paramètres

    public Adresse(String rueNb, String rueNom, String codePostal, String ville) throws  NullPointerException, SaisieException {
       setRueNb(rueNb);
        setRueNom(rueNom);
        setCodePostal(codePostal);
        setVille(ville);
    }
    // Getters et setters

    public String getRueNb() {
        return rueNb;
    }

    public void setRueNb(String rueNb) throws NullPointerException {
        if (rueNb == null ||rueNb.trim().isEmpty()) {
            throw new NullPointerException();
        }
        this.rueNb = rueNb;
    }

    public String getRueNom() {
        return rueNom;
    }

    public void setRueNom(String rueNom) throws NullPointerException {
        if (rueNom == null ||rueNom.trim().isEmpty()) {
            throw new NullPointerException();
        }
        this.rueNom = rueNom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) throws NullPointerException, SaisieException {
        if (codePostal == null || codePostal.trim().isEmpty()) {
            throw new NullPointerException();
        }
        if (PATTERN_CODE_POSTAL.matcher(codePostal).matches()) {
            this.codePostal = codePostal;
        }
        else { throw new SaisieException("Erreur : code postal invalide"); }
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) throws NullPointerException {
        if (ville == null || ville.trim().isEmpty()) {
            throw new NullPointerException();
        }
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