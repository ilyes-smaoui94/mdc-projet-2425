import java.util.Set;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
/**
 * Interface définissant les méthodes à implémenter pour tout classe gérant un Modèle pour notre application
 */
public interface IModeleCinema {

	/**
	 * Renvoie l'utilisateur enregistré dont l'ID est donné en paramètre, si possible
	 * Renvoie null sinon
	 * 
	 * @param id ID de l'utilisateur à récupérer.
	 * @return L'utilisateur correspondant s'il existe, {@code null} sinon
	 */
	public Utilisateur getUtilisateur (int id);

	/**
	 * Renvoie le film enregistré dont l'ID est donné en paramètre, si possible
	 * Renvoie null sinon
	 * 
	 * @param id ID du film à récupérer
	 * @return Le film correspondant s'il existe, {@code null} sinon
	 */
	public Film getFilm (int id);

	/**
	 * Renvoie la réservation enregistrée dont l'ID est donné en paramètre, si possible
	 * 
	 * @param id ID du film à récupérer
	 * @return La réservation correspondante si possible, {@code null} sinon
	 */
	public Reservation getReservation (int id);

	/**
	 * Renvoie le billet enregistré dont l'ID est donné en paramètre, si possible
	 * 
	 * @param id ID du film à récupérer
	 * @return Le billet correspondant si possible, {@code null} sinon
	 */
	public Billet getBillet (int id);

	/**
	 * Renvoie la salle enregistrée dont l'ID est donné en paramètre, si possible
	 * Renvoie null sinon
	 * 
	 * @param id ID de la salle à récupérer
	 * @return La salle correspondante si possible
	 */
	public Salle getSalle (int id);

	/**
	 * Renvoie la séance enregistrée dont l'ID est donné en paramètre, si possible
	 * Renvoie null sinon
	 * 
	 * @param id ID de la séance à récupérer
	 * @return La séance correspondante, si possible
	 */
	public Seance getSeance (int id);

	// /** Renvoie la réservation enregistrée dont l'ID est donné en paramètre, si possible
	//  * 
	//  * @param id ID de la réservation à récupérer
	//  * @return ID de la réservation correspondante, si possible
	//  */
	// public Reservation getReservation (int id);

	/**
	 * Renvoie la liste des utilisateurs enregistrés dans le modèle
	 * 
	 * @return La liste des utilisateurs enregistrés dans le modèle
	 */
	public Set<Utilisateur> getListeUtilisateurs ();

	/**
	 * Renvoie la liste des films enregistrés dans le modèle
	 * 
	 * @return la liste des films enregistrés dans le modèle
	 */
	public Set<Film> getListeFilms ();

	/**
	 * Renvoie la liste des salles enregistrées dans le modèle
	 * 
	 * @return la liste des salles enregistrées dans le modèle
	 */
	public Set<Salle> getListeSalles ();

	/**
	 * Renvoie la liste des séances enregitrées dans le modèle
	 * 
	 * @return la liste des séances enregitrées dans le modèle
	 */
	public Set<Seance> getListeSeances ();
	
	/**
	 * Renvoie la liste des séances d'un film
	 * 
	 * @param f Film dont on veut récupérer les séances
	 * @return la liste des séances d'un film
	 */
	public Set<Seance> getListeSeancesFilm (Film f);

	/**
	 * Renvoie la liste des réservations enregistrées par le modèle
	 * 
	 * @return la liste des réservations enregistrées par le modèle
	 */
	public Set<Reservation> getListeReservations ();

	/**
	 * Renvoie la liste des billets enregistrés par le modèle
	 * 
	 * @return la liste des billets enregistrés par le modèle
	 */
	public Set<Billet> getListeBillets ();

	/**
	 * Enregistre un nouveau client
	 * Sinon, renvoie un nombre négatif (-1, à priori)
	 * 
	 * @param nom nom du client à enregistrer
	 * @param email email du client à enregistrer
	 * @param mdp mot de passe du client à enregistrer
	 * @return l'ID du client créé, si possible, -1 sinon
	 */
	public int ajouterClient (String nom, String email, String mdp);

	/**
	 * Enregistre un nouveau manager
	 * Sinon, renvoie un nombre négatif (-1, à priori)
	 * 
	 * @param nom nom du manager à enregistrer
	 * @param email email du manager à enregistrer
	 * @param mdp mot de passe du manager à enregistrer
	 * @return l'ID du manager créé, si possible, -1 sinon
	 */
	public int ajouterManager (String nom, String email, String mdp);

	/** Supprime l'utilisateur dont l'ID est donné en paramètre
	 * 
	 * @param id ID de l'utilisateur à supprimer
	 * @return {@code true} en cas de succès, {@code false} sinon
	 */
	public boolean supprimerUtilisateur (int id);

