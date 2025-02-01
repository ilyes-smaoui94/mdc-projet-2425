public interface IModeleCinema {
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
   * Enregistre un nouveau client, et en cas de succès, en renvoie l'ID
   * Sinon, renvoie un nombre négatif (-1, à priori)
   */
  public int ajouterClient (nom: String, email: String, mdp: String);

  /**
   * Enregistre un nouveau manager, et en cas de succès, en renvoie l'ID
   * Sinon, renvoie un nombre négatif (-1, à priori)
   */
  public int ajouterManager (nom: String, email: String, mdp: String);

  /**
   * Enregistre un nouveau film, et en cas de succès, en renvoie l'ID
   * Sinon, renvoie un nombre négatif (-1, à priori)
   */
  public int ajouterFilm (titre: String, a: int, desc: String);

  /**
   * Enregistre un nouveau film, et en cas de succès, en renvoie l'ID
   * Sinon, renvoie un nombre négatif (-1, à priori)
   */
  public int ajouterFilm (titre: String, a: int, desc: String, genres: ArrayList<String>);

  /**
   * Supprime le film dont l'ID est donné en paramètre
   * Renvoie true par défaut, false en cas d'erreur/problème
   */
  public boolean supprimerFilm (int id);

  /**
   * Enregistre une nouvelle salle, et en cas de succès, en renvoie l'ID
   * Sinon, renvoie un nombre négatif (-1, à priori)
   */
  public int ajouterSalle (int numeroSalle, int idFilm);

  /**
   * Supprime la salle dont l'ID est donné en paramètre
   * Renvoie true par défaut, false en cas d'erreur/problème
   */
  public boolean supprimerSalle (int numero);

  /**
   * Enregistre une nouvelle séance, et en cas de succès, en renvoie l'ID
   * Sinon, renvoie un nombre négatif (-1, à priori)
   */
  public int ajouterSeance (int idSalle, int idFilm, Date horaireSeance);
	
  /**
   * Supprime le film dont l'ID est donné en paramètre
   * Renvoie true par défaut, false en cas d'erreur/problème
   */
  public boolean supprimerSeance (int id);

  /**
   * Enregistre une nouvelle salle, et en cas de succès, en renvoie l'ID
   * Sinon, renvoie un nombre négatif (-1, à priori)
   */
  public int creerReservation (ArrayList<Seance>);

  /**
   * Supprime le film dont l'ID est donné en paramètre
   * Renvoie true par défaut, false en cas d'erreur/problème
   */
  public boolean supprimerReservation (int id);

	/**
	 * Essaye de se connecter à l'utilisateur identifiés par les paramètres donnés
	 * En cas de succès, cet utilisateur devient l'utilisateur connecté du modèle implémentant cette interface
	 * Renvoie un ArrayList<boolean> de deux éléments : le premier indique si la connexion a été effectuée avec succès,
	 * le deuxième, en cas de connexion réussie, indique si l'utilisateur en question est un Manager ou pas
	 */
  public ArrayList<boolean> connecterUtilisateur (String email, String mdp);

	/**
	 * Déconnecte l'utilisateur actuellement connecté (il ne peut y en avoir qu'un à la fois, donc pas besoin de paramètre)
	 * Renvoie true en cas de succès, false en cas d'échec
	 */
  public boolean deconnecterUtilisateur ();
}