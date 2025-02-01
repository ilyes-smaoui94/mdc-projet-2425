public interface IModeleCinema {
<<<<<<< HEAD

  /**
  * Renvoie l'utilisateur enregistré dont l'ID est donné en paramètre, s'il existe
  * Renvoie null sinon
  */
  public Utilisateur getUtilisateur (int id) {
    for (Utilisateur u : this.utilisateursEnregistres);

  /**
  * Renvoie le film enregistré dont l'ID est donné en paramètre, s'il existe
  * Renvoie null sinon
  */
  public Film getFilm (int id);

  /**
  * Renvoie la réservation enregistrée dont l'ID est donné en paramètre, si elle existe
  * Renvoie null sinon
  */
  public Reservation getReservation (int id);
  }

  /**
  * Renvoie la salle enregistrée dont le numéro est donné en paramètre, si elle existe
  * Renvoie null sinon
  */
  public Salle getSalle (int numero);

  /**
  * Renvoie la séance enregistrée dont l'ID est donné en paramètre, si elle existe
  * Renvoie null sinon
  */
  public Seance getSeance (int numero);

  /**
   * Renvoie la liste des utilisateurs enregistrés dans le modèle
   */
  public Set<Utilisateur> getListeUtilisateur ();

  /**
   * Renvoie la liste des films enregistrés dans le modèle
   */
  public Set<Film> getListeFilms ();

  /**
   * Renvoie la liste des salles enregistrées dans le modèle
   */
  public Set<Salle> getListeSalles ();

  /**
   * Renvoie la liste des séances enregitrées dans le modèle
   */
  public Set<Seance> getListeSeances ();
  
  /**
   * Renvoie la liste des séances d'un film
   */
  public Set<Seance> getListeSeancesFilm (f: Film);

  /**
   * Enregistre un nouveau client, et s'il y a succès, en renvoie l'ID
   * Sinon, renvoie un nombre négatif (-1, à priori)
   */
  public int ajouterClient (nom: String, email: String, mdp: String);

  /**
   * Enregistre un nouveau manager, et s'il y a succès, en renvoie l'ID
   * Sinon, renvoie un nombre négatif (-1, à priori)
   */
  public int ajouterManager (nom: String, email: String, mdp: String);

  /**
   * Enregistre un nouveau film, et s'il y a succès, en renvoie l'ID
   * Sinon, renvoie un nombre négatif (-1, à priori)
   */
  public int ajouterFilm (titre: String, a: int, desc: String);

  /**
   * Enregistre un nouveau film, et s'il y a succès, en renvoie l'ID
   * Sinon, renvoie un nombre négatif (-1, à priori)
   */
  public int ajouterFilm (titre: String, a: int, desc: String, genres: ArrayList<String>);

  public boolean supprimerFilm (int id);
  public boolean ajouterSalle (int numeroSalle, int idFilm);
  public boolean supprimerSalle (int numero);
  public boolean ajouterSeance (int idSalle, int idFilm, Date horaireSeance);
  public boolean supprimerSeance (int id);
  public boolean creerReservation (ArrayList<Seance>);
  public boolean supprimerReservation (int id);

  public ArrayList<boolean> connecterUtilisateur (String email, String mdp);
  public boolean deconnecterUtilisateur (String email);
=======
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
>>>>>>> ram
}