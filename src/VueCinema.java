import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class VueCinema implements IVueManager, IVueClient {

  private ControleurCinema controleur;
  // private ModeleCinema modele;
  private Scanner leScanner;

  public VueCinema(ControleurCinema controleur, ModeleCinema modele) {
    this.controleur = controleur;
    // this.modele = modele;
    this.leScanner = new Scanner(System.in);
  }

  @Override
  public void afficherMenuClient() {
    // Implémentation à ajouter
  }

  @Override
  public void afficherMenuManager() {
    this.afficherMenuClient();
    // rajouter les options Manager
  }

  @Override
  public ArrayList<String> afficherDialogueConnexion() {
    ArrayList<String> res = new ArrayList<>();
    System.out.println("Pour lancer l'application, veuillez vous connecter, en entrant d'abord votre email, puis votre mot de passe :");
    String emailU = this.leScanner.nextLine();
    String mdpU = this.leScanner.nextLine();
    res.add(emailU);
    res.add(mdpU);
    return res;
  }

  @Override
  public void afficherConnexionReussie (Utilisateur u) {
    System.out.println("Connexion réussie !");
    System.out.println("(Utilisateur " + u.getEmail() + " connecté)");
  }
  
  @Override
  public void afficherConnexionEchouee() {
    System.out.println("Tentative de connexion échouée !");
  }

  @Override
  public boolean afficherDialogueDeconnexion () {
    // String reponseUtilisateur = "non";
    System.out.println("Êtes-vous bien sûr de vouloir vous déconnecter ? (taper \"oui\" le cas échéant)");
    return this.leScanner.nextLine().equalsIgnoreCase("oui");
  }

  @Override
  public void afficherDeconnexionReussie(Utilisateur u) {
    System.out.println("Déconnexion effectuée avec succès !");
  }

  @Override
  public void afficherDeconnexionEchouee() {
    System.out.println("Tentative de déconnexion échouée !");
  }

  @Override
  public String afficherDialogueAffichageFilm() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez l'ID du film d'ont vous voulez les informations: ");
    String Id = scanner.nextLine();

    return Id;
  }

  @Override
  public void afficherFilm(Film f) {
    System.out.println("Film: \n  -" + f.getTitre() + "\n  -annee: " + f.getAnnee() + "\n  -Description: " + f.getDesc()
        + "\n  -Genre principal:" + f.getGenre());

  }

  @Override
  public void afficherFilms(Set<Film> films) {
    for (Film f : films) {
      System.out.println("[Titre: " + f.getTitre() + ", annee: " + f.getAnnee() + ", Description: " + f.getDesc()
          + ", Genre principal:" + f.getGenre() + "]");
    }
  }

  @Override
  public void afficherSalles(Set<Salle> salles) {
    for (Salle s : salles) {
      System.out.println("Salle d'ID " + s.getId() + ":");
      System.out.println("Numéro : " + s.getNumero());
      System.out.println("Capacité : " + s.getCapacite());
    }
  }

  @Override
  public String afficherDialogueAffichageSeance() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez l'Identifiant de la seance dont vous voulez les informations: ");
    String idSeance = scanner.nextLine();

    return idSeance;
  }

  public String afficherDialogueSeancesUnFilm() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez l'ID du film dont vous voulez voir les prochaines séances ");
    String id = scanner.nextLine();
    System.out.println("Voici les prochaine seance du Film d'ID: " + id + ":");

    return id;
  }

  @Override
  public void afficherSeance(Seance s) {
    System.out.println("\nSeance : \n  -IdSeance:" + s.getId() + "\n  -Film" + s.getFilm().getTitre() + "\n  -IdFilm: "
        + s.getFilm().getId() + "\n  -Date: " + s.getDate() + "\n  -Salle: "
        + s.getSalle().toString() + "\n  -Type Seance:" + s.getTypeSeance() + ".\n");
  }

  public void afficherSeances(ArrayList<Seance> seances) {
    Set<Salle> sallesSeance = new HashSet<Salle>();
    for (Seance s: seances) {
      // if ();
    }
  }

  @Override
  public String afficherDialogueAffichageSeancesUneSalle() {
    return "";
  }

  @Override
  public void afficherSeancesUneSalle(Set<Seance> seances) {
  }

  @Override
  public void afficherSeancesPlusieursSalles(Set<Seance> seances) {
  }

  @Override
  public ArrayList<String> afficherDialogueReservationSeance() {
    ArrayList<String> res = new ArrayList<>();
    System.out.println("Pour faire votre réservation, veuillez entrer dans l'ordre (futures options à rajouter plus tard):");
    System.out.println("- ID de la séance à réserver");
    res.add(this.leScanner.nextLine());
    return res;
  }

  public void afficherReservationReussie(Reservation r) {
    System.out.println("Réservation faites avec succès !");
    for (Billet b: r.getBillets()) {
      System.out.println("Séance de " + b.getSeance().getDate());
      System.out.println("Dans la salle numéro " + b.getSeance().getSalle().getNumero());
      System.out.println("Film : " + b.getSeance().getFilm() + "\n------------------");
    }
  }

  @Override
  public void afficherReservationEchouee() {
    System.out.println("Réservation échouée !");
  }

  public void afficherReservation(Reservation r) {
    System.out.println("Récapitulatif de la réservation d'ID " + r.getId() + " :");
    int i = 1;
    for (Billet b: r.getBillets()) {
      System.out.println("Billet n°" + i + " (ID : " + b.getId() + ") :");
      System.out.println("Séance de " + b.getSeance().getDate());
      System.out.println("Dans la salle numéro " + b.getSeance().getSalle().getNumero());
      System.out.println("Film : " + b.getSeance().getFilm() + "\n------------------");
      i += 1;
    }
  }

  @Override
  public ArrayList<String> afficherDialogueCreationUtilisateur() {
    return new ArrayList<>();
  }

  // public void afficherCreationUtilisateurReussie(Utilisateur u) {}

  @Override
  public void afficherCreationUtilisateurEchouee() {
  }

  @Override
  public void afficherDialogueSuppressionUtilisateur() {
  }

  @Override
  public void afficherSuppressionUtilisateurReussie() {
  }

  @Override
  public void afficherSuppressionUtilisateurEchouee() {
  }

  public ArrayList<String> AfficherDialogueCreationFilm() {
    Scanner scanner = new Scanner(System.in);

    List<String> genresAutorises = Arrays.asList("Drame", "Comedie", "Horreur", "Action", "Thriller");

    String titre;
    do {
      System.out.print("Entrez le titre du film : ");
      titre = scanner.nextLine().trim();
      if (titre.isEmpty()) {
        System.out.println("⛔ Le titre ne peut pas être vide !");
      }
    } while (titre.isEmpty());

    String annee;
    do {
      System.out.print("Entrez l'année de sortie du film : ");
      annee = scanner.nextLine().trim();
      if (!annee.matches("\\d{4}")) {
        System.out.println("⛔ Veuillez entrer une année valide (ex : 2024).");
      }
    } while (!annee.matches("\\d{4}"));

    System.out.print("Entrez une description du film : ");
    String description = scanner.nextLine().trim();

    String genre;
    do {
      System.out.print("Entrez le genre principal (Drame, Comedie, Horreur, Action, Thriller) : ");
      genre = scanner.nextLine().trim();
      if (!genresAutorises.contains(genre)) {
        System.out.println("⛔ Genre invalide ! Veuillez choisir parmi : " + genresAutorises);
      }
    } while (!genresAutorises.contains(genre));

    ArrayList<String> Liste = new ArrayList<String>();
    Liste.add(titre);
    Liste.add(annee);
    Liste.add(description);
    Liste.add(genre);

    return Liste;

  }

  public void afficherCreationFilmReussie(Film f) {
    System.out.println("\n✅ Film Crée : \n  -" + f.getTitre() + "\n  -annee: " + f.getAnnee() + "\n  -Description: "
        + f.getDesc() + "\n  -Genre principal:" + f.getGenre() + ".\n");

  }

  public void afficherCreationFilmEchouer() {
    System.out.println("\n❌ Film non crée. \n");

  }

  public void afficherSuppressionFilmReussie(Film f) {
    System.out.println("✅ Film supprimé avec succès: " + f.getTitre() + ".\n");

  }

  public void afficherSuppressionFilmEchouer() {
    System.out.println("❌ Impossible de supprimer. \n");

  }

  public ArrayList<String> AfficherDialogueSuppressionFilm() {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez le titre du film à supprimer : ");
    String titre = scanner.nextLine();

    System.out.print("Entrez l'année du film à supprimer : ");
    String annee = scanner.nextLine();

    ArrayList<String> Liste = new ArrayList<String>();
    Liste.add(titre);
    Liste.add(annee);

    return Liste;
  }

  @Override
  public void afficherCreationSalleReussie(Salle s) {
    System.out.println("✅ Salle creer avec succès: \n  -Salle ID:" + s.getId() + "\n  -Capacité: " + s.getCapacite());

  }

  @Override
  public void afficherCreationSalleEchouee() {
    System.out.println("❌ Impossible de Creer la salle. \n");

  }

  @Override
  public ArrayList<String> afficherDialogueSuppressionSalle() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez l'ID de la salle à supprimer ");
    String id = scanner.nextLine();

    ArrayList<String> Liste = new ArrayList<String>();
    Liste.add(id);
    return Liste;
  }

  public void afficherSuppressionSalleReussie(Salle s) {
  }

  @Override
  public ArrayList<String> afficherDialogueCreationSeance() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez le film : ");
    String film = scanner.nextLine();

    String date;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate today = LocalDate.now(); // Date actuelle
    while (true) {
      System.out.print("Entrez la date (YYYY-MM-DD) : ");
      date = scanner.nextLine();
      try {
        LocalDate enteredDate = LocalDate.parse(date, dateFormatter);
        if (enteredDate.isBefore(today)) { // Vérifie si la date est dans le passé
          System.out.println("⛔ Erreur : La date ne peut pas être antérieure à aujourd'hui (" + today + ").");
        } else {
          break; // Sortie de la boucle si la date est valide et dans le futur
        }
      } catch (DateTimeParseException e) {
        System.out.println("⛔ Format invalide ! Veuillez entrer une date valide (ex: 2024-02-02).");
      }
    }

    // Vérification stricte de l'heure (HH:MM)
    String heure;
    DateTimeFormatter heureFormatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime enteredTime;

    while (true) {
      System.out.print("Entrez l'heure (HH:MM) : ");
      heure = scanner.nextLine();
      try {
        LocalDate enteredDate = LocalDate.parse(date, dateFormatter);
        enteredTime = LocalTime.parse(heure, heureFormatter);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime enteredDateTime = LocalDateTime.of(enteredDate, enteredTime);

        if (enteredDateTime.isBefore(now.plusHours(3))) { // Vérifie si l'heure est au moins 3h après maintenant
          System.out.println("⛔ Erreur : L'horaire doit être au moins 3 heures après l'heure actuelle ("
              + now.format(heureFormatter) + ").");
        } else {
          break; // Sortie de la boucle si l'heure est valide et respecte la condition
        }
      } catch (DateTimeParseException e) {
        System.out.println("⛔ Format invalide ! Veuillez entrer une heure valide (ex: 14:30).");
      }
    }

    System.out.print("Choissiez la salle: ");
    String salle = scanner.nextLine();

    System.out.print("Entrez le type de séance (IMAX, 4Dmax, 3D) : ");
    String typeStr = scanner.nextLine();

    ArrayList<String> Liste = new ArrayList<String>();
    Liste.add(film);
    Liste.add(date);
    Liste.add(heure);
    Liste.add(salle);
    Liste.add(typeStr);

    return Liste;
  }

  @Override
  public void afficherCreationSeanceReussie(Seance s) {
    System.out.println("\n✅ Seance Crée : \n  -ID: " + s.getId() + "\n  -Film: " + s.getFilm().getTitre()
        + "\n  -Date: " + s.getDate() + "\n  -Heure: " + s.getHeure() + "\n  -Salle: " + s.getSalle().toString()
        + "\n  -Type Seance:" + s.getTypeSeance() + ".\n");

  }

  @Override
  public void afficherCreationSeanceEchouee() {
    System.out.println("\n❌ Seance non crée.\n");

  }

  @Override
  public ArrayList<String> afficherDialogueSuppressionSeance() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez l'Identifiant de la seance à supprimer: ");
    String id = scanner.nextLine();

    ArrayList<String> Liste = new ArrayList<String>();
    Liste.add(id);
    return Liste;

  }

  public void afficherSuppressionSeanceReussie(Seance s) {
    System.out.println(
        "✅ Seance Supprimer : \n  -Film:" + s.getFilm().getTitre() + "\n  -Date: " + s.getDate() + "\n  -Heure: "
            + s.getHeure() + "\n  -Salle:" + s.getSalle().toString() + "\n  -Type Seance:" + s.getTypeSeance());

  }

  @Override
  public void afficherSuppressionSeanceEchouee() {
    System.out.println("❌ Seance non Supprimer.");

  }

  @Override
  public String afficherDialogueAffichageSeancesPlusieursSalles() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void afficherSuppressionFilmReussie() {
    // TODO Auto-generated method stub

  }

  @Override
  public void afficherSuppressionSalleReussie() {
    // TODO Auto-generated method stub

  }

  @Override
  public void afficherSuppressionSalleEchouee() {
    // TODO Auto-generated method stub

  }

  @Override
  public void afficherSuppressionSeanceReussie() {
    // TODO Auto-generated method stub

  }

  public void Option1() {
    this.controleur.GererCreationFilm();
  }

  public void Option2() {
    this.controleur.GererSuppressionFilm();
  }

  @Override
  public ArrayList<String> afficherDialogueCreationSalle() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Entrez le numero ID de la salle à creer: ");
    String id = scanner.nextLine();

    System.out.print("Entrez le nombre maximal de place pour la nouvelle salle : ");
    String nb = scanner.nextLine();

    ArrayList<String> l = new ArrayList<String>();
    l.add(id);
    l.add(nb);
    return l;
  }

  public void Option3() {
    this.controleur.GererAffichageFilms();
  }

  public void Option4() {
    this.controleur.GererAffichageFilm();
  }

  public void OptionCreerSeance() throws ParseException {
    this.controleur.GererCreationSeance();
  }

  public void OptionSupprimerSeance() {
    this.controleur.GererSuppressionSeance();
  }

  public void OptionCreerSalle() throws ParseException {
    this.controleur.GererCreationSalle();
  }

  public void OptionSupprimerSalle() {
    this.controleur.gererSuppressionSalle();
  }

  public void OptionAfficherSeance() {
    this.controleur.gererAffichageUneSeance();
  }

  public void OptionAfficherToutesSeance() {
    this.controleur.gererAffichageToutesSeances();
  }

  public void OptionAfficherSeancesFilm() {
    this.controleur.GererAffichageToutesSeancesUnFilm();
  }
}
