public class Client extends Utilisateur {

	// public Client() {
	// }

	public Client(String nom, String email, String motDePasse) {
		super(nom, email, motDePasse);
	}

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

	// // Réserver une séance
	// public Reservation reserverSeance(Seance seance) {
	// 	System.out.println("Réservation d'une séance pour le film : "
	// 					   + seance.getFilm().getTitre());
	// 	// Exemple : création d’une nouvelle réservation
	// 	Reservation reservation = new Reservation();
	// 	reservation.setClient(this);
	// 	reservation.setSeance(seance);
	// 	// On peut imaginer que la date de réservation est la date courante
	// 	reservation.setDateReservation(new java.util.Date());

	// 	// Logique supplémentaire : vérifier places, etc.
	// 	// ...

	// 	return reservation;
	// }

	// // Payer une réservation
	// public void payerReservation(Reservation reservation) {
	// 	System.out.println("Le client " + nom
	// 					   + " paie la réservation n° "
	// 					   + reservation.getIdReservation());
	// 	// Logique de paiement...
	// }
}
