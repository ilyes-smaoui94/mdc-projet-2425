public class ModeleCinema implements IModeleCinema {
	private Utilisateur utilisateurConnecte;
	private Set<Utilisateur> utilisateursEnregistres;
	private Set<Film> filmsEnregistres;
	private Set<Salle> sallesEnregistrees;
	private Set<Seance> seancesEnregistrees;
	
	/**
	* Renvoie l'utilisateur enregistré dont l'id est donné en paramètre, s'il existe
	* Renvoie null sinon
	*/
	public Utilisateur getUtilisateur (int id) {
		for (Utilisateur u : this.utilisateursEnregistres) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	/**
	* Renvoie le film enregistré dont l'id est donné en paramètre, s'il existe
	* Renvoie null sinon
	*/
	public Film getFilm (int id) {
		for (Film f : this.utilisateursEnregistres) {
			if (f.getId() == id) {
				return f;
			}
		}
		return null;
	}
	/**
	* Renvoie la réservation enregistrée dont l'id est donné en paramètre, si elle existe
	* Renvoie null sinon
	*/
	public Reservation getReservation (int id) {
		for (Reservation r : this.utilisateursEnregistres) {
			if (r.getId() == id) {
				return r;
			}
		}
		return null;
	}
	public Salle getSalle (int numero) {
		for (Salle s : this.utilisateursEnregistres) {
			if (s.getNumero() == numero) {
				return s;
			}
		}
		return null;
	}
	public Seance getSeance (int id) {
		;
	}
	public Set<Utilisateur> getListeUtilisateur () {
		;
	}
	public Set<Film> getListeFilms () {
		;
	}
	public Set<Salle> getListeSalles () {
		;
	}
	public Set<Seance> getListeSeancesFilm (f: Film) {
		;
	}
	public Set<Seance> getListeSeances () {
		;
	}
	public int ajouterClient (nom: String, email: String, mdp: String) {
		;
	}
	public int ajouterManager (nom: String, email: String, mdp: String) {
		;
	}
	public int ajouterFilm (titre: String, a: int, desc: String) {
		;
	}
	public int ajouterFilm (titre: String, a: int, desc: String, genres: ArrayList<String>) {
		;
	}
	public boolean supprimerFilm (id: int) {
		;
	}
		 public boolean ajouterSalle(int num, int capacite) {
				return sallesEnregistrees.add(new Salle(num, capacite));
		}

		public boolean supprimerSalle(int numero) {
				return sallesEnregistrees.removeIf(s -> s.getNumero() == numero);
		}

		public boolean ajouterSeance(Seance s) {
				return seancesEnregistrees.add(s);
		}

		public boolean supprimerSeance(int id) {
				return seancesEnregistrees.removeIf(s -> s.getIdSeance() == id);
		}

public boolean creerReservation(ArrayList<Seance> seances) {
				for (Seance s : seances) {
						if (s.getPlacesRestantes() > 0) {
								s.ajouterReservation(new Reservation(utilisateurConnecte, s));
						} else {
								return false;
						}
				}
				return true;
		}

		public boolean supprimerReservation(int id) {
				for (Seance s : seancesEnregistrees) {
						if (s.supprimerReservation(id)) {
								return true;
						}
				}
				return false;
		}

		public boolean connecterUtilisateur(String email, String mdp) {
				for (Utilisateur u : utilisateursEnregistres) {
						if (u.getMail().equals(email) && u.verifierMotDePasse(mdp)) {
								utilisateurConnecte = u;
								return true;
						}
				}
				return false;
		}

		public boolean deconnecterUtilisateur(String email) {
				if (utilisateurConnecte != null && utilisateurConnecte.getMail().equals(email)) {
						utilisateurConnecte = null;
						return true;
				}
				return false;
		}
}

}
