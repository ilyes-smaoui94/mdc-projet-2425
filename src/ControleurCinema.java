import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class ControleurCinema implements IControleurCinema {
	
	    private ModeleCinema modele;
		private VueCinema vue;


	    public ControleurCinema( ModeleCinema modele) {
	        
	        this.modele = modele;
	    }
		public void setVue(VueCinema vue) {
	    	this.vue=vue;
	    }

		public Film chercherFilmParID(HashSet<Film> listeFilms, int id) {
	        for (Film film : listeFilms) {
	            if (film.getId() == id) { // Vérification basée sur l'ID
	                return film; // 🎬 Film déjà présent !
	            }
	        }
	        return null; // ❌ Film non trouvé
	    }


	     
	        public void GererCreationFilm() {
	       
	        
	        	ArrayList<String> Liste= this.vue.AfficherDialogueCreationFilm();
				String titre= Liste.get(0);
				int annee= Integer.parseInt(Liste.get(1));
				String descritpion= Liste.get(2);
				String genre= Liste.get(3);

				
				 Genre MainGenre = null;
			        
			        if (genre.equalsIgnoreCase("Drame")) {
			        	MainGenre = Genre.Drame;
				    } else if (genre.equalsIgnoreCase("Comedie")) {
				    	MainGenre = Genre.Comedie;
				    } else if (genre.equalsIgnoreCase("Horreur")) {
				    	MainGenre = Genre.Horreur;
				    } else if (genre.equalsIgnoreCase("Action")) {
				    	MainGenre = Genre.Action;
				    } else if (genre.equalsIgnoreCase("Thriller")) {
				    	MainGenre = Genre.Thriller;
				    }
			        

			        // Création de la séance
					Film film= new Film(titre,annee,descritpion,MainGenre);
					 if (film !=null) {
			               this.vue.afficherCreationFilmReussie(film);
					       this.modele.getListeFilm().add(film);

			            } else {
			            	this.vue.afficherCreationFilmEchouer();
			            	System.out.println(titre);
			            }
			        // Ajout de la séance au planning
			
	        }
	        
	        public void GererSuppressionFilm() {
				ArrayList<String> Liste;

				Liste = this.vue.AfficherDialogueSuppressionFilm();
				String titre= Liste.get(0);
				int annee= Integer.parseInt(Liste.get(1));
				
				Film f= this.chercherFilmParNom(this.modele.getListeFilm(), titre);
				System.out.println("*********************");
				System.out.println(f.getTitre());
				System.out.println(f.getId());


				boolean supprime = this.modele.getListeFilm().remove(f);

	 			
				if (supprime) {
					this.vue.afficherSuppresionFilmReussie(f);
				} else {
					this.vue.afficherSuppresionFilmEchouer();				}
	        	
	        }

		public void GererAffichageFilms() {
	    	HashSet<Film> films= this.modele.getListeFilm();
	    	for (Film f : films) {
				System.out.println("[ID: "+f.getId()+ ", titre: " +f.getTitre()  + ", annee: " + f.getAnnee() + ", Description: " + f.getDesc() + ", Genre principal:"+ f.getGenre()+ "]");
            }
	    }

		public void GererAffichageFilm() {
			String id = vue.afficherDialogueAffichageFilm();
			int Id =Integer.parseInt(id);

			Film film= chercherFilmParID(modele.getListeFilm(),Id);
			this.vue.afficherFilm(film);
			
		}
	    public Film chercherFilmParNom(HashSet<Film> listeFilms,String titre){

	    	for (Film film : listeFilms) {
	    		if (film.getTitre().equalsIgnoreCase(titre)) { // Vérification basée sur l'ID
	    			return film; // 🎬 Film déjà présent !
	    		}
        }
        return null; // ❌ Film non trouvé
    }	

}
