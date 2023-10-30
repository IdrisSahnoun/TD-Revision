public class EtudiantAlternance extends Etudiant {
    private int salaire;

    public EtudiantAlternance(int identifiant, String nom, String prenom, float moyenne, int salaire) {
        super(identifiant, nom, prenom, moyenne);
        this.salaire = salaire;
    }

    @Override
    public void ajouterUneAbsence() {
        int nouveauSalaire = getSalaire() - 50;
        setSalaire(nouveauSalaire);
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
    @Override
    public String toString() {
        return "EtudiantAlternance{" +
                "identifiant=" + getIdentifiant() +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", moyenne=" + getMoyenne() +
                ", salaire=" + salaire +
                '}';
    }
}
