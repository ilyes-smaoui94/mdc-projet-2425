package app_cinema;

import java.util.Set;
import java.util.HashSet;

public class Film {
	private static int nextAvailableId = 1;
	private int id;
	private String titre;
	private int annee;
	private String description;
	private Set<Genre> genres;

	public Film (String t, int a, String d) {
		this.id = this.getNextAvailableId();
		this.titre = t;
		this.annee = a;
		this.description = d;
		this.genres = new HashSet<Genre>();
	}
	public Film (String t, int a, String d, Set<Genre> g) {
		this.id = this.getNextAvailableId();
		this.titre = t;
		this.annee = a;
		this.description = d;
		this.genres = gf;
	}

	public int getNextAvailableId () {
		int nextId = Film.nextAvailableId;
		Film.nextAvailableId += 1;
		return nextId;
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
	public void addGenre (Genre g) {
		this.genres.add(g);
	}
	public void removeGenre (Genre g) {
		this.genres.remove(g);
	}
	public void setGenres (Set<Genres> g) {
		this.genres = g;
	}
}