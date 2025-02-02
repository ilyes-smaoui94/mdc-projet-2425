import java.util.Set;
import java.util.HashSet;

public class ModeleCinema implements IModeleCinema {
	private Utilisateur utilisateurConnecte;
	private Set<Utilisateur> utilisateursEnregistres;
	private Set<String> emailsUtilisateursEnregistres;
	private Set<Film> filmsEnregistres;
	private Set<Salle> sallesEnregistrees;
	private Set<Seance> seancesEnregistrees;
	private Set<Billet> billetsEnregistres;
	private Set<Reservation> reservationsEnregistrees;

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
	public Set<Utilisateur> getListeUtilisateur () {
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
	public Set<Seance> getListeSeancesFilm (Film f) {
		Set<Seance> resSeances = new HashSet<Seance>();
		for (Seance s : this.seancesEnregistrees) {
			if (s.getFilm() == f) {
				resSeances.add(s);
			}
		}
		return resSeances;
	}
	
	@Override
	public Set<Seance> getListeSeances () {
		return this.seancesEnregistrees;
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
			Manager leManager = Manager.getManagerInstance(email, mdp);
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
	public int ajouterFilm (String titre, int a, String desc) {
		try {
			Film nvFilm = new Film(titre, a, desc);
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
	public int ajouterFilm (titre: String, a: int, desc: String, genres: ArrayList<String>) {
		try {
			Set<Genre> genresSet = new HashSet<Genre>();
			for (String g_str: genres) {
				for (Genre g: Genre.values()) {
					if (g.name().equalsIgnoreCase(g_str)) {
						genresSet.add(g);
					}
				}
			}
			Film nvFilm = new Film(titre, a, desc, genresSet);
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
	public int ajouterSalle (num: int, capacite: int) {
		try {
			Salle s = new Salle(num, capacite);
			if (s == null) {
				return ID_VALUE_ON_ERROR;
			}
			else {
				this.sallesEnregistrees.add(s);
				return s.getId();
			}
		}
		catch (Exception e) {
			return ID_VALUE_ON_ERROR;
		}
	}

	@Override
	public boolean supprimerSalle (numero: int) {
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
			if (s == null) {
				return ID_VALUE_ON_ERROR;
			}
			else {
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
				this.seancesEnregistrees.remove(seanceAEnlever);
				return true;
			}
		}
		catch (Exception e) {
			return false;
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
			if (reservationAEnlever == null) {
				return false;
			}
			else {
				for (Billet b: reservationAEnlever.getBillets()) {
					this.billetsEnregistres.remove(b);
				}
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
				if (u.getMail().equals(email) && u.verifierMotDePasse(mdp)) {
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