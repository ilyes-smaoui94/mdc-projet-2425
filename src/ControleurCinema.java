import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class ControleurCinema implements IControleurCinema {
	
	    private ModeleCinema modele;
		private VueCinema vue;


	    public ControleurCinema( ModeleCinema modele) {
	        
	        this.modele = modele;
	    }
		public void setVue(VueCinema vue) {
	    	this.vue=vue;
	    }

		public Film ChercherFilmParID(HashSet<Film> listeFilms, int id) {
	        for (Film film : listeFilms) {
	            if (film.getId() == id) { // Vérification basée sur l'ID
	                return film; // 🎬 Film déjà présent !
	            }
	        }
	        return null; // ❌ Film non trouvé
	    }

		public Seance ChercherSeanceParID(ArrayList<Seance> l, int id) {
	        for (Seance seance : l) {
	            if (seance.getId() == id) { // Vérification basée sur l'ID
	                return seance; // 🎬 Film déjà présent !
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
			        

			        if (genre == null) {   
			            System.out.println("Erreur : Données genre invalides.");
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
					this.vue.afficherSuppressionFilmReussie(f);
				} else {
					this.vue.afficherSuppressionFilmEchouer();				}
	        	
	        }

		public void GererAffichageFilms() {
	    	HashSet<Film> films= this.modele.getListeFilm();
	    	for (Film f : films) {
				System.out.println("[Titre: " +f.getTitre()  + ", annee: " + f.getAnnee() + ", Description: " + f.getDesc() + ", Genre principal:"+ f.getGenre()+ "]");
            }
	    }

		public void GererAffichageFilm(Film film) {
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
	
	public  Salle chercherSalleParId(ArrayList<Salle> salles, int num) {
		for (Salle salle : salles) {
			if (salle.getId()==num) {
				return salle;  
			}
		}
		return null;
	}

	public void GererCreationSeance() throws ParseException {

	        	ArrayList<String> Liste =this.vue.afficherDialogueCreationSeance();

	        	String f= Liste.get(0);
	        	Film film =this.chercherFilmParNom(this.modele.getListeFilm(), f);
	        	String d= Liste.get(1);
	        	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    	Date date= formatter.parse(d);
		    	
				String heure= Liste.get(2);
				
				int salle= Integer.parseInt(Liste.get(3));
				
				ArrayList<Salle> listeSalle=this.modele.getListeSalle();
		    	Salle s =chercherSalleParId(listeSalle,salle);
		    	
			    String  typeStr=  Liste.get(4);
			    TypeSeance typeSeance = null;

			    if (typeStr.equalsIgnoreCase("IMAX")) {
			        typeSeance = TypeSeance.IMAX;
			    } else if (typeStr.equalsIgnoreCase("4Dmax")) {
			        typeSeance = TypeSeance.DMAX_4D;
			    } else if (typeStr.equalsIgnoreCase("3D")) {
			        typeSeance = TypeSeance._3D;
			    }
			    
			 // Création de la séance
				Seance seance= new Seance(film,date,heure,s,typeSeance);
				 if (seance !=null) {
		               this.vue.afficherCreationSeanceReussie(seance);
					   this.modele.getListeSeance().add(seance);

		            } else {
		            	this.vue.afficherCreationSeanceEchouee();
		            }
			    
				
			}
			public static boolean supprimerSeanceParId(ArrayList<Seance> listeSeances, int id) {
				Iterator<Seance> iterator = listeSeances.iterator();
		
				while (iterator.hasNext()) {
					Seance seance = iterator.next();
					if (seance.getId() == id) { // Vérifie si l'ID correspond
						iterator.remove(); // Supprime la séance en toute sécurité
						System.out.println("✅ Séance avec ID " + id + " supprimée avec succès.");
						return true; // Retourne true si la suppression a eu lieu
					}
				}
		
				System.out.println("⛔ Aucune séance trouvée avec l'ID " + id + ".");
				return false; // Retourne false si aucune séance n'a été trouvée
			}

			public void GererSuppressionSeance(){
				ArrayList<String> Liste;

				Liste = this.vue.afficherDialogueSuppressionSeance();
				int id= Integer.parseInt(Liste.get(0));
				Seance s= ChercherSeanceParID(this.modele.getListeSeance(), id);
				boolean supprime = supprimerSeanceParId(this.modele.getListeSeance(),id);

	 			
				if (supprime) {
					this.vue.afficherSuppressionSeanceReussie(s);
				} else {
					this.vue.afficherSuppressionSeanceEchouee();				}
	        	
	        }

}
