
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ID du film d'ont vous voulez les informations: ");
	    String Id = scanner.nextLine();

        return Id;
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
    public void TentativeAjoutFilm(String titre, int annee, String description, Genre genrefilm) throws ParseException {
		this.controleur.GererCreationFilm();
	}
	
	public void afficherCreationFilmReussie(Film f){
		 System.out.println("\n✅ Film Crée : \n  -" +f.getTitre()  + "\n  -annee: " + f.getAnnee() + "\n  -Description: " + f.getDesc() + "\n  -Genre principal:"+ f.getGenre());

	}
	
	public void afficherCreationFilmEchouer(){
		 System.out.println("\n❌ Film non crée :");

	}

    
    public void afficherSuppresionFilmReussie(Film f){
		 System.out.println("✅ Film supprimé avec succès: " +f.getTitre());

	}
	
	public void afficherSuppresionFilmEchouer(){
		 System.out.println("❌ Impossible de supprimer :");

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
    public void afficherCreationSalleReussie(Salle s) {}

    @Override
    public void afficherCreationSalleEchouee() {}

    @Override
    public ArrayList<String> afficherDialogueSuppressionSalle() {
        return new ArrayList<>();
    }

    
   public void afficherSuppressionSalleReussie(Salle s) {}

    @Override
    public void afficherSuppresionSalleEchouee() {}

    @Override
    public ArrayList<String> afficherDialogueCreationSeance() {
        return new ArrayList<>();
    }

    @Override
    public void afficherCreationSeanceReussie(Seance s) {}

    @Override
    public void afficherCreationSeanceEchouee() {}

    @Override
    public ArrayList<String> afficherDialogueSuppressionSeance() {
        return new ArrayList<>();
    }

    
    public void afficherSuppressionSeanceReussie(Seance s) {}

    @Override
    public void afficherSuppressionSeanceEchouee() {}

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
		// TODO Auto-generated method stub
		return null;
	}

    public void Option3() {
		this.controleur.GererAffichageFilms();
	}
	
	public void Option4() {
		this.controleur.GererAffichageFilm();
	}



	
	
	
	
}



