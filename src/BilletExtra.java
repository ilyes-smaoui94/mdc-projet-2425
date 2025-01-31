public abstract class BilletExtra extends Billet {
	
	private Billet monBillet;

	public BilletExtra( Billet monBillet) {
		super();
		this.monBillet = monBillet;		
	}
	
	public abstract double prix();

	public Billet getMonBillet() {
		return monBillet;
	}
}
