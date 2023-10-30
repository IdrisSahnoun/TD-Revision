public class Etudiant3eme extends Etudiant {
    private String branche;

    public Etudiant3eme(int identifiant, String nom, String prenom, float moyenne, String branche) {
        super(identifiant, nom, prenom, moyenne);
        this.branche = branche;
    }

    @Override
    public void ajouterUneAbsence() {
        float nouvelleMoyenne = getMoyenne() - 0.5f;
        setMoyenne(nouvelleMoyenne);
    }

    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }
}
