/**
 * Représente un client du système hérité de la classe {@link Utilisateur}.
 * Un client peut se connecter, se déconnecter, et potentiellement (dans des méthodes commentées) 
 * réserver et payer des séances.
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * Client client = new Client("Arthur", "arthur@example.com", "tutur123");
 * client.seConnecter();
 * }</pre>
 *
 */
public class Client extends Utilisateur {

    /**
     * Construit un nouveau client avec le nom, l'email et le mot de passe spécifiés.
     *
     * @param nom        Le nom du client.
     * @param email      L'adresse email du client.
     * @param motDePasse Le mot de passe du client.
     */
    public Client(String nom, String email, String motDePasse) {
        super(nom, email, motDePasse);
    }

    /**
     * Connecte ce client au système.
     * <p>
     * Dans cette implémentation, la connexion réussit systématiquement 
     * (retourne toujours {@code true}).
     *
     * @return {@code true} si la connexion est considérée réussie, {@code false} sinon.
     */
    @Override
    public boolean seConnecter() {
        return true;
        // System.out.println("Client " + nom + " est connecté.");
    }

    /**
     * Déconnecte ce client du système.
     * <p>
     * Dans cette implémentation, la déconnexion réussit systématiquement 
     * (retourne toujours {@code true}).
     *
     * @return {@code true} si la déconnexion est considérée réussie, {@code false} sinon.
     */
    @Override
    public boolean seDeconnecter() {
        return true;
        // System.out.println("Client " + nom + " est déconnecté.");
    }

    /*
     * --- Méthodes supplémentaires ---
     *
     * // Réserver une séance
     * public Reservation reserverSeance(Seance seance) {
     *     System.out.println("Réservation d'une séance pour le film : "
     *                        + seance.getFilm().getTitre());
     *     // Exemple : création d’une nouvelle réservation
     *     Reservation reservation = new Reservation();
     *     reservation.setClient(this);
     *     reservation.setSeance(seance);
     *     // On peut imaginer que la date de réservation est la date courante
     *     reservation.setDateReservation(new java.util.Date());
     *
     *     // Logique supplémentaire : vérifier places, etc.
     *     // ...
     *
     *     return reservation;
     * }
     *
     * // Payer une réservation
     * public void payerReservation(Reservation reservation) {
     *     System.out.println("Le client " + nom
     *                        + " paie la réservation n° "
     *                        + reservation.getIdReservation());
     *     // Logique de paiement...
     * }
     *
     */
}
