import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe implémentant l'interface pour un Modèle
 * Elle stocke une liste des objets qu'elle gère et qu'elle a enregistrés
 * Elle implémente aussi plusieurs méthodes permettant d'ajouter ou supprimer ces objets,
 * d'en récupérer une liste, ou d'en récupérer un en particulier, à l'aide de son ID.
 */
public class ModeleCinema implements IModeleCinema {
	private Utilisateur utilisateurConnecte;
	private Set<Utilisateur> utilisateursEnregistres;
	private Set<String> emailsUtilisateursEnregistres;
	private Set<Film> filmsEnregistres;
	private Set<Salle> sallesEnregistrees;
	private Set<Seance> seancesEnregistrees;
	private Set<Billet> billetsEnregistres;
	private Set<Reservation> reservationsEnregistrees;

  /**
   * Valeur à renvoyer pour les fonctions qui créent un objet et sont censées en renvoyer l'ID,
   * Lorsque l'objet n'a pas pu être créé, ou plus généralement qu'il y a eu une erreur
   */
	public static final int ID_VALUE_ON_ERROR = -1;
	
	public ModeleCinema () {
		this.utilisateursEnregistres = new HashSet<Utilisateur>();
		this.emailsUtilisateursEnregistres = new HashSet<String>();
		this.filmsEnregistres = new HashSet<Film>();
		this.sallesEnregistrees = new HashSet<Salle>();
		this.seancesEnregistrees = new HashSet<Seance>();
		this.billetsEnregistres = new HashSet<Billet>();
		this.reservationsEnregistrees = new HashSet<Reservation>();
	}
	
