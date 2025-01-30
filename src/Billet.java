package app_cinema;

public abstract class Billet {
	private Seance seance;
	
	public Billet(Seance seance) {
		this.seance=seance;
	}
	public Billet() {
	}


	public Seance getSeance() {
		return seance;
	}
	public abstract double prix();
}
