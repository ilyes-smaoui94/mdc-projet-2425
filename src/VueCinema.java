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

  private IControleurCinema controleur;
  // private ModeleCinema modele;
  private Scanner leScanner;

  public VueCinema(ControleurCinema controleur, IModeleCinema modele) {
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
    int choix = -1;
    do {
      System.out.println("\n=== Menu Manager ===");
      System.out.println("1. Créer utilisateur");
      System.out.println("2. Supprimer utilisateur");
      System.out.println("3. Déconnexion");
      System.out.println("4. Créer film");
      System.out.println("5. Supprimer film");
      System.out.println("6. Créer salle");
      System.out.println("7. Supprimer salle");
      System.out.println("8. Créer séance");
      System.out.println("9. Supprimer séance");
      System.out.print("Votre choix : ");

      try {
        choix = Integer.parseInt(this.leScanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Veuillez saisir un nombre valide.");
        continue;
      }

      switch (choix) {
        case 1:
          this.controleur.gererCreationUtilisateur();
          break;
        case 2:
          this.controleur.gererSuppressionUtilisateur();
          break;
        case 3:
          this.controleur.gererDeconnexion();
          break;
        case 4:
          this.controleur.gererCreationFilm();
          break;
        case 5:
          this.controleur.gererSuppressionFilm();
          break;
        case 6:
          this.controleur.gererCreationSalle();
          break;
        case 7:
          this.controleur.gererSuppressionSalle();
          break;
        case 8:
        try {
          this.controleur.gererCreationSeance();
        } catch (Exception e) {
        }
          break;
        case 9:
          this.controleur.gererSuppressionSeance();
          break;
        default:
          System.out.println("Choix invalide, veuillez réessayer.");
          break;
      }
    } while (choix != 3); // On quitte le menu lorsque la déconnexion est choisie.

  }

  @Override
  public ArrayList<String> afficherDialogueConnexion() {
    ArrayList<String> res = new ArrayList<>();
    System.out.println(
        "Pour lancer l'application, veuillez vous connecter, en entrant d'abord votre email, puis votre mot de passe :");
    String emailU = this.leScanner.nextLine();
    String mdpU = this.leScanner.nextLine();
    res.add(emailU);
    res.add(mdpU);
    return res;
  }

  @Override
  public void afficherConnexionReussie(Utilisateur u) {
    System.out.println("Connexion réussie !");
    System.out.println("(Utilisateur " + u.getEmail() + " connecté)");
  }

  @Override
  public void afficherConnexionEchouee() {
    System.out.println("Tentative de connexion échouée !");
  }

  @Override
  public boolean afficherDialogueDeconnexion() {
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
    // Scanner this.leScanner = new Scanner(System.in);

    System.out.print("Entrez l'ID du film d'ont vous voulez les informations: ");
    String Id = this.leScanner.nextLine();

    return Id;
  }

  @Override
  public void afficherFilm(Film f) {
    System.out.println("Film: \n  -" + f.getTitre() + "\n  -annee: " + f.getAnnee() + "\n  -Description: " + f.getDesc()
        + "\n  - Genres:");
    for (Genre g : f.getGenres()) {
      System.out.print(g + ", ");
    }

  }

  @Override
  public void afficherFilms(Set<Film> films) {
    for (Film f : films) {
      System.out.println("[Titre: " + f.getTitre() + ", annee: " + f.getAnnee() + ", Description: " + f.getDesc()
          + ", Genres :");
      for (Genre g : f.getGenres()) {
        System.out.print(g + ", ");
      }
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
    // Scanner this.leScanner = new Scanner(System.in);

    System.out.print("Entrez l'Identifiant de la seance dont vous voulez les informations: ");
    String idSeance = this.leScanner.nextLine();

    return idSeance;
  }

  public String afficherDialogueSeancesUnFilm() {
    // Scanner this.leScanner = new Scanner(System.in);

    System.out.print("Entrez l'ID du film dont vous voulez voir les prochaines séances ");
    String id = this.leScanner.nextLine();
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
    for (Seance s : seances) {
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
    System.out
        .println("Pour faire votre réservation, veuillez entrer dans l'ordre (futures options à rajouter plus tard):");
    System.out.println("- ID de la séance à réserver");
    res.add(this.leScanner.nextLine());
    return res;
  }

  public void afficherReservationReussie(Reservation r) {
    System.out.println("Réservation faites avec succès !");
    for (Billet b : r.getBillets()) {
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
    for (Billet b : r.getBillets()) {
      System.out.println("Billet n°" + i + " (ID : " + b.getId() + ") :");
      System.out.println("Séance de " + b.getSeance().getDate());
      System.out.println("Dans la salle numéro " + b.getSeance().getSalle().getNumero());
      System.out.println("Film : " + b.getSeance().getFilm() + "\n------------------");
      i += 1;
    }
  }

  @Override
  public ArrayList<String> afficherDialogueCreationUtilisateur() {
    ArrayList<String> infosUtilisateur = new ArrayList<>();
    System.out.println("Création d'un nouvel utilisateur.");

    System.out.print("Entrez votre email : ");
    String email = this.leScanner.nextLine();
    infosUtilisateur.add(email);

    System.out.print("Entrez votre mot de passe : ");
    String motDePasse = this.leScanner.nextLine();
    infosUtilisateur.add(motDePasse);

    // Vous pouvez ajouter d'autres informations si nécessaire (par exemple, le nom
    // ou le prénom)
    System.out.print("Entrez votre nom : ");
    String nom = this.leScanner.nextLine();
    infosUtilisateur.add(nom);

    return infosUtilisateur;
  }

  @Override
  public void afficherCreationUtilisateurReussie(Utilisateur u) {
    System.out.println("Création utilisateur réussie !");
    System.out.println("L'utilisateur " + u.getEmail() + " a été créé avec succès.");
  }

  @Override
  public void afficherCreationUtilisateurEchouee() {
    System.out.println("Échec de la création de l'utilisateur.");
  }

  @Override
  public void afficherDialogueSuppressionUtilisateur() {
    // Dans ce cas, la méthode ne retourne pas les informations saisies.
    // Vous pouvez soit stocker l'information dans un attribut, soit appeler
    // directement le contrôleur.
    System.out.println("Suppression d'un utilisateur.");
    System.out.print("Entrez l'email de l'utilisateur à supprimer : ");
    String email = this.leScanner.nextLine();

    // Ici, vous pouvez par exemple transmettre l'email saisi au contrôleur
    // ou le stocker dans un attribut afin qu'il soit utilisé ensuite.
    // Exemple (si le contrôleur attend une action) :
    // this.controleur.GererSuppressionUtilisateur(email);

    // Pour cet exemple, nous affichons simplement une confirmation de la saisie :
    System.out.println("Vous avez demandé la suppression de l'utilisateur : " + email);
  }

  @Override
  public void afficherSuppressionUtilisateurReussie() {
    System.out.println("Suppression de l'utilisateur réussie !");
  }

  @Override
  public void afficherSuppressionUtilisateurEchouee() {
    System.out.println("Échec de la suppression de l'utilisateur.");
  }

  // @Override
  // public ArrayList<String> afficherDialogueCreationUtilisateur() {
  // return new ArrayList<>();
  // }

  // public void afficherCreationUtilisateurReussie(Utilisateur u) {}

  // @Override
  // public void afficherCreationUtilisateurEchouee() {
  // }

  // @Override
  // public void afficherDialogueSuppressionUtilisateur() {
  // }

  // @Override
  // public void afficherSuppressionUtilisateurReussie() {
  // }

  // @Override
  // public void afficherSuppressionUtilisateurEchouee() {
  // }

  public ArrayList<String> AfficherDialogueCreationFilm() {
    // Scanner this.leScanner = new Scanner(System.in);

    List<String> genresAutorises = Arrays.asList("Drame", "Comedie", "Horreur", "Action", "Thriller");

    String titre;
    do {
      System.out.print("Entrez le titre du film : ");
      titre = this.leScanner.nextLine().trim();
      if (titre.isEmpty()) {
        System.out.println("⛔ Le titre ne peut pas être vide !");
      }
    } while (titre.isEmpty());

    String annee;
    do {
      System.out.print("Entrez l'année de sortie du film : ");
      annee = this.leScanner.nextLine().trim();
      if (!annee.matches("\\d{4}")) {
        System.out.println("⛔ Veuillez entrer une année valide (ex : 2024).");
      }
    } while (!annee.matches("\\d{4}"));

    System.out.print("Entrez une description du film : ");
    String description = this.leScanner.nextLine().trim();

    String genre;
    do {
      System.out.print("Entrez le genre principal (Drame, Comedie, Horreur, Action, Thriller) : ");
      genre = this.leScanner.nextLine().trim();
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
        + f.getDesc() + "\n  -Genre principal:");
        for (Genre g: f.getGenres()) {
          System.out.print(g + ", ");
        }

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

    // Scanner this.leScanner = new Scanner(System.in);

    System.out.print("Entrez le titre du film à supprimer : ");
    String titre = this.leScanner.nextLine();

    System.out.print("Entrez l'année du film à supprimer : ");
    String annee = this.leScanner.nextLine();

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
    // Scanner this.leScanner = new Scanner(System.in);

    System.out.print("Entrez l'ID de la salle à supprimer ");
    String id = this.leScanner.nextLine();

    ArrayList<String> Liste = new ArrayList<String>();
    Liste.add(id);
    return Liste;
  }

  public void afficherSuppressionSalleReussie(Salle s) {
  }

  @Override
  public ArrayList<String> afficherDialogueCreationSeance() {
    // Scanner this.leScanner = new Scanner(System.in);

    System.out.print("Entrez le film : ");
    String film = this.leScanner.nextLine();

    String date;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate today = LocalDate.now(); // Date actuelle
    while (true) {
      System.out.print("Entrez la date (YYYY-MM-DD) : ");
      date = this.leScanner.nextLine();
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
      heure = this.leScanner.nextLine();
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
    String salle = this.leScanner.nextLine();

    System.out.print("Entrez le type de séance (IMAX, 4Dmax, 3D) : ");
    String typeStr = this.leScanner.nextLine();

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
        + "\n  -Date: " + s.getDate() + "\n  -Salle: " + s.getSalle().toString()
        + "\n  -Type Seance:" + s.getTypeSeance() + ".\n");

  }

  @Override
  public void afficherCreationSeanceEchouee() {
    System.out.println("\n❌ Seance non crée.\n");

  }

  @Override
  public ArrayList<String> afficherDialogueSuppressionSeance() {
    // Scanner this.leScanner = new Scanner(System.in);

    System.out.print("Entrez l'Identifiant de la seance à supprimer: ");
    String id = this.leScanner.nextLine();

    ArrayList<String> Liste = new ArrayList<String>();
    Liste.add(id);
    return Liste;

  }

  public void afficherSuppressionSeanceReussie(Seance s) {
    System.out.println(
        "✅ Seance Supprimer : \n  -Film:" + s.getFilm().getTitre() + "\n  -Date: " + s.getDate() +
        "\n  -Salle:" + s.getSalle().toString() + "\n  -Type Seance:" + s.getTypeSeance());

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
    this.controleur.gererCreationFilm();
  }

  public void Option2() {
    this.controleur.gererSuppressionFilm();
  }

  @Override
  public ArrayList<String> afficherDialogueCreationSalle() {
    // Scanner this.leScanner = new Scanner(System.in);

    System.out.print("Entrez le numero ID de la salle à creer: ");
    String id = this.leScanner.nextLine();

    System.out.print("Entrez le nombre maximal de place pour la nouvelle salle : ");
    String nb = this.leScanner.nextLine();

    ArrayList<String> l = new ArrayList<String>();
    l.add(id);
    l.add(nb);
    return l;
  }

  public void Option3() {
    this.controleur.gererAffichageFilms();
  }

  public void Option4() {
    this.controleur.gererAffichageFilm();
  }

  public void OptionCreerSeance() throws ParseException {
    this.controleur.gererCreationSeance();
  }

  public void OptionSupprimerSeance() {
    this.controleur.gererSuppressionSeance();
  }

  public void OptionCreerSalle() throws ParseException {
    this.controleur.gererCreationSalle();
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
    this.controleur.gererAffichageSeancesUnFilm();
  }
}
