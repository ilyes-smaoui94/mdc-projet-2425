public interface IModeleCinema {
	public Utilisateur getUtilisateur (int id);
	public Film getFilm (int id);
	public Reservation getReservation (id: int);
	public Salle getSalle (numero: int);
	public Seance getSeance (id: int);
	public Set<Utilisateur> getListeUtilisateur ();
	public Set<Film> getListeFilms ();
	public Set<Salle> getListeSalles ();
	public Set<Seance> getListeSeancesFilm (f: Film);
	public Set<Seance> getListeSeances ();
	public int ajouterClient (nom: String, email: String, mdp: String);
	public int ajouterManager (nom: String, email: String, mdp: String);
	public int ajouterFilm (titre: String, a: int, desc: String);
	public int ajouterFilm (titre: String, a: int, desc: String, genres: ArrayList<String>);
	public boolean supprimerFilm (id: int);
	public boolean ajouterSalle (num: int, capacite: int);
	public boolean supprimerSalle (numero: int);
	public boolean ajouterSeance (s: Seance);
	public boolean supprimerSeance (id: int);
	public boolean creerReservation (ArrayList<Seance>);
	public boolean supprimerReservation (id: int);
	public ArrayList<boolean> connecterUtilisateur (String email, String mdp);
	public boolean deconnecterUtilisateur (String email);
}