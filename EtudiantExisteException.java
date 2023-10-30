public class EtudiantExisteException extends Exception {
    public EtudiantExisteException() {
        super("Étudiant déjà existant.");
    }

    public EtudiantExisteException(String message) {
        super(message);
    }
}
