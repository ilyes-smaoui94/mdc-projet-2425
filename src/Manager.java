package model;

import java.util.Date;

public class Manager extends Utilisateur {

	// 1) Attribut statique qui contiendra l’unique instance
	private static Manager instance;

	// 2) Constructeur privé (on empêche l'instanciation directe)
	private Manager(int id, String nom, String email, String motDePasse) {
		super(id, nom, email, motDePasse);
	}

	// 3) Méthode statique pour récupérer ou créer l'instance
	public static Manager getDataManager(int id, String nom, String email, String motDePasse) {
		if (instance == null) {
			instance = new Manager(id, nom, email, motDePasse);
		}
		return instance;
	}

	// --------------------
	// Méthodes héritées de Utilisateur
	// --------------------
	@Override
	public void seConnecter() {
		System.out.println("Manager " + nom + " est connecté.");
	}

	@Override
	public void seDeconnecter() {
		System.out.println("Manager " + nom + " est déconnecté.");
	}

	// --------------------
	// Logique métier
	// --------------------
	public Film creerFilm(String titre, int duree) {
		Film film = new Film();
		film.setTitre(titre);
		film.setDureeMinutes(duree);
		System.out.println("Film créé : " + titre + " (" + duree + " min)");
		return film;
	}

	public Seance programmerSeance(Film film, Salle salle, Date dateHeure) {
		Seance seance = new Seance();
		seance.setFilm(film);
		seance.setSalle(salle);
		seance.setDateHeure(dateHeure);
		System.out.println("Séance programmée pour le film : " + film.getTitre()
						   + ", dans la salle : " + salle.getNomSalle()
						   + ", le : " + dateHeure);
		return seance;
	}
}
