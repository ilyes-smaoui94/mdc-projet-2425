class ControleurCinema implements ObservateurSeance {
	private Utilisateur utilisateur;

	public CinemaController(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void seConnecter() {
		utilisateur.seConnecter();
	}

	public void seDeconnecter() {
		utilisateur.seDeconnecter();
	}

	public Film creerFilm(String titre, int duree) {
		if (utilisateur instanceof Manager) {
			Manager manager = (Manager) utilisateur;
			return manager.creerFilm(titre, duree);
		} else {
			System.out.println("Action refusée : l'utilisateur n'est pas un Manager.");
			return null;
		}
	}

	public Seance programmerSeance(Film film, Salle salle, Date dateHeure) {
		if (utilisateur instanceof Manager) {
			Manager manager = (Manager) utilisateur;
			return manager.programmerSeance(film, salle, dateHeure);
		} else {
			System.out.println("Action refusée : l'utilisateur n'est pas un Manager.");
			return null;
		}
	}

	public Reservation reserverSeance(Seance seance) {
		if (utilisateur instanceof Client) {
			Client client = (Client) utilisateur;
			return client.reserverSeance(seance);
		} else {
			System.out.println("Action refusée : l'utilisateur n'est pas un Client.");
			return null;
		}
	}

	public void payerReservation(Reservation reservation) {
		if (utilisateur instanceof Client) {
			Client client = (Client) utilisateur;
			client.payerReservation(reservation);
		} else {
			System.out.println("Action refusée : l'utilisateur n'est pas un Client.");
		}
	}
}
