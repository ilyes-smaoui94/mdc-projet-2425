import java.util.ArrayList;


public class Film {
	
	private static int idFilm = 1;
	private int id; // ID unique pour chaque film
    private String titre;
    private int annee;
    private String description;
    private Genre genre;

   public Film (String t, int a, String d) {
	 this.id = idFilm++;
	 this.titre = t;
	 this.annee = a;
	 this.description = d;
	 this.genre = null;
   }
   public Film (String t, int a, String d, Genre gf) {
	 this.id = idFilm++;
	 this.titre = t;
	 this.annee = a;
	 this.description = d;
	 this.genre=gf;
   }

	  public String getTitre () {
	    return this.titre;
	  }
	  public void setTitre (String t) {
	    this.titre = t;
	  }
	  public int getAnnee () {
	    return this.annee;
	  }
	  public void setAnnee (int a) {
	    this.annee = a;
	  }
	  public String getDesc () {
	    return this.description;
	  }
	  
	  // ************* ilies
	public int getId() {
		 return this.id;
	}
	public Genre getGenre() {
		return genre;
	}
	  
	}