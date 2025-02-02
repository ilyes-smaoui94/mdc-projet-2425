import java.util.Set;
import java.util.HashSet;

/**
 * Représente un film avec un titre, une année de sortie, une description, une durée 
 * (au minimum 30 minutes) et un ensemble de genres. Chaque film est identifié par 
 * un identifiant unique incrémenté automatiquement.
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * // Création d'un film avec des valeurs simples
 * Film film1 = new Film("Inception", 2010, "Film de science-fiction", 148);
 * 
 * // Ajout de genres
 * film1.addGenre(Genre.ACTION);
 * film1.addGenre(Genre.THRILLER);
 * 
 * // Affichage d'informations
 * System.out.println("ID du film : " + film1.getId());
 * System.out.println("Titre : " + film1.getTitre());
 * System.out.println("Année : " + film1.getAnnee());
 * System.out.println("Description : " + film1.getDesc());
 * System.out.println("Durée : " + film1.getDuree() + " minutes");
 * }</pre>
 *  
 * 
 * <p>
 * La durée minimale d'un film est fixée à 30 minutes. Toute tentative de définir 
 * une durée inférieure à cette valeur sera ramenée automatiquement à 30.
 *  
 * 
 * <p>
 * Les genres du film peuvent être définis dès la construction via le second 
 * constructeur, ou bien à l'aide des méthodes 
 * {@link #addGenre(Genre)} et {@link #removeGenre(Genre)}.
 *  
 */
public class Film {

    /**
     * Durée minimale fixée pour un film, en minutes (30).
     * Si une durée inférieure est spécifiée, elle sera ramenée à cette valeur.
     */
    private int dureeMin = 30;

    /**
     * Prochain identifiant unique disponible pour instancier un nouveau film.
     * Incrémenté automatiquement à chaque nouvelle instance.
     */
    private static int nextAvailableId = 1;

    /**
     * Identifiant unique de ce film.
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
     * Durée en minutes du film. Ne peut pas être inférieure à 30.
     */
    private int duree;

    /**
     * Ensemble de genres associés à ce film (ex. {@link Genre#ACTION}, {@link Genre#DRAME}, etc.).
     */
    private Set<Genre> genres;

    /**
     * Construit un nouveau film avec titre, année, description et durée spécifiés.
     * 
     * <p>Si la durée passée en paramètre est inférieure à 30, elle est ajustée à 30. 
     *
     * @param t     Le titre du film.
     * @param a     L'année de sortie du film.
     * @param d     La description du film.
     * @param duree La durée du film en minutes (au minimum 30).
     */
    public Film(String t, int a, String d, int duree) {
        this.id = this.getNextAvailableId();
        this.titre = t;
        this.annee = a;
        this.description = d;
        this.duree = (duree >= dureeMin) ? duree : dureeMin;
        this.genres = new HashSet<>();
    }

    /**
     * Construit un nouveau film avec titre, année, description, durée et ensemble de genres.
     * 
     * <p>Si la durée passée en paramètre est inférieure à 30, elle est ajustée à 30. 
     *
     * @param t     Le titre du film.
     * @param a     L'année de sortie du film.
     * @param d     La description du film.
     * @param duree La durée du film en minutes (au minimum 30).
     * @param g     Ensemble de genres associé au film (peut être {@code null}). 
     *              S'il est {@code null}, l'ensemble sera initialisé vide.
     */
    public Film(String t, int a, String d, int duree, Set<Genre> g) {
        this.id = this.getNextAvailableId();
        this.titre = t;
        this.annee = a;
        this.description = d;
        this.duree = (duree >= dureeMin) ? duree : dureeMin;
        this.genres = (g != null) ? g : new HashSet<>();
    }

    /**
     * Retourne et incrémente le prochain identifiant unique disponible pour un film.
     *
     * @return Le prochain identifiant unique de film.
     */
    protected int getNextAvailableId() {
        int nextId = Film.nextAvailableId;
        Film.nextAvailableId += 1;
        return nextId;
    }

    /**
     * Retourne l'identifiant unique de ce film.
     *
     * @return L'identifiant du film.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retourne le titre de ce film.
     *
     * @return Le titre du film.
     */
    public String getTitre() {
        return this.titre;
    }

    /**
     * Modifie le titre de ce film.
     *
     * @param t Le nouveau titre du film.
     */
    public void setTitre(String t) {
        this.titre = t;
    }

    /**
     * Retourne l'année de sortie de ce film.
     *
     * @return L'année de sortie du film.
     */
    public int getAnnee() {
        return this.annee;
    }

    /**
     * Modifie l'année de sortie de ce film.
     *
     * @param a La nouvelle année de sortie du film.
     */
    public void setAnnee(int a) {
        this.annee = a;
    }

    /**
     * Retourne la description de ce film.
     *
     * @return La description du film.
     */
    public String getDesc() {
        return this.description;
    }

    /**
     * Modifie la description de ce film.
     *
     * @param d La nouvelle description du film.
     */
    public void setDesc(String d) {
        this.description = d;
    }

    /**
     * Retourne la durée de ce film, en minutes. 
     * Toujours supérieure ou égale à 30 minutes.
     *
     * @return La durée du film (en minutes).
     */
    public int getDuree() {
        return this.duree;
    }

    /**
     * Modifie la durée de ce film, en minutes.
     * Si la valeur est inférieure à 30, elle sera ramenée automatiquement à 30.
     *
     * @param duree La durée (en minutes).
     */
    public void setDuree(int duree) {
        this.duree = (duree >= dureeMin) ? duree : dureeMin;
    }

    /**
     * Ajoute un genre à l'ensemble des genres de ce film.
     *
     * @param g Le genre à ajouter.
     */
    public void addGenre(Genre g) {
        this.genres.add(g);
    }

    /**
     * Retire un genre de l'ensemble des genres de ce film, s'il est présent.
     *
     * @param g Le genre à retirer.
     */
    public void removeGenre(Genre g) {
        this.genres.remove(g);
    }

    /**
     * Remplace l'ensemble des genres par un nouvel ensemble.
     * Si {@code g} est {@code null}, initialise un ensemble vide.
     *
     * @param g Le nouvel ensemble de genres.
     */
    public void setGenres(Set<Genre> g) {
        this.genres = (g != null) ? g : new HashSet<>();
    }
}
