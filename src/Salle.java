public class Salle {
	private static int nextAvailableId = 1;
	private int id;
	private int numero;
	private int capacite;
	
	public Salle(int numero, int capacite) {
		this.id = Salle.getNextAvailableId();
		this.numero = numero;
		this.capacite = capacite;
		
	}

	protected static int getNextAvailableId () {
		int nextID = Salle.nextAvailableId;
		Salle.nextAvailableId += 1;
		return nextID;
	}

	public int getId () {
		return this.id;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
}