	/**
	 * Enregistre un nouveau film
	 * Sinon, renvoie un nombre négatif (-1, à priori)
	 * 
	 * @param titre titre du film à enregistrer
	 * @param a année de sortie du film à enregistrer
	 * @param desc description du film à enregistrer
	 * @param duree durée (en minutes) du film à enregistrer
	 * @return l'ID du manager créé, si possible, -1 sinon
	 */
	public int ajouterFilm (String titre, int a, String desc, int duree);

	/**
	 * Enregistre un nouveau film
	 * Sinon, renvoie un nombre négatif (-1, à priori)
	 * 
	 * @param titre titre du film à enregistrer
	 * @param a année de sortie du film à enregistrer
	 * @param desc description du film à enregistrer
	 * @param duree durée (en minutes) du film à enregistrer
	 * @param genres_str genres du film à enregistrer
	 * @return ID du film créé, si possible
	 */
	public int ajouterFilm (String titre, int a, String desc, int duree, ArrayList<String> genres_str);

	/**
	 * Supprime le film dont l'ID est donné en paramètre
	 * 
	 * @param id ID du film à supprimer
	 * @return {@code true} en cas d'opération réussie, {@code false} sinon
	 */
	public boolean supprimerFilm (int id);

	/**
	 * Enregistre une nouvelle salle
	 * 
	 * @param numeroSalle numéro de la salle à enregistrer
	 * @param capacite capacité de la salle à enregistrer
	 * @return ID de la salle créée en cas de succès, {@code -1} sinon
	 */
	public int ajouterSalle (int numeroSalle, int capacite);

	/**
	 * Supprime la salle dont l'ID est donné en paramètre
	 * 
	 * @param id ID de la salle à supprimer
	 * @return {@code true} en cas de succès, {@code false} sinon
	 */
	public boolean supprimerSalle (int id);

	/**
	 * Enregistre une nouvelle séance
	 * 
	 * @param idSalle ID de la salle désignée pour la séance
	 * @param idFilm ID du film désigné pour la séance
	 * @param heureDebut heure de début de la Séance (l'heure de fin déterminée peut être déterminée via la durée du film)
	 * @return ID de la séance créée en cas de succès, {@code -1} sinon
	 */
	public int ajouterSeance (int idSalle, int idFilm, Date heureDebut);
	
	/**
	 * Supprime le film dont l'ID est donné en paramètre
	 * Renvoie true par défaut, false en cas d'erreur/problème
	 * 
	 * @param id ID de la séance à supprimer
	 * @return ID de la séance supprimée en cas de succès, {@code -1} sinon
	 */
	public boolean supprimerSeance (int id);

	// /**
	//  * Enregistre un nouveau billet
	//  * (on triche un peu pour le premier paramètre; pour éviter d'avoir à faire une fonction différentes pour chaque type de billet
	//  * , c'est le Contrôleur qui, exceptionnellement, insancie un Billet avant de demander au Modèle de l'enregistrer)
	//  * 
	//  * @param billetAEnregistrer IDs des séances pour lequelles faire une réservation (mettre plusieurs fois la même séance pour prendre plusieurs places)
	//  * @return ID du billet enregistré en cas de succès, {@code -1} sinon
	//  */
	// public int ajouterBillet (Billet billetAEnregistrer);

	/**
	 * Enregistre une nouvelle salle
	 * Sinon, renvoie un nombre négatif (-1, à priori)
	 * 
	 * @param idUtilisateur ID de l'utilisateur qui fait la réservation
	 * @param billetsAPrendre billets pour lequels faire une réservation (mettre plusieurs fois la même séance pour prendre plusieurs places)
	 * @return ID de la réservation créée en cas de succès, {@code -1} sinon
	 */
	public int creerReservation (int idUtilisateur, Set<Billet> billetsAPrendre);

	/**
	 * Supprime le film dont l'ID est donné en paramètre
	 * 
	 * @param id ID de la réservation à supprimer
	 * @return {@code true} en cas de succès, {@code false} sinon
	 */
	public boolean supprimerReservation (int id);

	/**
	 * Essaye de se connecter à l'utilisateur identifié par les paramètres donnés
	 * En cas de succès, cet utilisateur devient l'utilisateur connecté du modèle implémentant cette interface
	 * 
	 * @param email adresse email de l'utilisateur concerné
	 * @param mdp mot de passe de l'utilisateur concerné
	 * @return un {@code ArrayList<Boolean>} dont le premier élément vaut true en cas de succès, et le deuxième, le cas échéant, indique si l'utilisateur est un Manager
	 */
	public ArrayList<Boolean> connecterUtilisateur (String email, String mdp);

	/**
	 * Déconnecte l'utilisateur actuellement connecté (il ne peut y en avoir qu'un à la fois, donc pas besoin de paramètre)
	 * 
	 * @return {@code true} en cas de succès, {@code false} sinon
	 */
	public boolean deconnecterUtilisateur ();
}