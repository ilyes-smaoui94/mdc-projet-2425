
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class ControleurCinema implements IControleurCinema {

	private IModeleCinema modele;
	private IVueClient vueClient;
	private IVueManager vueManager;

	public ControleurCinema(IModeleCinema modele) {

		this.modele = modele;
	}

	public void lancerApplication() {
		// "Activer" la vue si nécessaire
		this.gererConnexion();
	}

	public void gererConnexion () {
		boolean connecte = false;
		// Attends une connexion réussie
		while (!connecte) {
			// Récupère les identifiants
			ArrayList<String> connArgs = this.vueClient.afficherDialogueConnexion();
			String email = connArgs.get(0);
			String mdp = connArgs.get(1);
			// Tente une connexion auprès du modèle
			ArrayList<Boolean> resConnexion = this.modele.connecterUtilisateur(email, mdp);
			// Si connecté
			if (resConnexion.get(0)) {
				connecte = true;
				Utilisateur utilisateurConnecte = this.modele.getUtilisateurConnecte();
				this.vueManager.afficherConnexionReussie(utilisateurConnecte);
				// Si c'est un admin
				if (resConnexion.get(1)) {
					this.vueManager.afficherMenuManager();
				}
				// Sinon, c'est un client
				else {
					this.vueClient.afficherMenuClient();
				}
			}
			// Sinon, afficher que la connexion a échoué
			else {
				this.vueClient.afficherConnexionEchouee();
			}
		}
	}

	public void gererReservationSeance () {
		ArrayList<String> donneesResa = this.vueClient.afficherDialogueReservationSeance();
		Set<Billet> billetsAPrendre = new HashSet<Billet>();
		for (String s : donneesResa) {
			int idSeance = Integer.parseInt(s);
			Billet b = new BilletPleinTarif(this.modele.getSeance(idSeance));

		}
		this.modele.creerReservation(this.modele.getUtilisateurConnecte().getId(), billetsAPrendre);
	}

	public void setVues(IVueClient vueClient, IVueManager vueManager) {
		this.vueClient = vueClient;
		this.vueManager = vueManager;
	}

	public void setModele(IModeleCinema modele) {
		this.modele = modele;
	}

	public IVueClient getVueClient() {
		return this.vueClient;
	}

	public IVueManager getVueManager() {
		return this.vueManager;
	}

	public IModeleCinema getModele() {
		return this.modele;
	}

	// [MERGE] [MERGE_DEL]
	// public Film chercherFilmParID(HashSet<Film> listeFilms, int id) {
	// for (Film film : listeFilms) {
	// if (film.getId() == id) { // Vérification basée sur l'ID
	// return film; // 🎬 Film déjà présent !
	// }
	// }
	// return null; // ❌ Film non trouvé
	// }

	// [MERGE] [MERGE_DEL]
	// public Seance ChercherSeanceParID(ArrayList<Seance> l, int id) {
	// for (Seance seance : l) {
	// if (seance.getId() == id) { // Vérification basée sur l'ID
	// return seance; // 🎬 Film déjà présent !
	// }
	// }
	// return null; // ❌ Film non trouvé
	// }

	// [MERGE] [MERGE_DEL]
	// public Salle ChercherSalleParID(ArrayList<Salle> l, int id) {
	// for (Salle salle : l) {
	// if (salle.getId() == id) {
	// return salle;
	// }
	// }
	// return null;
	// }

	// [MERGE]
	// public static boolean verifierDisponibiliteSeance(ArrayList<Seance>
	// listeSeances, Salle salle, String heure) {
	// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	// LocalTime heureNouvelleSeance = LocalTime.parse(heure, formatter);

	// for (Seance seance : listeSeances) {
	// if (seance.getSalle().getId() == salle.getId()) {
	// LocalTime heureExistante = Outils.asLocalDateTime(date)(seance.getDate());
	// long difference = Math.abs(heureExistante.toSecondOfDay() -
	// heureNouvelleSeance.toSecondOfDay()) / 3600; // Convertir
	// // en
	// // heures
	// if (difference < 2) {
	// return false; // ⛔ Trop proche d'une autre séance !
	// }
	// }
	// }
	// return true; // ✅ Disponible avec une marge de 2 heures
	// }

	public void GererCreationFilm() {

		ArrayList<String> Liste = this.vueManager.AfficherDialogueCreationFilm();
		String titre = Liste.get(0);
		int annee = Integer.parseInt(Liste.get(1));
		String descritpion = Liste.get(2);
		String duree_str = Liste.get(3);
		String genre = Liste.get(4);

		Genre MainGenre = null;

		if (genre.equalsIgnoreCase("Drame")) {
			MainGenre = Genre.DRAME;
		} else if (genre.equalsIgnoreCase("Comedie")) {
			MainGenre = Genre.COMEDIE;
		} else if (genre.equalsIgnoreCase("Horreur")) {
			MainGenre = Genre.HORREUR;
		} else if (genre.equalsIgnoreCase("Action")) {
			MainGenre = Genre.ACTION;
		} else if (genre.equalsIgnoreCase("Thriller")) {
			MainGenre = Genre.THRILLER;
		}

		// Création de la séance
		try {
			Film film = new Film(titre, annee, descritpion, Integer.parseInt(duree_str), MainGenre);
			this.vueManager.afficherCreationFilmReussie(film);
			this.modele.getListeFilms().add(film);
		} catch (Exception e) {
			this.vueManager.afficherCreationFilmEchouer();
		}
		// Ajout de la séance au planning

	}

	public void GererSuppressionFilm() {
		ArrayList<String> Liste;

		Liste = this.vueManager.AfficherDialogueSuppressionFilm();
		String titre = Liste.get(0);
		int annee = Integer.parseInt(Liste.get(1));

		Film f = this.chercherFilmParNom(this.modele.getListeFilms(), titre); // [MERGE]
		// System.out.println("*********************"); // [debugging]
		// System.out.println(f.getTitre()); // [debugging]
		// System.out.println(f.getId()); // [debugging]

		boolean supprime = this.modele.getListeFilms().remove(f);

		if (supprime) {
			this.vueManager.afficherSuppressionFilmReussie();
		} else {
			this.vueManager.afficherSuppressionFilmEchouer();
		}

	}

	public void GererAffichageFilms() {
		Set<Film> films = this.modele.getListeFilms();
		for (Film f : films) {
			System.out.println("[ID: " + f.getId() + ", titre: " + f.getTitre() + ", annee: " + f.getAnnee()
					+ ", Description: " + f.getDesc() + ", Genre principal:" + f.getGenres() + "]");
		}
	}

	public void GererAffichageFilm() {
		String id = this.vue.afficherDialogueAffichageFilm();
		int Id = Integer.parseInt(id);

		// Film film = chercherFilmParID(modele.getListeFilms(), Id);
		Film film = this.modele.getFilm(Id);
		this.vue.afficherFilm(film);
		this.vue.afficherMenuClient();
	}

	public Film chercherFilmParNom(HashSet<Film> listeFilms, String titre) {

		for (Film film : listeFilms) {
			if (film.getTitre().equalsIgnoreCase(titre)) { // Vérification basée sur l'ID
				return film; // 🎬 Film déjà présent !
			}
		}
		return null; // ❌ Film non trouvé
	}

	public Salle chercherSalleParId(ArrayList<Salle> salles, int num) {
		for (Salle salle : salles) {
			if (salle.getId() == num) {
				return salle;
			}
		}
		return null;
	}

	public void GererCreationSeance() throws ParseException {

		ArrayList<String> listeArguments = this.vueManager.afficherDialogueCreationSeance();
		Boolean creation = true;
		String f = listeArguments.get(0);
		// Film film = this.chercherFilmParNom(this.modele.getListeFilms(), f);

		if (film == null) {
			vue.afficherCreationSeanceEchouee();
			creation = false;
			System.out.println(
					"Le Film sélectionner n'est pas au catalogue du Cinema, merci de  l'ajouter dans un premier temps. \n");
		}
		String d = listeArguments.get(1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(d);

		String heure = listeArguments.get(2);

		int idSalle = Integer.parseInt(listeArguments.get(3));

		// [MERGE] [MERGE_DEL]
		// ArrayList<Salle> listeSalle = this.modele.getListeSalle();
		// Salle s = chercherSalleParId(listeSalle, idSalle);
		Salle s = this.modele.getSalle(idSalle);
		if (s == null) {
			creation = false;
			this.vueManager.afficherCreationSeanceEchouee();
			System.out.println("La Salle sélectionner n'existe, merci de reprocéder. \n");
		// } else if (!verifierDisponibiliteSeance(this.modele.getListeSeances(), s, heure)) {
		// 	creation = false;
		// 	vue.afficherCreationSeanceEchouee();
		// 	System.out.println("La Salle sélectionner n'est pas disponible, merci de reprocéder. \n");
		// }
		String typeStr = listeArguments.get(4);
		TypeSeance typeSeance = TypeSeance.REGULAR;

		if (typeStr.equalsIgnoreCase("IMAX") || typeStr.equalsIgnoreCase("imax") || typeStr.equalsIgnoreCase("Imax")) {
			typeSeance = TypeSeance.IMAX;
		} else if (typeStr.equalsIgnoreCase("4Dmax") || typeStr.equalsIgnoreCase("4dmax")
				|| typeStr.equalsIgnoreCase("4DMAX")) {
			typeSeance = TypeSeance.DMAX_4D;
		} else if (typeStr.equalsIgnoreCase("3D") || typeStr.equalsIgnoreCase("3d")) {
			typeSeance = TypeSeance._3D;
		} else {
			System.out.println(
					"Attention: Le type de seance selectionner n'est pas adapté et à été mis par défaut à regular. \n");
		}

		// Création de la séance
		if (creation) {
			try {
				// Seance seance = new Seance(film, date, heure, s, typeSeance);
				this.modele.ajouterFilm(idSalle, , listeArguments, typeSeance)
				this.vueManager.afficherCreationSeanceReussie(seance);
				// this.modele.getListeSeances().add(seance);
			}
			catch (Exception e) {
				this.vueClient.afficherCreationSeanceEchouee();
			}
		}
	}

	public static boolean supprimerSeanceParId(ArrayList<Seance> listeSeances, int id) {
		Iterator<Seance> iterator = listeSeances.iterator();

		while (iterator.hasNext()) {
			Seance seance = iterator.next();
			if (seance.getId() == id) { // Vérifie si l'ID correspond
				iterator.remove(); // Supprime la séance en toute sécurité
				System.out.println("✅ Séance avec ID " + id + " supprimée avec succès.");
				return true; // Retourne true si la suppression a eu lieu
			}
		}

		System.out.println("⛔ Aucune séance trouvée avec l'ID " + id + ".");
		return false; // Retourne false si aucune séance n'a été trouvée
	}

	public void GererSuppressionSeance() {
		ArrayList<String> Liste;

		Liste = this.vueManager.afficherDialogueSuppressionSeance();
		int id = Integer.parseInt(Liste.get(0));
		// Seance s = ChercherSeanceParID(this.modele.getListeSeances(), id); [MERGE]
		// Seance seance = this.modele.getSeance(id);
		// boolean supprime = supprimerSeanceParId(this.modele.getListeSeances(), id);
		boolean supprime = this.modele.supprimerSeance(id);

		if (supprime) {
			this.vueManager.afficherSuppressionSeanceReussie();
		} else {
			this.vueManager.afficherSuppressionSeanceEchouee();
		}

	}

	public void GererCreationSalle() {
		ArrayList<String> Liste;

		Liste = this.vue.afficherDialogueCreationSalle();

		int id = Integer.parseInt(Liste.get(0));
		int nb = Integer.parseInt(Liste.get(1));

		Salle salle = new Salle(id, nb);

		if (salle != null) {
			this.vue.afficherCreationSalleReussie(salle);
			this.modele.getListeSalle().add(salle);

		} else {
			this.vue.afficherCreationSalleEchouee();
		}

	}

	public static boolean supprimerSalleParId(ArrayList<Salle> listeSalles, int id) {
		Iterator<Salle> iterator = listeSalles.iterator();

		while (iterator.hasNext()) {
			Salle salle = iterator.next();
			if (salle.getId() == id) { // Vérifie si l'ID correspond
				iterator.remove(); // Supprime la salle en toute sécurité
				System.out.println("✅ Salle avec ID " + id + " supprimée avec succès.");
				return true; // Retourne true si la suppression a eu lieu
			}
		}

		System.out.println("⛔ Aucune salle trouvée avec l'ID " + id + ".");
		return false; // Retourne false si aucune salle n'a été trouvée
	}

	public void gererSuppressionSalle() {
		ArrayList<String> Liste;

		Liste = this.vue.afficherDialogueSuppressionSalle();

		int id = Integer.parseInt(Liste.get(0));
		Salle s = ChercherSalleParID(this.modele.getListeSalle(), id);
		boolean supprime = supprimerSalleParId(this.modele.getListeSalle(), id);

		if (supprime) {
			this.vue.afficherSuppressionSalleReussie(s);
		} else {
			this.vue.afficherSuppressionSalleEchouee();
		}

	}

	public void gererAffichageUneSeance() {
		String s = vue.afficherDialogueAffichageSeance();
		int idSeance = Integer.parseInt(s);
		Seance seance = this.ChercherSeanceParID(this.modele.getListeSeance(), idSeance);

		vue.afficherSeance(seance);

	}

	public void gererAffichageToutesSeances() {
		ArrayList<Seance> lSeances = modele.getListeSeance();
		for (Seance seance : lSeances) {
			vue.afficherSeance(seance);
		}

	}

	public void GererAffichageToutesSeancesUnFilm() {
		String id = vue.afficherDialogueSeancesUnFilm();
		int idFilm = Integer.parseInt(id);
		ArrayList<Seance> ListeSeances = modele.getListeSeance();
		for (Seance seance : ListeSeances) {
			if (seance.getFilm().getId() == idFilm) {
				vue.afficherSeance(seance);
			}
		}

	}
}
