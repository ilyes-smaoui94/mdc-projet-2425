
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe jouant le rôle de Contrôleur dans l'application
 * C'est cette classe qui appelera les différents de la Vue, récupèrera les éventuelles données envoyées par l'utilisateur,
 * et fera appel au Modèle pour gérer la partie Métier
 * Elle coordine les deux autres parties de l'application (Vue et Modèle), et détermine les séquences d'actions à suivre
 */
public class ControleurCinema implements IControleurCinema {

	private IModeleCinema modele;
	private IVueClient vueClient;
	private IVueManager vueManager;

	/**
	 * Constructeur assez rudimentaire
	 * 
	 * @param modele Modèle associé au Contrôleur
	 */
	public ControleurCinema(IModeleCinema modele) {

		this.modele = modele;
	}

	/**
	 * Définit les objets de la Vue à laquelle le Contrôleur fera appel par la suite
	 * 
	 * @param vueClient vue permettant d'utiliser les fonctionnalités de Vue relatives à un client
	 * @param vueManager vue permettant d'utiliser les fonctionnalités de Vue relatives à un manager
	 */
	@Override
	public void setVues(IVueClient vueClient, IVueManager vueManager) {
		this.vueClient = vueClient;
		this.vueManager = vueManager;
	}

	/**
	 * 
	 */
	@Override
	public IVueClient getVueClient() {
		return this.vueClient;
	}

	@Override
	public IVueManager getVueManager() {
		return this.vueManager;
	}

	@Override
	public IModeleCinema getModele() {
		return this.modele;
	}

	@Override
	public void setModele(IModeleCinema modele) {
		this.modele = modele;
	}

	/**
	 * Lance le bon menu en fonction du statut de l'utilisateur connecté (Manager vs. Client)
	 */
	public void lancerMenu() {
		if (this.modele.getUtilisateurConnecte() instanceof Manager) {
			this.vueManager.afficherMenuManager();
		} else {
			this.vueClient.afficherMenuClient();
		}
	}

	/**
	 * Démarre l'application
	 */
	@Override
	public void lancerApplication() {
		// "Activer" la vue si nécessaire
		this.gererConnexion();
	}

	/**
	 *  Permet à un utilisateur de se connecter
	 */
	@Override
	public void gererConnexion() {
		// boolean connecte = false;
		// Attends une connexion réussie
		// while (!connecte) {
		// Récupère les identifiants
		ArrayList<String> connArgs = this.vueClient.afficherDialogueConnexion();
		String email = connArgs.get(0);
		String mdp = connArgs.get(1);
		// Tente une connexion auprès du modèle
		ArrayList<Boolean> resConnexion = this.modele.connecterUtilisateur(email, mdp);
		// Si connecté, lancer le menu
		if (resConnexion.get(0)) {
			// connecte = true;
			Utilisateur utilisateurConnecte = this.modele.getUtilisateurConnecte();
			this.vueManager.afficherConnexionReussie(utilisateurConnecte);
			this.lancerMenu();
		}
		// Sinon, afficher que la connexion a échoué, et retenter la connexion
		else {
			this.vueClient.afficherConnexionEchouee();
			this.gererConnexion();
		}
		// }
	}

	/**
	 * Permet d'afficher un film
	 * Récupère d'abord l'ID du film à afficher, via la Vue, fait appel au Modèle pour le récupérer
	 * Et rappelle enfin la Vue pour afficher les données ainsi récupérées
	 */
	@Override
	public void gererAffichageFilm() {
		String id_str = this.vueClient.afficherDialogueAffichageFilm();
		int idFilm = Integer.parseInt(id_str);

		// Film film = chercherFilmParID(modele.getListeFilms(), idFilm);
		Film film = this.modele.getFilm(idFilm);
		this.vueClient.afficherFilm(film);
		this.lancerMenu();
	}

	@Override
	public void gererAffichageFilms() {
		Set<Film> filmsAAfficher = this.modele.getListeFilms();
		for (Film f : filmsAAfficher) {
			this.vueClient.afficherFilm(f);
		}
		this.lancerMenu();
	}

	@Override
	public void gererAffichageSalles() {
		this.vueClient.afficherSalles(this.modele.getListeSalles());
		this.lancerMenu();
	}

	@Override
	public void gererAffichageToutesSeances() {
		Set<Seance> lSeances = this.modele.getListeSeances();
		this.vueClient.afficherSeances(lSeances);
		this.lancerMenu();
	}

	@Override
	public void gererAffichageSeancesUnFilm() {
		String id_str = this.vueClient.afficherDialogueSeancesUnFilm();
		int idFilm = Integer.parseInt(id_str);
		Film film = this.modele.getFilm(idFilm);
		if (film == null) {
			this.vueClient.afficherSeances(new HashSet<>());
		} else {
			Set<Seance> seancesAAfficher = new HashSet<>();
			for (Seance s : this.modele.getListeSeances()) {
				if (s.getFilm().getId() == film.getId()) {
					seancesAAfficher.add(s);
				}
			}
			this.vueClient.afficherSeances(seancesAAfficher);
		}
		this.lancerMenu();
	}

