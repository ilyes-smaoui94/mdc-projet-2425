public class Manager extends Utilisateur {

	// 1) Attribut statique qui contiendra l’unique instance
	private static Manager instance;

	// 2) Constructeur privé (on empêche l'instanciation directe)
	private Manager(String nom, String email, String motDePasse) {
		super(nom, email, motDePasse);
	}

	// 3) Méthode statique pour récupérer ou créer l'instance
	public static Manager getManagerInstance(String nom, String email, String motDePasse) {
		if (Manager.instance == null) {
			Manager.instance = new Manager(nom, email, motDePasse);
		}
		return Manager.instance;
	}

	// --------------------
	// Méthodes héritées de Utilisateur
	// --------------------
	@Override
	public boolean seConnecter() {
		return true;
		// System.out.println("Client " + nom + " est connecté.");
	}

	@Override
	public boolean seDeconnecter() {
		return true;
		// System.out.println("Client " + nom + " est déconnecté.");
	}

	// // --------------------
	// // Logique métier
	// // --------------------
	// public Film creerFilm(String titre, int duree) {
	// 	Film film = new Film();
	// 	film.setTitre(titre);
	// 	film.setDureeMinutes(duree);
	// 	System.out.println("Film créé : " + titre + " (" + duree + " min)");
	// 	return film;
	// }

	// public Seance programmerSeance(Film film, Salle salle, Date dateHeure) {
	// 	Seance seance = new Seance();
	// 	seance.setFilm(film);
	// 	seance.setSalle(salle);
	// 	seance.setDateHeure(dateHeure);
	// 	System.out.println("Séance programmée pour le film : " + film.getTitre()
	// 					   + ", dans la salle : " + salle.getNomSalle()
	// 					   + ", le : " + dateHeure);
	// 	return seance;
	// }
}
