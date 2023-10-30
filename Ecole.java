import java.util.Arrays;

public class Ecole {
    private String nom;
    private Etudiant[] etudiants;
    private int nombreEtudiants;

    public Ecole(String nom) {
        this.nom = nom;
        this.etudiants = new Etudiant[500];
        this.nombreEtudiants = 0;
    }

    // Méthode pour ajouter un étudiant
    public void ajouterEtudiant(Etudiant etudiant) {
        if (nombreEtudiants < etudiants.length) {
            // Vérifie si l'étudiant n'est pas déjà inscrit
            if (!estDejaInscrit(etudiant)) {
                etudiants[nombreEtudiants] = etudiant;
                nombreEtudiants++;
                System.out.println("Étudiant ajouté avec succès.");
            } else {
                System.out.println("Cet étudiant est déjà inscrit dans l'école.");
            }
        } else {
            System.out.println("L'école est pleine, impossible d'ajouter plus d'étudiants.");
        }
    }

    // Méthode pour vérifier si un étudiant est déjà inscrit
    private boolean estDejaInscrit(Etudiant etudiant) {
        for (int i = 0; i < nombreEtudiants; i++) {
            if (etudiants[i].equals(etudiant)) {
                return true; // L'étudiant est déjà inscrit
            }
        }
        return false; // L'étudiant n'est pas encore inscrit
    }
    public float getMoyenneDes3A() {
        float sommeDesMoyennes = 0;
        int nombreEtudiants3A = 0;

        for (int i = 0; i < nombreEtudiants; i++) {
            if (etudiants[i] instanceof Etudiant3eme) {
                Etudiant3eme etudiant3A = (Etudiant3eme) etudiants[i]; // Cast vers Etudiant3eme
                sommeDesMoyennes += etudiant3A.getMoyenne();
                nombreEtudiants3A++;
            }
        }

        if (nombreEtudiants3A > 0) {
            return sommeDesMoyennes / nombreEtudiants3A;
        } else {
            return 0; // Si aucun étudiant de 3ème année n'est trouvé, retourne 0.
        }
    }
    public float moyenneSalaireAlternants() {
        int sommeDesSalaires = 0;
        int nombreEtudiantsAlternants = 0;

        for (int i = 0; i < nombreEtudiants; i++) {
            if (etudiants[i] instanceof EtudiantAlternance) {
                EtudiantAlternance etudiantAlternance = (EtudiantAlternance) etudiants[i]; // Cast vers EtudiantAlternance
                sommeDesSalaires += etudiantAlternance.getSalaire();
                nombreEtudiantsAlternants++;
            }
        }

        if (nombreEtudiantsAlternants > 0) {
            return (float) sommeDesSalaires / nombreEtudiantsAlternants;
        } else {
            return 0.0f; // Si aucun étudiant en alternance n'est trouvé, retourne 0.0
        }
    }
    public void changerEcole(Etudiant etudiant, Ecole nouvelleEcole) {
        int indiceEtudiant = -1;

        // Recherche de l'indice de l'étudiant dans l'école actuelle
        for (int i = 0; i < nombreEtudiants; i++) {
            if (etudiants[i].equals(etudiant)) {
                indiceEtudiant = i;
                break;
            }
        }

        if (indiceEtudiant != -1) {
            // Retirer l'étudiant de l'école actuelle
            Etudiant etudiantARetirer = etudiants[indiceEtudiant];
            for (int i = indiceEtudiant; i < nombreEtudiants - 1; i++) {
                etudiants[i] = etudiants[i + 1];
            }
            nombreEtudiants--;

            // Ajouter l'étudiant à la nouvelle école
            nouvelleEcole.ajouterEtudiant(etudiantARetirer);
            System.out.println("Étudiant " + etudiantARetirer.getNom() + " a changé d'école.");
        } else {
            System.out.println("Étudiant non trouvé dans l'école actuelle.");
        }
    }
    @Override
    public String toString() {
        StringBuilder infoEcole = new StringBuilder();
        infoEcole.append("École : ").append(nom).append("\n");

        for (int i = 0; i < nombreEtudiants; i++) {
            infoEcole.append(etudiants[i].toString()).append("\n");
        }

        return infoEcole.toString();
    }
}
