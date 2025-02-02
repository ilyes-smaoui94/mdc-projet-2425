public abstract class Billet {
	private static int nextAvailableId = 1;
	private int id;
	private Seance seanceBillet;
	
	public Billet(Seance seanceBillet) {
		this.seanceBillet = seanceBillet;
		this.id = this.getNextAvailableId();
	}

	public int getNextAvailableId () {
		int nextId = nextAvailableId;
		Film.nextAvailableId += 1;
		return nextID;
	}

	public abstract double getPrix();

	public Seance getSeance() {
		return this.seanceBillet;
	}
}
