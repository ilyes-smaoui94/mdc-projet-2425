package app_cinema;

public class Seance {
	private Salle salle;
	private String date;
	private String heure;
	private int nb_place_dispo;
	private TypeSeance typeSeance; 
	
	public Seance(Salle salle, String date,String heure, int nb_place_dispo ) {
		this.salle=salle;
		this.date=date;
		this.heure=heure;
		this.nb_place_dispo=nb_place_dispo;
	}
	
	public Seance() {}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public int getNb_place_dispo() {
		return nb_place_dispo;
	}

	public void setNb_place_dispo(int nb_place_dispo) {
		this.nb_place_dispo = nb_place_dispo;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public TypeSeance getTypeSeance() {
		return typeSeance;
	}

	public void setTypeSeance(TypeSeance typeSeance) {
		this.typeSeance = typeSeance;
	}

	


}
