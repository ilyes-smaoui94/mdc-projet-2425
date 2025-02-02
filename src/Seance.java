import java.util.Date;

public class Seance {
	private static int nextAvailableId = 1;
	private int id;
	private Salle salleSeance;
	private Film filmSeance;
	private TypeSeance typeSeance; 
	private Date date;
	private int placesRestantes;
	
	public Seance(Salle salleSeance, Film f, Date date) {
		this.id = this.getNextAvailableId();
		this.salleSeance = salleSeance;
		this.filmSeance = f;
		this.date = date;
		this.placesRestantes = salleSeance.getCapacite();
	}
	
	// public Seance() {}

	protected static int getNextAvailableId () {
		int nextID = Seance.nextAvailableId;
		Seance.nextAvailableId += 1;
		return nextID;
	}

	public int getId() {
		return this.id;
	}

	public Salle getSalle () {
		return this.salleSeance;
	}

	public void setSalle(Salle salleSeance) {
		this.salleSeance = salleSeance;
	}

	public Film getFilm () {
		return this.filmSeance;
	}

	public void setFilm (Film f) {
		this.filmSeance = f;
	}

	public Date getDate () {
		return this.date;
	}

	public void setDate (Date date) {
		this.date = date;
	}

	public int getPlacesRestantes () {
		return this.placesRestantes;
	}

	public void setPlacesRestantes (int placesRestantes) {
		this.placesRestantes = placesRestantes;
	}

	public TypeSeance getTypeSeance() {
		return this.typeSeance;
	}

	public void setTypeSeance(TypeSeance typeSeance) {
		this.typeSeance = typeSeance;
	}
}
