import java.util.Set;
import java.util.HashSet;

/**
 * Représente une réservation faite par un {@link Utilisateur}, contenant un ou plusieurs billets.
 * Chaque réservation dispose d'un identifiant unique (généré automatiquement), 
 * d'un ensemble de billets et d'un utilisateur à l'origine de la réservation.
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * Utilisateur client = new Client("JeanYves", "JY@example.com", "JYJY123");
 * Set<Billet> billets = new HashSet<>();
 * billets.add(new Billet(...));
 * billets.add(new Billet(...));
 *
 * Reservation resa = new Reservation(client, billets);
 * System.out.println("Réservation n° " + resa.getId() + " pour " + client.getNom());
 * System.out.println("Prix total : " + resa.getPrixTotal());
 * }</pre>
 * 
 * <p>Les billets peuvent être ajoutés un par un via {@link #addBillet(Billet)}, 
 * et récupérés via {@link #getBillets()}. Le prix total de la réservation 
 * est obtenu par la méthode {@link #getPrixTotal()}.
 *  
 * 
 */
public class Reservation {

    /**
     * Prochain identifiant unique disponible pour une nouvelle réservation.
     * Incrémenté automatiquement à chaque création de réservation.
     */
    private static int nextAvailableId = 1;

    /**
     * Identifiant unique de cette réservation.
     */
    private int id;

    /**
     * Ensemble des billets associés à cette réservation.
     */
    private Set<Billet> billetsReservation;

    /**
     * Utilisateur ayant effectué cette réservation.
     */
    private Utilisateur utilisateurResa;

    /**
     * Construit une nouvelle réservation pour l'utilisateur donné, sans billets initiaux.
     *
     * @param u L'utilisateur à l'origine de la réservation.
     */
    public Reservation(Utilisateur u) {
        this.id = this.getNextAvailableId();
        this.utilisateurResa = u;
        this.billetsReservation = new HashSet<Billet>();
    }

    /**
     * Construit une nouvelle réservation pour l'utilisateur donné, 
     * avec un ensemble initial de billets.
     *
     * @param u           L'utilisateur à l'origine de la réservation.
     * @param billetsResa L'ensemble initial de billets associés à la réservation
     *                    (peut être {@code null}).
     *                    Si {@code null}, un nouvel ensemble vide est créé.
     */
    public Reservation(Utilisateur u, Set<Billet> billetsResa) {
        this.id = this.getNextAvailableId();
        this.utilisateurResa = u;
        if (billetsResa == null) {
            this.billetsReservation = new HashSet<Billet>();
        } else {
            this.billetsReservation = new HashSet<Billet>();
            // On ignore simplement les élements de billetsResa à valeur nulle
            for (Billet b : billetsResa) {
                if (b != null) {
                    this.billetsReservation.add(b);
                }
            }
        }
    }

    /**
     * Génère et retourne le prochain identifiant unique pour une nouvelle réservation,
     * puis l'incrémente pour la future réservation.
     *
     * @return Le prochain identifiant disponible pour une réservation.
     */
    protected int getNextAvailableId() {
        int nextID = Reservation.nextAvailableId;
        Reservation.nextAvailableId += 1;
        return nextID;
    }

    /**
     * Retourne l'identifiant unique de cette réservation.
     *
     * @return L'identifiant de la réservation.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Ajoute un billet à l'ensemble des billets de cette réservation.
     * Si le billet est {@code null}, il est ignoré.
     *
     * @param b Le billet à ajouter.
     */
    public void addBillet(Billet b) {
        if (b != null) {
            this.billetsReservation.add(b);
        }
    }

    /**
     * Retourne l'ensemble des billets associés à cette réservation.
     *
     * @return Un {@link Set} de billets pour cette réservation.
     */
    public Set<Billet> getBillets() {
        return this.billetsReservation;
    }

    /**
     * Calcule et retourne le prix total de cette réservation en 
     * additionnant le prix de chaque billet.
     *
     * @return Le prix total de la réservation.
     */
    public double getPrixTotal() {
        double prixFinal = 0;
        for (Billet b : this.billetsReservation) {
            prixFinal += b.getPrix();
        }
        return prixFinal;
    }
}
