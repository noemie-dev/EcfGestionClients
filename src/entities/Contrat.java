package entities;

public class Contrat
{
    private static Integer idContrat;
    private Integer idClientContrat;
    private String nomContrat;
    private double montantContrat;

    public Contrat() {
    }

    public Contrat(Integer idContrat, String nomContrat, double montantContrat) {
        setIdContrat(idContrat);
        setNomContrat(nomContrat);
    }

    public void setIdContrat(Integer idContrat) {
        this.idContrat = idContrat;
    }
    public Integer getIdContrat() {
        return idContrat;
    }

    public void setIdClientContrat(Integer idClientContrat) {
        this.idClientContrat = idClientContrat;
    }
    public Integer getIdClientContrat() {
        return idClientContrat;
    }


    public void setNomContrat(String nomContrat) {
        this.nomContrat = nomContrat;
    }

    public String getNomContrat() {
        return nomContrat;
    }

    public double getMontantContrat() {
        return montantContrat;
    }

    public void setMontantContrat(double montantContrat) {
        this.montantContrat = montantContrat;
    }
}
