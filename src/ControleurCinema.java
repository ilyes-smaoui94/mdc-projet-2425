import java.util.Set;
import java.util.HashSet;

class ControleurCinema implements ObservateurSeance {

	private IVueCinema vueCinema;
	private IModeleCinema modeleCinema;
	private Set<Utilisateur> utilisateursEnregistres;

	public CinemaController () {
		this.utilisateursEnregistres = new HashSet<Utilisateur>();
	}

	public CinemaController () {
		this.utilisateursEnregistres = new HashSet<Utilisateur>();
	}

	public void getVue () {
		return this.vueCinema,
	}

	public void setVue (IVueCinema vueCinema) {
		this.vueCinema = vueCinema;
	}

	public void getModele () {
		return this.modeleCinema;
	}

	public void setModele (IModeleCinema modeleCinema) {
		this.modeleCinema = modeleCinema;
	}

	public void ajouterClient (String nom, String email, String mdp) {
		Client nouveauClient = new Client(nom, email, mdp);
		// [TBC] vérifier qu'il n'y a pas déjà d'autre utilisateur avec cet email
		this.utilisateursEnregistres.add(nouvelUtilisateur);
		if (this.vueCinema != null) {
			this.vueCinema.afficherConfCreationClient(nouveauClient);
		}
	}

	public void connect (String email, String mdp) {
		boolean connexionReussie = false;
		for (Utilisateur u : this.utilisateursEnregistres) {
			if (u.getEmail() == email && u.getMotDePasse() == mdp) {
				connexionReussie = true;
				break;
			}
		}
		if (connexionReussie) {
			// Connexion réussie : afficher que l'utilsateur s'est bien connecté
			// this.vueCinema.afficherConnexionReussie(); // à compléter dans la partie Vue d'abord
		}
		else {
			// Connexion échouée : afficher que l'utilsateur n'a pas réussi à se connecter
			// this.vueCinema.afficherConnexionEchouee(); // à compléter dans la partie Vue d'abord
		}
	}

	// !! À COMPLÉTER !!
	
	// !! À COMPLÉTER !!

	public Film creerFilm(Utilisateur utilisateur, String titre, int duree) {
		if (utilisateur instanceof Manager) {
			Manager manager = (Manager) utilisateur;
			return manager.creerFilm(titre, duree);
		} else {
			System.out.println("Action refusée : l'utilisateur n'est pas un Manager.");
			return null;
		}
	}

	public Seance programmerSeance(Utilisateur utilisateur, Film film, Salle salle, Date dateHeure) {
		if (utilisateur instanceof Manager) {
			Manager manager = (Manager) utilisateur;
			return manager.programmerSeance(film, salle, dateHeure);
		} else {
			System.out.println("Action refusée : l'utilisateur n'est pas un Manager.");
			return null;
		}
	}

	public Reservation reserverSeance(Utilisateur utilisateur, Seance seance) {
		if (utilisateur instanceof Client) {
			Client client = (Client) utilisateur;
			return client.reserverSeance(seance);
		} else {
			System.out.println("Action refusée : l'utilisateur n'est pas un Client.");
			return null;
		}
	}

	public void payerReservation(Utilisateur utilisateur, Reservation reservation) {
		if (utilisateur instanceof Client) {
			Client client = (Client) utilisateur;
			client.payerReservation(reservation);
		} else {
			System.out.println("Action refusée : l'utilisateur n'est pas un Client.");
		}
	}
}
