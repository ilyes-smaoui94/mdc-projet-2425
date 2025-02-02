/**
 * Représente un billet abstrait pour une séance de cinéma. 
 * Chaque billet est associé à une {@link Seance} et possède un identifiant unique 
 * qui est incrémenté automatiquement à chaque nouvelle instance.
 *
 * <p>
 * Les classes concrètes héritées de {@code Billet} doivent implémenter 
 * la méthode {@link #getPrix()}, qui calcule et retourne le prix du billet.
 * </p>
 *
 * <p>Exemple d'utilisation (hypothétique) :
 * <pre>{@code
 * // Suppose qu'il existe une classe concrete "BilletAdulte" qui hérite de Billet
 * Seance seance = new Seance(...);
 * Billet billetAdulte = new BilletAdulte(seance);
 * System.out.println("ID du billet : " + billetAdulte.getId());
 * System.out.println("Prix du billet : " + billetAdulte.getPrix());
 * }</pre>
 * </p>
 * 
 */
public abstract class Billet {

    /**
     * Prochain identifiant unique disponible pour un nouveau billet.
     * Incrémenté automatiquement à chaque création de {@code Billet}.
     */
    private static int nextAvailableId = 1;

    /**
     * Identifiant unique de ce billet.
     */
    private int id;

    /**
     * La séance à laquelle ce billet est associé.
     */
    private Seance seanceBillet;

    /**
     * Construit un billet associé à la séance spécifiée.
     * L'identifiant du billet est généré automatiquement.
     *
     * @param seanceBillet La séance pour laquelle ce billet est émis.
     */
    public Billet(Seance seanceBillet) {
        this.seanceBillet = seanceBillet;
        this.id = this.getNextAvailableId();
    }

    /**
     * Génère et retourne le prochain identifiant unique pour un nouveau billet,
     * puis l'incrémente pour la future création.
     *
     * @return Le prochain identifiant unique de billet.
     */
    protected static int getNextAvailableId() {
        int nextID = nextAvailableId;
        Billet.nextAvailableId += 1;
        return nextID;
    }

    /**
     * Retourne le prix de ce billet. 
     * Doit être implémenté par les classes concrètes héritant de {@code Billet}.
     *
     * @return Le prix du billet.
     */
    public abstract double getPrix();

    /**
     * Retourne l'identifiant unique de ce billet.
     *
     * @return L'identifiant du billet.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retourne la séance associée à ce billet.
     *
     * @return La séance du billet.
     */
    public Seance getSeance() {
        return this.seanceBillet;
    }
}