	@Override
	public Utilisateur getUtilisateur (int id) {
		for (Utilisateur u : this.utilisateursEnregistres) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	@Override
	public Film getFilm (int id) {
		for (Film f : this.filmsEnregistres) {
			if (f.getId() == id) {
				return f;
			}
		}
		return null;
	}

	@Override
	public Reservation getReservation (int id) {
		for (Reservation r : this.reservationsEnregistrees) {
			if (r.getId() == id) {
				return r;
			}
		}
		return null;
	}

	@Override
	public Billet getBillet (int id) {
		for (Billet b : this.billetsEnregistres) {
			if (b.getId() == id) {
				return b;
			}
		}
		return null;
	}

	@Override
	public Salle getSalle (int id) {
		for (Salle s : this.sallesEnregistrees) {
			if (s.getId() == id) {
				return s;
			}
		}
		return null;
	}

	@Override
	public Seance getSeance (int id) {
		for (Seance s : this.seancesEnregistrees) {
			if (s.getId() == id) {
				return s;
			}
		}
		return null;
	}
	
	@Override
	public Set<Utilisateur> getListeUtilisateurs () {
		return this.utilisateursEnregistres;
	}

	@Override
	public Set<Film> getListeFilms () {
		return this.filmsEnregistres;
	}

	@Override
	public Set<Salle> getListeSalles () {
		return this.sallesEnregistrees;
	}
	
	@Override
	public Set<Seance> getListeSeances () {
		return this.seancesEnregistrees;
	}

	@Override
	public Set<Seance> getListeSeancesFilm (Film f) {
		Set<Seance> resSeances = new HashSet<Seance>();
		for (Seance s : this.seancesEnregistrees) {
			if (s.getFilm().getId() == f.getId()) {
				resSeances.add(s);
			}
		}
		return resSeances;
	}

	@Override
	public Set<Reservation> getListeReservations () {
		return this.reservationsEnregistrees;
	}

	@Override
	public Set<Billet> getListeBillets () {
		return this.billetsEnregistres;
	}

	// 
	@Override
	public int ajouterClient (String nom, String email, String mdp) {
		try {
			Client nvClient = new Client(nom, email, mdp);
			if (nvClient == null) {
				return ID_VALUE_ON_ERROR;
			}
			this.utilisateursEnregistres.add(nvClient);
			return nvClient.getId();
		}
		catch (Exception e) {
			return ID_VALUE_ON_ERROR;
		}
	}

	@Override
	public int ajouterManager (String nom, String email, String mdp) {
		try {
			Manager leManager = Manager.getManagerInstance(nom, email, mdp);
			if (leManager == null) {
				return ID_VALUE_ON_ERROR;
			}
			else {
				this.utilisateursEnregistres.add(leManager);
				return leManager.getId();
			}
		}
		catch (Exception e) {
			return ID_VALUE_ON_ERROR;
		}
	}

	@Override
	public boolean supprimerUtilisateur (int id) {
		try {
			Utilisateur utilisateurAEnlever = null;
			for (Utilisateur u: this.utilisateursEnregistres) {
				if (u.getId() == id) {
					utilisateurAEnlever = u;
					break;
				}
			}
			// si l'utilisateur n'a pas été trouve
			if (utilisateurAEnlever == null) {
				return false;
			}
			else {
				this.utilisateursEnregistres.remove(utilisateurAEnlever);
				return true;
			}
		}
		catch (Exception e) {
			return false;
		}
	}

	@Override
	public int ajouterFilm (String titre, int a, String desc, int duree) {
		try {
			Film nvFilm = new Film(titre, a, desc, duree);
			if (nvFilm == null) {
				return ID_VALUE_ON_ERROR;
			}
			this.filmsEnregistres.add(nvFilm);
			return nvFilm.getId();
		}
		catch (Exception e) {
			return ID_VALUE_ON_ERROR;
		}
	}

	@Override
	public int ajouterFilm (String titre, int a, String desc, int duree, ArrayList<String> genres_str) {
		try {
			Set<Genre> genresSet = new HashSet<Genre>();
			for (String g_str: genres_str) {
				for (Genre g: Genre.values()) {
					if (g.name().equalsIgnoreCase(g_str)) {
						genresSet.add(g);
					}
				}
			}
			Film nvFilm = new Film(titre, a, desc, duree, genresSet);
			if (nvFilm == null) {
				return ID_VALUE_ON_ERROR;
			}
			else {
				this.filmsEnregistres.add(nvFilm);
				return nvFilm.getId();
			}
		}
		catch (Exception e) {
			return ID_VALUE_ON_ERROR;
		}
	}

	@Override
	public boolean supprimerFilm (int id) {
		try {
			Film filmAEnlever = null;
			for (Film f: this.filmsEnregistres) {
				if (f.getId() == id) {
					filmAEnlever = f;
					break;
				}
			}
			// si le film n'a pas été trouvé
			if (filmAEnlever == null) {
				return false;
			}
			else {
				this.filmsEnregistres.remove(filmAEnlever);
				return true;
			}
		}
		catch (Exception e) {
			return false;
		}
	}

	@Override
	public int ajouterSalle (int numero, int capacite) {
		try {
			Salle s = new Salle(numero, capacite);
			if (s == null) {
				return ID_VALUE_ON_ERROR;
			}
			else {
				for (Salle s2 : this.sallesEnregistrees) {
					if (s2.getNumero() == numero) {
						return ID_VALUE_ON_ERROR;
					}
				}
				this.sallesEnregistrees.add(s);
				return s.getId();
			}
		}
		catch (Exception e) {
			return ID_VALUE_ON_ERROR;
		}
	}

	@Override
	public boolean supprimerSalle (int id) {
		try {
			Salle salleAEnlever = null;
			for (Salle s: this.sallesEnregistrees) {
				if (s.getId() == id) {
					salleAEnlever = s;
					break;
				}
			}
			if (salleAEnlever == null) {
				return false;
			}
			else {
				this.sallesEnregistrees.remove(salleAEnlever);
				return true;
			}
		}
		catch (Exception e) {
			return false;
		}
	}

	@Override
	public int ajouterSeance (int idSalle, int idFilm, Date heureDebut) {
		try {
			Seance s = new Seance(this.getSalle(idSalle), this.getFilm(idFilm), heureDebut);
			if (s == null || this.getFilm(idFilm) == null || this.getSalle(idSalle) == null) {
				return ID_VALUE_ON_ERROR;
			}
			else {
				// À faire : vérifier qu'il n'y a pas chevauchement entre cette séance et une autre
				this.seancesEnregistrees.add(s);
				return s.getId();
			}
		}
		catch (Exception e) {
			return ID_VALUE_ON_ERROR;
		}
	}

	@Override
	public boolean supprimerSeance (int id) {
		try {
			Seance seanceAEnlever = null;
			for (Seance s: this.seancesEnregistrees) {
				if (s.getId() == id) {
					seanceAEnlever = s;
					break;
				}
			}
			if (seanceAEnlever == null) {
				return false;
			}
			else {
        // for (Billet b: this.billetsEnregistres) {
        //   if 
        // }
				this.seancesEnregistrees.remove(seanceAEnlever);
				return true;
			}
		}
		catch (Exception e) {
			return false;
		}
	}

	@Override
	public int creerReservation (int idUtilisateur, Set<Billet> billetsAPrendre) {
		try {
			Utilisateur uResa = this.getUtilisateur(idUtilisateur);
			if (uResa == null) {
				return ID_VALUE_ON_ERROR;
			}
			for (Billet b : billetsAPrendre) {
				if (b != null) {
					this.billetsEnregistres.add(b);
				}
			}
			Reservation nvlReservation = new Reservation(uResa, billetsAPrendre);
			this.reservationsEnregistrees.add(nvlReservation);
			return nvlReservation.getId();
		}
		catch (Exception e) {
			return ID_VALUE_ON_ERROR;
		}
	}

	@Override
	public boolean supprimerReservation(int id) {
		try {
			Reservation reservationAEnlever = null;
			for (Reservation r: this.reservationsEnregistrees) {
				if (r.getId() == id) {
					reservationAEnlever = r;
					break;
				}
			}
			// Si on a pas trouvé la réservation
			if (reservationAEnlever == null) {
				return false;
			}
			else {
				for (Billet b: reservationAEnlever.getBillets()) {
					this.billetsEnregistres.remove(b);
				}
				// réservation trouvée, billets enlevés, réservation enlevée : tout est bon, on renvoie true
				this.reservationsEnregistrees.remove(reservationAEnlever);
				return true;
			}
		}
		catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<Boolean> connecterUtilisateur(String email, String mdp) {
		ArrayList<Boolean> resConnexion = new ArrayList<Boolean>(Arrays.asList(false, false));
		try {
			for (Utilisateur u : utilisateursEnregistres) {
				if (u.getEmail().equals(email) && u.getMotDePasse().equals(mdp)) {
					utilisateurConnecte = u;
					resConnexion.set(0, true);
					if (u instanceof Manager) {
						resConnexion.set(1, true);
					}
					else {
						resConnexion.set(1, false);
					}
					return resConnexion;
				}
			}
			resConnexion.set(0, false);
			return resConnexion;
		}
		catch (Exception e) {
			resConnexion.set(0, false);
			return resConnexion;
		}
	}

	@Override
	public boolean deconnecterUtilisateur() {
		try {
			if (this.utilisateurConnecte != null) {
				this.utilisateurConnecte = null;
				return true;
			}
			return false;
		}
		catch (Exception e) {
			return false;
		}
	}
}