import java.util.ArrayList;
import java.util.Set;

public interface IVueUtilisateur {
	public ArrayList<String> afficherDialogueConnexion();

	public void afficherConnexionReussie();

	public void afficherConnexionReussie(Utilisateur u);

	public void afficherConnexionEchouee();

	/**
	 * Appelée lorsque l'utilisateur choisir l'option de déconnexion dans le menu
	 * 
	 * @return {@code true} si l'utilisateur confirme vouloir se déconnecter, {@code false} sinon
	 */
	public boolean afficherDialogueDeconnexion();

	public void afficherDeconnexionReussie(Utilisateur u);

	public void afficherDeconnexionEchouee();

	public String afficherDialogueAffichageFilm();

	public void afficherFilm(Film f);

	public void afficherFilms(Set<Film> films);

	public void afficherSalles(Set<Salle> salles);

	public String afficherDialogueAffichageSeance();

	public void afficherSeance(Seance s);

	public String afficherDialogueAffichageSeancesUneSalle();

	public void afficherSeancesUneSalle(Set<Seance> seances);

	public String afficherDialogueAffichageSeancesPlusieursSalles();

	public void afficherSeancesPlusieursSalles(Set<Seance> seances);

	public ArrayList<String> afficherDialogueReservationSeance();

	// void afficherReservationReussie(Reservation r);
	public void afficherReservationEchouee();
	// void afficherReservation(Reservation r);
}
