import java.util.Date;

/**
 * Représente une séance de projection d'un film dans une salle à une date précise, 
 * avec un nombre de places restantes. Chaque séance dispose d'un identifiant 
 * unique généré automatiquement, et peut être associée à un {@link TypeSeance}
 * particulier (par exemple, VO, VF, 3D, etc.).
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * Salle salle = new Salle(1, 100);
 * Film film = new Film("Inception", 2010, "Film de science-fiction");
 * Date dateSeance = new Date();
 *
 * Seance seance = new Seance(salle, film, dateSeance);
 * seance.setTypeSeance(TypeSeance.VO);
 *
 * System.out.println("Séance n° " + seance.getId());
 * System.out.println("Film : " + seance.getFilm().getTitre());
 * System.out.println("Salle : " + seance.getSalle().getNumero());
 * System.out.println("Places restantes : " + seance.getPlacesRestantes());
 * }</pre>
 *  
 * 
 * @author 
 */
public class Seance {

    /**
     * Prochain identifiant disponible pour une nouvelle séance.
     * Incrémenté automatiquement à chaque nouvelle instance de {@code Seance}.
     */
    private static int nextAvailableId = 1;

    /**
     * Identifiant unique de la séance.
     */
    private int id;

    /**
     * Salle où se déroule la séance.
     */
    private Salle salleSeance;

    /**
     * Film projeté lors de la séance.
     */
    private Film filmSeance;

    /**
     * Type de la séance (par exemple : VO, VF, 3D, etc.).
     */
    private TypeSeance typeSeance; 

    /**
     * Date et heure de la séance.
     */
    private Date date;

    /**
     * Nombre de places restantes pour cette séance.
     */
    private int placesRestantes;

    /**
     * Construit une nouvelle séance avec la salle, le film et la date spécifiés.
     * L'identifiant est généré automatiquement et le nombre de places restantes
     * est initialisé à la capacité de la salle donnée.
     *
     * @param salleSeance Salle où se déroule la séance.
     * @param f           Film projeté lors de la séance.
     * @param date        Date et heure de la séance.
     */
    public Seance(Salle salleSeance, Film f, Date date) {
        this.id = this.getNextAvailableId();
        this.salleSeance = salleSeance;
        this.filmSeance = f;
        this.date = date;
        this.placesRestantes = salleSeance.getCapacite();
    }

    /**
     * Retourne le prochain identifiant disponible et l'incrémente.
     *
     * @return Le prochain identifiant disponible pour une nouvelle séance.
     */
    protected static int getNextAvailableId() {
        int nextID = Seance.nextAvailableId;
        Seance.nextAvailableId += 1;
        return nextID;
    }

    /**
     * Retourne l'identifiant unique de cette séance.
     *
     * @return L'identifiant de la séance.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retourne la salle où se déroule cette séance.
     *
     * @return La salle de la séance.
     */
    public Salle getSalle() {
        return this.salleSeance;
    }

    /**
     * Modifie la salle où se déroule cette séance.
     *
     * @param salleSeance La nouvelle salle de la séance.
     */
    public void setSalle(Salle salleSeance) {
        this.salleSeance = salleSeance;
    }

    /**
     * Retourne le film projeté lors de cette séance.
     *
     * @return Le film de la séance.
     */
    public Film getFilm() {
        return this.filmSeance;
    }

    /**
     * Modifie le film projeté lors de cette séance.
     *
     * @param f Le nouveau film de la séance.
     */
    public void setFilm(Film f) {
        this.filmSeance = f;
    }

    /**
     * Retourne la date et l'heure de cette séance.
     *
     * @return La date de la séance.
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Modifie la date et l'heure de cette séance.
     *
     * @param date La nouvelle date de la séance.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Retourne le nombre de places restantes pour cette séance.
     *
     * @return Le nombre de places restantes.
     */
    public int getPlacesRestantes() {
        return this.placesRestantes;
    }

    /**
     * Modifie le nombre de places restantes pour cette séance.
     *
     * @param placesRestantes Le nouveau nombre de places restantes.
     */
    public void setPlacesRestantes(int placesRestantes) {
        this.placesRestantes = placesRestantes;
    }

    /**
     * Retourne le type de séance (VO, VF, etc.).
     *
     * @return Le type de la séance.
     */
    public TypeSeance getTypeSeance() {
        return this.typeSeance;
    }

    /**
     * Modifie le type de séance.
     *
     * @param typeSeance Le nouveau type de séance.
     */
    public void setTypeSeance(TypeSeance typeSeance) {
        this.typeSeance = typeSeance;
    }
}
