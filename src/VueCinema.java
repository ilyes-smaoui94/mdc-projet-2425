
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class VueCinema implements IVueManager, IVueUtilisateur, IVueClient {
 
	private ControleurCinema controleur;
	private ModeleCinema model;
	
    public VueCinema(ControleurCinema controleur,ModeleCinema model) {
    	this.controleur=controleur;
        this.model = model;
    }

   

    public void afficherMenuClient() {
        // Implémentation à ajouter
    }

    
   // public void afficherMenuManager() {}
        // Implémentation à ajouter
    

    @Override
    public ArrayList<String> afficherDialogueConnexion() {
        return new ArrayList<>();
    }

    
    //public void afficherConnexionReussie(Utilisateur u) {}

    @Override
    public void afficherConnexionEchouee() {}

    
    //public ArrayList afficherDialogueDeconnexion() {}

    
    //public void afficherDeconnexionReussie(Utilisateur u) {}

    @Override
    public void afficherDeconnexionEchouee() {}

    @Override
    public String afficherDialogueAffichageFilm() {
        return "";
    }

    @Override
    public void afficherFilm(Film f) {
        System.out.println("Film: \n  -" +f.getTitre()  + "\n  -annee: " + f.getAnnee() + "\n  -Description: " + f.getDesc() + "\n  -Genre principal:"+ f.getGenre());

    }

    @Override
    public void afficherFilms(Set<Film> films) {
		for (Film f : films) {
			 System.out.println("[Titre: " +f.getTitre()  + ", annee: " + f.getAnnee() + ", Description: " + f.getDesc() + ", Genre principal:"+ f.getGenre()+ "]");
	    }
    }

    @Override
    public String afficherDialogueAffichageSalle() {
        return "";
    }

    @Override
    public void afficherSalle(Salle s) {}

    @Override
    public void afficherSalles(Set<Salle> salles) {}

    @Override
    public String afficherDialogueAffichageSeance() {
        return "";
    }

    @Override
    public void afficherSeance(Seance s) {}

    @Override
    public String afficherDialogueAffichageSeancesUneSalle() {
        return "";
    }

    @Override
    public void afficherSeancesUneSalle(Set<Seance> seances) {}

    @Override
    public void afficherSeancesPlusieursSalles(Set<Seance> seances) {}

    @Override
    public ArrayList<String> afficherDialogueReservationSeance() {
        return new ArrayList<>();
    }

    
    //public void afficherReservationReussie(Reservation r) {}

    @Override
    public void afficherReservationEchouee() {}

    
    //public void afficherReservation(Reservation r) {}

    @Override
    public ArrayList<String> afficherDialogueCreationUtilisateur() {
        return new ArrayList<>();
    }

    
    //public void afficherCreationUtilisateurReussie(Utilisateur u) {}

    @Override
    public void afficherCreationUtilisateurEchouee() {}

    @Override
    public void afficherDialogueSuppressionUtilisateur() {}

    @Override
    public void afficherSuppressionUtilisateurReussie() {}

    @Override
    public void afficherSuppressionUtilisateurEchouee() {}
    
    

    public ArrayList<String> AfficherDialogueCreationFilm(){  
		Scanner scanner = new Scanner(System.in);

	    System.out.print("Entrez le titre du film : ");
	    String titre = scanner.nextLine();

	    System.out.print("Entrez l'année de sortie du film : ");
	    String annee = scanner.nextLine();

	    System.out.print("Entrez une description du film: ");
	    String description = scanner.nextLine();

	    System.out.print("Entrez le genre principal (Drame, Comedie, Horreur, Action, Thriller): ");
	    String genre = scanner.nextLine();

	   
        
        ArrayList<String> Liste = new ArrayList<String>();
        Liste.add(titre);
        Liste.add(annee);
        Liste.add(description);
        Liste.add(genre);

        return Liste;
	   
    }
	
	public void afficherCreationFilmReussie(Film f){
		 System.out.println("\n✅ Film Crée : \n  -" +f.getTitre()  + "\n  -annee: " + f.getAnnee() + "\n  -Description: " + f.getDesc() + "\n  -Genre principal:"+ f.getGenre()+".\n");

	}
	
	public void afficherCreationFilmEchouer(){
		 System.out.println("\n❌ Film non crée. \n");

	}

    
    public void afficherSuppressionFilmReussie(Film f){
		 System.out.println("✅ Film supprimé avec succès: " +f.getTitre()+ ".\n");

	}
	
	public void afficherSuppressionFilmEchouer(){
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
        System.out.println("✅ Salle creer avec succès: \n  -Salle ID:" +s.getId()+ "\n  -Capacité: " +s.getCapacite());

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

    
   public void afficherSuppressionSalleReussie(Salle s) {}

    
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
        System.out.println("\n✅ Seance Crée : \n" +s.getFilm().getTitre()  + "\nDate: " + s.getDate() + "\nHeure: " + s.getHeure() + "\nSalle: "+ s.getSalle().toString() + "\nType Seance:"+ s.getTypeSeance()+ ".\n");

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
        System.out.println("✅ Seance Supprimer : \n  -Film:" +s.getFilm().getTitre()  + "\n  -Date: " + s.getDate() + "\n  -Heure: " + s.getHeure() + "\n  -Salle:"+ s.getSalle().toString() + "\n  -Type Seance:"+ s.getTypeSeance());

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

	@Override
	public ArrayList<String> afficherDialogueDeconnexion() {
		// TODO Auto-generated method stub
		return null;
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


		ArrayList<String> l= new ArrayList<String>();
        l.add(id);
        l.add(nb);
        return l;
	}

    public void Option3() {
		this.controleur.GererAffichageFilms();
	}
	
	public void Option4(Film f) {
		this.controleur.GererAffichageFilm(f);
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



	
	
	
	
}



