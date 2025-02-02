
public interface IControleurCinema {
	// Setters and Gettersa
	public void setVues(IVueClient vueClient, IVueManager vueManager);

	public IVueClient getVueClient();

	public IVueManager getVueManager();

	public void setModele(IModeleCinema modeleCinema);

	public IModeleCinema getModele();

	// Application Management
	public void lancerApplication();

	public void gererConnexion();

	// Reservation and Film Management
	public void gererReservationSeance();

	public void gererAffichageFilm();

	public void gererAffichageFilms();

	public void gererAffichageSalles();

	public void gererAffichageToutesSeances();

	public void gererAffichageSeancesUnFilm();

	public void gererAffichageUneSeance();

	public void gererAffichageResa();

	public void gererNouvelleResa();

	public void gererSuppressionResa();

	// User Management
	public void gererCreationUtilisateur();

	public void gererSuppressionUtilisateur();

	public void gererDeconnexion();

	// Film Management
	public void gererCreationFilm();

	public void gererSuppressionFilm();

	// Salle Management
	public void gererCreationSalle();

	public void gererSuppressionSalle();

	// Seance Management
	public void gererCreationSeance();

	public void gererSuppressionSeance();
}
