import java.util.Set;
import java.util.HashSet;

/**
 * Représente un film avec un titre, une année de sortie, une description et un ensemble de genres.
 * Chaque film est identifié par un identifiant unique automatiquement généré.
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * Set<Genre> genres = new HashSet<>();
 * genres.add(Genre.ACTION);
 * Film film = new Film("Inception", 2010, "Un film de science-fiction", genres);
 * }</pre>
 * 
 * <p>Les genres associés à un film peuvent être gérés via {@link #addGenre(Genre)}, 
 * {@link #removeGenre(Genre)} ou {@link #setGenres(Set)}.
 * 
 */
public class Film {
    
    /**
     * Prochain identifiant disponible pour la création d'un nouveau film.
     * Incrémenté automatiquement à chaque nouvelle instance.
     */
    private static int nextAvailableId = 1;
    
    /**
     * Identifiant unique du film.
     */
    private int id;
    
    /**
     * Titre du film.
     */
    private String titre;
    
    /**
     * Année de sortie du film.
     */
    private int annee;
    
    /**
     * Description du film.
     */
    private String description;
    
    /**
     * Ensemble des genres associés à ce film.
     */
    private Set<Genre> genres;

    /**
     * Construit un nouveau film avec un titre, une année et une description.
     * L'ensemble des genres est initialement vide.
     *
     * @param t Le titre du film.
     * @param a L'année de sortie du film.
     * @param d La description du film.
     */
    public Film(String t, int a, String d) {
        this.id = this.getNextAvailableId();
        this.titre = t;
        this.annee = a;
        this.description = d;
        this.genres = new HashSet<Genre>();
    }

    /**
     * Construit un nouveau film avec un titre, une année, une description et un ensemble de genres initial.
     *
     * @param t Le titre du film.
     * @param a L'année de sortie du film.
     * @param d La description du film.
     * @param g L'ensemble de genres associé au film (peut être {@code null}).
     *          Si {@code null}, un nouvel ensemble vide est créé.
     */
    public Film(String t, int a, String d, Set<Genre> g) {
        this.id = this.getNextAvailableId();
        this.titre = t;
        this.annee = a;
        this.description = d;
        this.genres = g != null ? g : new HashSet<Genre>();
    }

    /**
     * Retourne le prochain identifiant disponible pour un film et l'incrémente.
     *
     * @return Le prochain identifiant disponible.
     */
    protected int getNextAvailableId() {
        int nextId = Film.nextAvailableId;
        Film.nextAvailableId += 1;
        return nextId;
    }

    /**
     * Retourne l'identifiant unique du film.
     *
     * @return L'identifiant du film.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retourne le titre du film.
     *
     * @return Le titre du film.
     */
    public String getTitre() {
        return this.titre;
    }

    /**
     * Modifie le titre du film.
     *
     * @param t Le nouveau titre du film.
     */
    public void setTitre(String t) {
        this.titre = t;
    }

    /**
     * Retourne l'année de sortie du film.
     *
     * @return L'année de sortie du film.
     */
    public int getAnnee() {
        return this.annee;
    }

    /**
     * Modifie l'année de sortie du film.
     *
     * @param a La nouvelle année de sortie du film.
     */
    public void setAnnee(int a) {
        this.annee = a;
    }

    /**
     * Retourne la description du film.
     *
     * @return La description du film.
     */
    public String getDesc() {
        return this.description;
    }

    /**
     * Modifie la description du film.
     *
     * @param d La nouvelle description du film.
     */
    public void setDesc(String d) {
        this.description = d;
    }

    /**
     * Ajoute un genre à l'ensemble des genres du film.
     *
     * @param g Le genre à ajouter.
     */
    public void addGenre(Genre g) {
        this.genres.add(g);
    }

    /**
     * Retire un genre de l'ensemble des genres du film.
     *
     * @param g Le genre à retirer.
     */
    public void removeGenre(Genre g) {
        this.genres.remove(g);
    }

    /**
     * Remplace l'ensemble des genres du film par un nouvel ensemble.
     *
     * @param g Le nouvel ensemble de genres (peut être {@code null}).
     *          Si {@code null}, un nouvel ensemble vide est créé.
     */
    public void setGenres(Set<Genre> g) {
        this.genres = g != null ? g : new HashSet<Genre>();
    }
}
