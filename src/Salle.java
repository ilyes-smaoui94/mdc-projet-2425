package app_cinema;

public class Salle {
	private int numero;
	private int capacite;
	
	public Salle(int numero, int capacite) {
		this.numero = numero;
		this.capacite = capacite;
		
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
