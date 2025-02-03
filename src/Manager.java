/**
 * Représente un Manager unique (implémentation du pattern Singleton).
 * Un Manager est un {@link Utilisateur} ayant des droits d'administration 
 * (comme la création de films, la programmation de séances, etc.).
 * 
 * <p>Exemple d'utilisation du singleton :
 * <pre>{@code
 * Manager manager = Manager.getManagerInstance("Ilyes", "Ilyes@example.com", "Lyly123");
 * manager.seConnecter();
 * }</pre>
 * 
 * Les méthodes de création de films et de programmation de séances 
 * (commentées dans ce code) illustrent les capacités supplémentaires 
 * d'un Manager par rapport à un simple {@link Utilisateur}.
 */
public class Manager extends Utilisateur {

    /**
     * L'unique instance de la classe {@code Manager}.
     * Cette classe suit le pattern Singleton.
     */
    private static Manager instance;

    /**
     * Constructeur privé pour empêcher l'instanciation directe.
     *
     * @param nom         Le nom du manager.
     * @param email       L'adresse email du manager.
     * @param motDePasse  Le mot de passe du manager.
     */
    private Manager(String nom, String email, String motDePasse) {
        super(nom, email, motDePasse);
    }

    /**
     * Retourne l'unique instance de la classe {@code Manager}.
     * Si aucune instance n'existe, elle est créée. Sinon, 
     * l'instance déjà existante est retournée.
     * 
     * @param nom         Le nom du manager (utilisé uniquement lors de la première création).
     * @param email       L'adresse email du manager (utilisée uniquement lors de la première création).
     * @param motDePasse  Le mot de passe du manager (utilisé uniquement lors de la première création).
     * @return            L'unique instance de {@code Manager}.
     */
    public static Manager getManagerInstance(String nom, String email, String motDePasse) {
        if (Manager.instance == null) {
            Manager.instance = new Manager(nom, email, motDePasse);
        }
        return Manager.instance;
    }

    /**
     * Connecte ce manager au système.
     * <p>
     * Dans cette implémentation, la connexion réussit toujours 
     * (retourne {@code true}).
     *
     * @return {@code true} si la connexion est considérée réussie, {@code false} sinon.
     */
    @Override
    public boolean seConnecter() {
        return true;
        // System.out.println("Manager " + nom + " est connecté.");
    }

    /**
     * Déconnecte ce manager du système.
     * <p>
     * Dans cette implémentation, la déconnexion réussit toujours 
     * (retourne {@code true}).
     *
     * @return {@code true} si la déconnexion est considérée réussie, {@code false} sinon.
     */
    @Override
    public boolean seDeconnecter() {
        return true;
        // System.out.println("Manager " + nom + " est déconnecté.");
    }

    /*
     * --------------------
     * Logique métier 
     * --------------------
     *
     * // Crée un nouveau film
     * public Film creerFilm(String titre, int duree) {
     *     Film film = new Film();
     *     film.setTitre(titre);
     *     film.setDureeMinutes(duree);
     *     System.out.println("Film créé : " + titre + " (" + duree + " min)");
     *     return film;
     * }
     *
     * // Programme une séance pour un film donné, dans une salle spécifique, à une date/heure donnée
     * public Seance programmerSeance(Film film, Salle salle, Date dateHeure) {
     *     Seance seance = new Seance();
     *     seance.setFilm(film);
     *     seance.setSalle(salle);
     *     seance.setDateHeure(dateHeure);
     *     System.out.println("Séance programmée pour le film : " + film.getTitre()
     *                        + ", dans la salle : " + salle.getNomSalle()
     *                        + ", le : " + dateHeure);
     *     return seance;
     * }
     */
}
