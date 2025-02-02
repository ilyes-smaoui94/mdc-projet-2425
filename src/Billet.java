public abstract class Billet {
	private static int nextAvailableId = 1;
	private int id;
	private Seance seanceBillet;
	
	public Billet(Seance seanceBillet) {
		this.seanceBillet = seanceBillet;
		this.id = this.getNextAvailableId();
	}

	protected static int getNextAvailableId () {
		int nextID = nextAvailableId;
		Billet.nextAvailableId += 1;
		return nextID;
	}

	public abstract double getPrix();

	public int getId () {
		return this.id;
	}

	public Seance getSeance() {
		return this.seanceBillet;
	}
}
