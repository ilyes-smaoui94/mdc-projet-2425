import java.util.Set;
import java.util.HashSet;
import java.util.Date;

public class Film {
	private int dureeMin = 30;
	private static int nextAvailableId = 1;
	private int id;
	private String titre;
	private int annee;
	private String description;
	private int duree;
	private Set<Genre> genres;

	public Film (String t, int a, String d, int duree) {
		this.id = this.getNextAvailableId();
		this.titre = t;
		this.annee = a;
		this.description = d;
		this.duree = duree >= dureeMin ? duree : dureeMin;
		this.genres = new HashSet<Genre>();
	}
	public Film (String t, int a, String d, int duree, Set<Genre> g) {
		this.id = this.getNextAvailableId();
		this.titre = t;
		this.annee = a;
		this.description = d;
		this.duree = duree >= dureeMin ? duree : dureeMin;
		this.genres = g != null ? g : new HashSet<Genre>();
	}

	protected int getNextAvailableId () {
		int nextId = Film.nextAvailableId;
		Film.nextAvailableId += 1;
		return nextId;
	}
	
	public int getId () {
		return this.id;
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
	public void setDesc (String d) {
		this.description = d;
	}
	public int getDuree () {
		return this.duree;
	}
	public void setDuree (int duree) {
		this.duree = duree >= dureeMin ? duree : dureeMin;
	}
	public void addGenre (Genre g) {
		this.genres.add(g);
	}
	public void removeGenre (Genre g) {
		this.genres.remove(g);
	}
	public void setGenres (Set<Genre> g) {
		this.genres = g != null ? g : new HashSet<Genre>();
	}
}