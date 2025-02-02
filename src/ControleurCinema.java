
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

	public ControleurCinema(ModeleCinema modele) {

		this.modele = modele;
	}

	public void setVues(IVueClient vueClient, IVueManager vueManager) {
		this.vueClient = vueClient;
		this.vueManager = vueManager;
	}

	public void setModele(IModeleCinema modele) {
		this.modele = modele;
	}

	public Film chercherFilmParID(HashSet<Film> listeFilms, int id) {
		for (Film film : listeFilms) {
			if (film.getId() == id) { // Vérification basée sur l'ID
				return film; // 🎬 Film déjà présent !
			}
		}
		return null; // ❌ Film non trouvé
	}

	public Seance ChercherSeanceParID(ArrayList<Seance> l, int id) {
		for (Seance seance : l) {
			if (seance.getId() == id) { // Vérification basée sur l'ID
				return seance; // 🎬 Film déjà présent !
			}
		}
		return null; // ❌ Film non trouvé
	}

	public Salle ChercherSalleParID(ArrayList<Salle> l, int id) {
		for (Salle salle : l) {
			if (salle.getId() == id) {
				return salle;
			}
		}
		return null;
	}

	public static boolean verifierDisponibiliteSeance(ArrayList<Seance> listeSeances, Salle salle, String heure) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime heureNouvelleSeance = LocalTime.parse(heure, formatter);

		for (Seance seance : listeSeances) {
			if (seance.getSalle().getId() == salle.getId()) {
				LocalTime heureExistante = LocalTime.parse(seance.getHeure(), formatter);
				long difference = Math.abs(heureExistante.toSecondOfDay() - heureNouvelleSeance.toSecondOfDay()) / 3600; // Convertir
																														 // en
																														 // heures

				if (difference < 2) {
					return false; // ⛔ Trop proche d'une autre séance !
				}
			}
		}
		return true; // ✅ Disponible avec une marge de 2 heures
	}

	public void GererCreationFilm() {

		ArrayList<String> Liste = this.vue.AfficherDialogueCreationFilm();
		String titre = Liste.get(0);
		int annee = Integer.parseInt(Liste.get(1));
		String descritpion = Liste.get(2);
		String genre = Liste.get(3);

		Genre MainGenre = null;

		if (genre.equalsIgnoreCase("Drame")) {
			MainGenre = Genre.Drame;
		} else if (genre.equalsIgnoreCase("Comedie")) {
			MainGenre = Genre.Comedie;
		} else if (genre.equalsIgnoreCase("Horreur")) {
			MainGenre = Genre.Horreur;
		} else if (genre.equalsIgnoreCase("Action")) {
			MainGenre = Genre.Action;
		} else if (genre.equalsIgnoreCase("Thriller")) {
			MainGenre = Genre.Thriller;
		}

		// Création de la séance
		Film film = new Film(titre, annee, descritpion, MainGenre);
		if (film != null) {
			this.vue.afficherCreationFilmReussie(film);
			this.modele.getListeFilms().add(film);

		} else {
			this.vue.afficherCreationFilmEchouer();
			// System.out.println(titre); // [debugging]
		}
		// Ajout de la séance au planning

	}

	public void GererSuppressionFilm() {
		ArrayList<String> Liste;

		Liste = this.vue.AfficherDialogueSuppressionFilm();
		String titre = Liste.get(0);
		int annee = Integer.parseInt(Liste.get(1));

		Film f = this.chercherFilmParNom(this.modele.getListeFilms(), titre);
		// System.out.println("*********************"); // [debugging]
		// System.out.println(f.getTitre()); // [debugging]
		// System.out.println(f.getId()); // [debugging]

		boolean supprime = this.modele.getListeFilms().remove(f);

		if (supprime) {
			this.vue.afficherSuppressionFilmReussie(f);
		} else {
			this.vue.afficherSuppressionFilmEchouer();
		}

	}

	public void GererAffichageFilms() {
		Set<Film> films = this.modele.getListeFilms();
		for (Film f : films) {
			System.out.println("[ID: " + f.getId() + ", titre: " + f.getTitre() + ", annee: " + f.getAnnee()
					+ ", Description: " + f.getDesc() + ", Genre principal:" + f.getGenre() + "]");
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

		ArrayList<String> Liste = this.vue.afficherDialogueCreationSeance();
		Boolean creation = true;
		String f = Liste.get(0);
		Film film = this.chercherFilmParNom(this.modele.getListeFilms(), f);

		if (film == null) {
			vue.afficherCreationSeanceEchouee();
			creation = false;
			System.out.println(
					"Le Film sélectionner n'est pas au catalogue du Cinema, merci de  l'ajouter dans un premier temps. \n");
		}
		String d = Liste.get(1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(d);

		String heure = Liste.get(2);

		int salle = Integer.parseInt(Liste.get(3));

		ArrayList<Salle> listeSalle = this.modele.getListeSalle();
		Salle s = chercherSalleParId(listeSalle, salle);
		if (s == null) {
			creation = false;
			vue.afficherCreationSeanceEchouee();
			System.out.println("La Salle sélectionner n'existe, merci de reprocéder. \n");
		} else if (!verifierDisponibiliteSeance(modele.getListeSeance(), s, heure)) {
			creation = false;
			vue.afficherCreationSeanceEchouee();
			System.out.println("La Salle sélectionner n'est pas disponible, merci de reprocéder. \n");
		}
		String typeStr = Liste.get(4);
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
			Seance seance = new Seance(film, date, heure, s, typeSeance);

			if (seance != null) {
				this.vue.afficherCreationSeanceReussie(seance);
				this.modele.getListeSeance().add(seance);

			} else {
				this.vue.afficherCreationSeanceEchouee();
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

		Liste = this.vue.afficherDialogueSuppressionSeance();
		int id = Integer.parseInt(Liste.get(0));
		Seance s = ChercherSeanceParID(this.modele.getListeSeance(), id);
		boolean supprime = supprimerSeanceParId(this.modele.getListeSeance(), id);

		if (supprime) {
			this.vue.afficherSuppressionSeanceReussie(s);
		} else {
			this.vue.afficherSuppressionSeanceEchouee();
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
