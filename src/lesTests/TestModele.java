import java.util.ArrayList;
import java.util.Scanner;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TestModele {

	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date asDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDateTime asLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static void afficherRecap(IModeleCinema modele) {
		System.out.println("\n-----Récap-----\n");
		System.out.println("Utilisateurs :\n" + modele.getListeUtilisateurs());
		System.out.println("Billets :\n" + modele.getListeBillets());
		System.out.println("Films :\n" + modele.getListeFilms());
		System.out.println("Résas :\n" + modele.getListeReservations());
		System.out.println("Salles :\n" + modele.getListeSalles());
		System.out.println("Seances :\n" + modele.getListeSeances());
		System.out.println("");
	}

	public static void essayerConnexion (IModeleCinema modele, String email, String mdp) {
		System.out.println("\n-----Connexion-----");
		ArrayList<Boolean> resTest = modele.connecterUtilisateur(email, mdp);
		if (resTest.get(0)) {
			System.out.println("Connexion réussie !");
			if (resTest.get(1)) {
				System.out.println("(Manager)");
			}
			else {
				System.out.println("(Client)");
			}
		}
		else {
			System.out.println("Connexion échouée !");
		}
		System.out.println("");
	}

	public static void essayerAjoutSalle (IModeleCinema modele, int numero, int capacite) {
		System.out.println("\n-----AjoutSalle-----");
		int res = modele.ajouterSalle(numero, capacite);
		if (res > 0) {
			System.out.println("Salle d'ID " + res + " bien créée !");
			System.out.println("(Salle numéro " + modele.getSalle(res).getNumero() + " avec une capacité de " + modele.getSalle(res).getCapacite() + ")");
		}
		else {
			System.out.println("Échec !");
			System.out.println("(numéro : " + numero + ", capacité : " + capacite + ")");
		}
		System.out.println("");
	}

	public static void essayerAjoutFilm (IModeleCinema modele, String titre, int annee, String desc, int duree) {
		System.out.println("\n-----AjoutFilm-----");
		int res = modele.ajouterFilm(titre, annee, desc, duree);
		if (res > 0) {
			System.out.println("Film d'ID " + res + " bien créée !");
			System.out.println("(Titre : " + modele.getFilm(res).getTitre() + ", année : " + modele.getFilm(res).getAnnee() + ", duree : " + modele.getFilm(res).getDuree()
			 + " minutes)");
		}
		else {
			System.out.println("Échec !");
			System.out.println("(titre : " + titre + ", annee : " + annee + ", duree : " + duree + ")");
		}
		System.out.println("");
	}

	public static void essayerAjoutSeance (IModeleCinema modele, int idSalle, int idFilm, Date heureDebut) {
		System.out.println("\n-----AjoutSeance-----");
		int res = modele.ajouterSeance(idSalle, idFilm, heureDebut);
		if (res > 0) {
			System.out.println("Seance d'ID " + res + " bien créée !");
			System.out.println("(Salle numéro " + modele.getSeance(res).getSalle().getNumero() + " avec une capacité de " + modele.getSeance(res).getSalle().getCapacite() + ")");
			System.out.println("(film d'ID " + modele.getSeance(res).getFilm().getId() + ")");
			System.out.println("(commence à " + modele.getSeance(res).getDate() + ")");
		}
		else {
			System.out.println("Échec !");
			System.out.println("(idSalle : " + idSalle + ", idFilm : " + idFilm + ", heureDebut : " + heureDebut + ")");
		}
		System.out.println("");
	}

	public static void main (String args[]) {
		IModeleCinema monModele = new ModeleCinema();
		
		// Billet billet1 = new Bi
		
		// À tester : ?
		// ajouter/get/getListe
		String nomManager = "Manager", emailManager = "man@gmail.com", mdpManager = "mdp_man";
		String donneesClient1[] = {"Alice", "alice@gmail.com", "mdp_alice"};
		String donneesClient2[] = {"Bob", "bob@gmail.com", "mdp_bob"};
		String donneesClient3[] = {"Chris", "chris@gmail.com", "mdp_chris"};
		int donneesSalle[][] = {
			{1, 400},
			{37, 40},
			{6, 350},
			{1, 300},
			{3, 200}
		};
		
		// Ajout d'utilisateur
		monModele.ajouterManager(nomManager, emailManager, mdpManager);
		monModele.ajouterClient(donneesClient1[0], donneesClient1[1], donneesClient1[2]);
		monModele.ajouterClient(donneesClient2[0], donneesClient2[1], donneesClient2[2]);
		monModele.ajouterClient(donneesClient3[0], donneesClient3[1], donneesClient3[2]);

		essayerConnexion(monModele, emailManager, mdpManager);
		essayerConnexion(monModele, emailManager, mdpManager + "_");
		essayerConnexion(monModele, donneesClient1[1], donneesClient1[2]);
		essayerConnexion(monModele, donneesClient2[1], donneesClient2[2]);
		essayerConnexion(monModele, donneesClient2[1], donneesClient2[2] + "_");

		essayerAjoutSalle(monModele, donneesSalle[0][0], donneesSalle[0][1]);
		essayerAjoutSalle(monModele, donneesSalle[1][0], donneesSalle[1][1]);
		essayerAjoutSalle(monModele, donneesSalle[2][0], donneesSalle[2][1]);
		essayerAjoutSalle(monModele, donneesSalle[3][0], donneesSalle[3][1]);
		essayerAjoutSalle(monModele, donneesSalle[4][0], donneesSalle[4][1]);
		
		essayerAjoutFilm(monModele, "Interstellar", 2014, "descInterstellar", 169);
		essayerAjoutFilm(monModele, "EEAO", 2022, "descEEA0", 139);
		
		Scanner monScan = new Scanner(System.in);
		
		System.out.println("idSalle, idFilm, Date (UNIX milliseconds):");
		essayerAjoutSeance(monModele, monScan.nextInt(), monScan.nextInt(), new Date(monScan.nextLong()));
		System.out.println("idSalle, idFilm, Date (UNIX milliseconds):");
		essayerAjoutSeance(monModele, monScan.nextInt(), monScan.nextInt(), new Date(monScan.nextLong()));
		System.out.println("idSalle, idFilm, Date (UNIX milliseconds):");
		essayerAjoutSeance(monModele, monScan.nextInt(), monScan.nextInt(), new Date(monScan.nextLong()));
		System.out.println("idSalle, idFilm, Date (UNIX milliseconds):");
		essayerAjoutSeance(monModele, monScan.nextInt(), monScan.nextInt(), new Date(monScan.nextLong()));
		System.out.println("idSalle, idFilm, Date (UNIX milliseconds):");
		essayerAjoutSeance(monModele, monScan.nextInt(), monScan.nextInt(), new Date(monScan.nextLong()));
		System.out.println("idSalle, idFilm, Date (UNIX milliseconds):");
		essayerAjoutSeance(monModele, monScan.nextInt(), monScan.nextInt(), new Date(monScan.nextLong()));
		System.out.println("idSalle, idFilm, Date (UNIX milliseconds):");
		essayerAjoutSeance(monModele, monScan.nextInt(), monScan.nextInt(), new Date(monScan.nextLong()));
		
		// ;
		
		// Afficahge des listes du Modèles, pour une vue d'ensemble
		afficherRecap(monModele);
		
		// []
		// Client/Manager
		// Billets/BilletExtra
		// Salle
		// Seance, TypeSeance
		// Film, Genre
		// Reservation
	}
}