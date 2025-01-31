package app_cinema;

import java.util.ArrayList;

public interface IVueCinema {
	public void afficherMenu();
	public void afficheConfResa(Utilisateur u, Reservation r);
	public void afficheConfResa(Reservation r);
	public void afficheConfResa(Utilisateur u);
	public void afficheConfFilm(Utilisateur u);
	public void afficheConfFilm(Film f);
	public void afficheConfFilm(Utilisateur u, Film f);
	public void afficheConfSeanceCreee(Seance s);

	public void afficherConfCreationClient (Client nouveauClient);

	// public void afficher_horaire();
	// public void afficher_prix();
}