	@Override
	public void gererAffichageSeance() {
		String s = this.vueClient.afficherDialogueAffichageSeance();
		int idSeance = Integer.parseInt(s);
		Seance seance = this.modele.getSeance(idSeance);
		this.vueClient.afficherSeance(seance);
		this.lancerMenu();
	}

	/**
	 * Gere l'affichage de réservation, en récupérant l'ID de celle-ci, puis en l'affichant,
	 * à l'aide de la Vue et du Modèle
	 */
	@Override
	public void gererAffichageResa() {
		String id_str = this.vueClient.affichageDialogueAffichageResa();
		Reservation r = this.modele.getReservation(Integer.parseInt(id_str));
		if (r == null) {
			this.vueClient.afficherAffichageResaEchoue();
		} else {
			this.vueClient.afficherReservation(r);
		}
		this.lancerMenu();
	}

	@Override
	public void gererNouvelleResa() {
		try {
			ArrayList<String> donneesResa = this.vueClient.afficherDialogueNouvelleReservation();
			Set<Billet> billetsAPrendre = new HashSet<>();
			for (String s : donneesResa) {
				int idSeance = Integer.parseInt(s);
				Billet b = new BilletPleinTarif(this.modele.getSeance(idSeance));
				billetsAPrendre.add(b);
			}
			int idResa = this.modele.creerReservation(this.modele.getUtilisateurConnecte().getId(), billetsAPrendre);
			if (idResa > 0) {
				this.vueClient.afficherReservationReussie(this.modele.getReservation(idResa));
			} else {
				this.vueClient.afficherReservationEchouee();
			}
		} catch (Exception e) {
			this.vueClient.afficherReservationEchouee();
		}
		this.lancerMenu();
	}

	@Override
	public void gererSuppressionResa() {
		String id_str = this.vueClient.afficherDialogueSuppressionResa();
		if (this.modele.supprimerReservation(Integer.parseInt(id_str))) {
			this.vueClient.afficherSuppressionResaReussie();
		} else {
			this.vueClient.afficherSuppressionResaEchouee();
		}
		this.lancerMenu();
	}

	@Override
	public void gererCreationUtilisateur() {
		try {
			ArrayList<String> donneesUtilisateur = this.vueManager.afficherDialogueCreationUtilisateur();
			if (donneesUtilisateur.size() != 3) {
				this.vueManager.afficherReservationEchouee();
			} else {
				int userID = this.modele.ajouterClient(donneesUtilisateur.get(0), donneesUtilisateur.get(1),
						donneesUtilisateur.get(2));
				if (userID > 0) {
					this.vueManager.afficherCreationUtilisateurReussie(this.modele.getUtilisateur(userID));
				} else {
					this.vueManager.afficherCreationUtilisateurEchouee();
				}
			}
		} catch (Exception e) {
			this.vueManager.afficherCreationUtilisateurEchouee();
		}
		this.lancerMenu();
	}

	@Override
	public void gererSuppressionUtilisateur() {
		try {
			int id = Integer.parseInt(this.vueManager.afficherDialogueSuppressionUtilisateur().get(0));
			Utilisateur aSupprimer = this.modele.getUtilisateur(id);
			if (aSupprimer == null) {
				this.vueManager.afficherSuppressionUtilisateurEchouee();
			} else {
				if (this.modele.supprimerUtilisateur(id)) {
					this.vueManager.afficherSuppressionUtilisateurReussie();
				} else {
					this.vueManager.afficherSuppressionUtilisateurEchouee();
				}
			}
		} catch (Exception e) {
			this.vueManager.afficherSuppressionUtilisateurEchouee();
		}
		this.lancerMenu();
	}

	@Override
	public void gererDeconnexion() {
		boolean veutSeDeconnecter = this.vueClient.afficherDialogueDeconnexion();
		if (veutSeDeconnecter) {
			if (this.modele.deconnecterUtilisateur()) {
				this.vueClient.afficherDeconnexionReussie(null);
				this.gererConnexion();
			} else {
				this.vueClient.afficherDeconnexionEchouee();
				this.lancerMenu();
			}
		} else {
			this.lancerMenu();
		}
	}

	@Override
	public void gererCreationFilm() {

		ArrayList<String> donneesFilm = this.vueManager.afficherDialogueCreationFilm();
		String titre = donneesFilm.get(0);
		int annee = Integer.parseInt(donneesFilm.get(1));
		String description = donneesFilm.get(2);
		String duree_str = donneesFilm.get(3);
		HashSet<String> genres_str = new HashSet<>(donneesFilm.subList(4, donneesFilm.size()));

		// Création de la séance
		try {
			int idNvFilm = this.modele.ajouterFilm(titre, annee, description, Integer.parseInt(duree_str), genres_str);
			if (idNvFilm > 0) {
				this.vueManager.afficherCreationFilmReussie(this.modele.getFilm(idNvFilm));
			} else {
				this.vueManager.afficherCreationFilmEchouee();
			}
		} catch (Exception e) {
			this.vueManager.afficherCreationFilmEchouee();
		}
		this.lancerMenu();
	}

