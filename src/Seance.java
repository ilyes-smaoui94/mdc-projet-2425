import java.util.Date;

public class Seance {
	private static int id = 1;
	private Film film;
	private Salle salle;
	private Date date;
	private String heure;
	private int nb_place_dispo;
	private TypeSeance typeSeance; 
	
	public Seance(Film film, Date date,String heure,Salle salle,TypeSeance typeSeance ) {
		this.id = id++;
		this.film=film;
		this.salle=salle;
		this.date=date;
		this.heure=heure;
		this.typeSeance=typeSeance;
		this.nb_place_dispo=nb_place_dispo;
	}
	
	public Seance() {}


	public int getId(){
		return this.id;
	}
	public Film getFilm(){
		return this.film;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
