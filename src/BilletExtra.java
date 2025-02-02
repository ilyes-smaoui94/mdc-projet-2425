public abstract class BilletExtra extends Billet {
	
	private Billet billetBase;

	public BilletExtra(Billet billetBase) {
		super();
		this.billetBase = billetBase;
	}
	
	public abstract double getPrix();

	public Billet getBilletBase() {
		return this.billetBase;
	}
}