	@Override
	public void gererSuppressionFilm() {
		ArrayList<String> Liste;
		Liste = this.vueManager.afficherDialogueSuppressionFilm();
		String id_str = Liste.get(0);
		boolean suppressionReussie = this.modele.supprimerFilm(Integer.parseInt(id_str));
		if (suppressionReussie) {
			this.vueManager.afficherSuppressionFilmReussie();
		} else {
			this.vueManager.afficherSuppressionFilmEchouee();
		}
		this.lancerMenu();
	}

	@Override
	public void gererCreationSalle() {
		ArrayList<String> Liste;

		Liste = this.vueManager.afficherDialogueCreationSalle();

		int numero = Integer.parseInt(Liste.get(0));
		int nb = Integer.parseInt(Liste.get(1));

		try {
			Salle salle = new Salle(numero, nb);
			this.vueManager.afficherCreationSalleReussie(salle);
			this.modele.getListeSalles().add(salle);
		} catch (Exception e) {
			this.vueManager.afficherCreationSalleEchouee();
		}
		this.lancerMenu();
	}

	@Override
	public void gererSuppressionSalle() {
		ArrayList<String> Liste;

		Liste = this.vueManager.afficherDialogueSuppressionSalle();

		int id = Integer.parseInt(Liste.get(0));
		// Salle s = ChercherSalleParID(this.modele.getListeSalles(), id);
		// boolean supprime = supprimerSalleParId(this.modele.getListeSalles(), id);
		boolean supprime = this.modele.supprimerSalle(id);

		if (supprime) {
			this.vueManager.afficherSuppressionSalleReussie();
		} else {
			this.vueManager.afficherSuppressionSalleEchouee();
		}
		this.lancerMenu();
	}

	@Override
	public void gererCreationSeance() throws ParseException {

		ArrayList<String> listeArguments = this.vueManager.afficherDialogueCreationSeance();
		// Boolean creation = true;
		int filmId = Integer.parseInt(listeArguments.get(0));
		Film film = this.modele.getFilm(filmId);

		if (film == null) {
			// creation = false;
			vueManager.afficherCreationSeanceEchouee();
			// System.out.println(
			// "Le Film sélectionné n'est pas au catalogue du Cinéma, merci de l'ajouter
			// dans un premier temps.\n");
		}
		// Le film est bien enregistré dans le modèle
		else {
			String date_str = listeArguments.get(1);
			String heure_str = listeArguments.get(2);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date dateSeance = formatter.parse(date_str + " " + heure_str);


			int idSalle = Integer.parseInt(listeArguments.get(3));

			// [MERGE] [MERGE_DEL]
			// ArrayList<Salle> listeSalle = this.modele.getListeSalle();
			// Salle s = chercherSalleParId(listeSalle, idSalle);
			Salle s = this.modele.getSalle(idSalle);
			if (s == null) {
				// creation = false;
				this.vueManager.afficherCreationSeanceEchouee();
				// System.out.println("La Salle sélectionner n'existe, merci de reprocéder.
				// \n");
			}
			// La salle est bien enregistrée dans le modèle
			else {
				String typeStr = listeArguments.get(4);
				// TypeSeance typeSeance = TypeSeance.REGULAR;
				TypeSeance typeSeance;

				try {
					typeSeance = TypeSeance.valueOf(typeStr.toUpperCase());
				} catch (IllegalArgumentException e) {
					typeSeance = TypeSeance.REGULAR;
				}

				// Création de la séance
				try {
					// Seance seance = new Seance(film, dateSeance, heure_str, s, typeSeance);
					int idSeance = this.modele.ajouterSeance(idSalle, filmId, dateSeance, typeSeance);
					this.vueManager.afficherCreationSeanceReussie(this.modele.getSeance(idSeance));
				} catch (Exception e) {
					this.vueManager.afficherCreationSeanceEchouee();
				}
			}
		}
		this.lancerMenu();
	}

	@Override
	public void gererSuppressionSeance() {
		ArrayList<String> Liste;

		Liste = this.vueManager.afficherDialogueSuppressionSeance();
		int id = Integer.parseInt(Liste.get(0));
		boolean supprime = this.modele.supprimerSeance(id);

		if (supprime) {
			this.vueManager.afficherSuppressionSeanceReussie();
		} else {
			this.vueManager.afficherSuppressionSeanceEchouee();
		}
		this.lancerMenu();
	}

	public void gererAffichageUtilisateurs() {
		this.vueManager.afficherUtilisateurs(this.modele.getListeUtilisateurs());
		this.lancerMenu();
	}
}
