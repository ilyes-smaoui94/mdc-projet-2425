package app_cinema;

public class Film {

	private String titre;
	private int annee;
	private String description;
	private GenreFilm genre;

	public Film (String t, int a, String d) {
		this.titre = t;
		this.annee = a;
		this.description = d;
		this.genre = new GenreFilm();
	}
	public Film (String t, int a, String d, GenreFilm gf) {
		this.titre = t;
		this.annee = a;
		this.description = d;
		this.genre = gf;
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
	
}