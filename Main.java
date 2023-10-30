public class Main {
    public static void main(String[] args) {
        // Create some students
        Etudiant3eme etudiant1 = new Etudiant3eme(1, "John", "Doe", 85.0f, "Mathematics");
        Etudiant3eme etudiant2 = new Etudiant3eme(2, "Alice", "Smith", 78.5f, "Physics");
        EtudiantAlternance etudiant3 = new EtudiantAlternance(3, "Bob", "Johnson", 92.0f, 1000);

        // Create two schools
        Ecole ecole1 = new Ecole("School A");
        Ecole ecole2 = new Ecole("School B");

        // Add students to the first school
        ecole1.ajouterEtudiant(etudiant1);
        ecole1.ajouterEtudiant(etudiant2);

        // Add students to the second school
        ecole2.ajouterEtudiant(etudiant3);

        // Print information about the schools and students
        System.out.println("School 1:");
        System.out.println(ecole1.toString());

        System.out.println("School 2:");
        System.out.println(ecole2.toString());

        // Change the school of an existing student
        ecole1.changerEcole(etudiant2, ecole2);

        // Print updated information about the schools
        System.out.println("Updated School 1:");
        System.out.println(ecole1.toString());

        System.out.println("Updated School 2:");
        System.out.println(ecole2.toString());
    }
}
