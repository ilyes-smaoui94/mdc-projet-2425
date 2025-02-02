/**
 * Représente une salle (par exemple, de cinéma ou de spectacle), 
 * identifiée de manière unique et caractérisée par un numéro et une capacité.
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * Salle salle1 = new Salle(1, 100);
 * System.out.println("Salle ID: " + salle1.getId());
 * System.out.println("Numéro de la salle: " + salle1.getNumero());
 * System.out.println("Capacité: " + salle1.getCapacite());
 * }</pre>
 * </p>
 * 
 * <p>
 * Le champ {@link #nextAvailableId} est un identifiant statique auto-incrémenté 
 * qui garantit l'unicité de chaque salle créée.
 * </p>
 * 
 */
public class Salle {

    /**
     * Prochain identifiant disponible pour une nouvelle salle.
     * Incrémenté automatiquement à chaque création d'objet {@code Salle}.
     */
    private static int nextAvailableId = 1;

    /**
     * Identifiant unique de cette salle.
     */
    private int id;

    /**
     * Numéro distinctif de la salle.
     */
    private int numero;

    /**
     * Capacité (nombre de places) de la salle.
     */
    private int capacite;

    /**
     * Construit une nouvelle salle en précisant son numéro et sa capacité.
     * L'identifiant est automatiquement généré.
     *
     * @param numero   Le numéro distinctif de la salle.
     * @param capacite La capacité (nombre de places) de la salle.
     */
    public Salle(int numero, int capacite) {
        this.id = Salle.getNextAvailableId();
        this.numero = numero;
        this.capacite = capacite;
    }

    /**
     * Retourne le prochain identifiant disponible pour une salle 
     * puis l'incrémente pour la future création de salle.
     *
     * @return Le prochain identifiant unique.
     */
    protected static int getNextAvailableId() {
        int nextID = Salle.nextAvailableId;
        Salle.nextAvailableId += 1;
        return nextID;
    }

    /**
     * Retourne l'identifiant unique de cette salle.
     *
     * @return L'identifiant unique de la salle.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retourne le numéro de la salle.
     *
     * @return Le numéro de la salle.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Modifie le numéro de la salle.
     *
     * @param numero Le nouveau numéro de la salle.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Retourne la capacité de la salle (nombre de places disponibles).
     *
     * @return La capacité de la salle.
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * Modifie la capacité (nombre de places) de la salle.
     *
     * @param capacite La nouvelle capacité de la salle.
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
