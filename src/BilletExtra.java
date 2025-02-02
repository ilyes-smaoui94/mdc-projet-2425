public abstract class BilletExtra extends Billet {
	
	private Billet billetBase;

	public BilletExtra(Seance seanceBillet, Billet billetBase) {
		super(seanceBillet);
		this.billetBase = billetBase;
	}
	
	public abstract double getPrix();

	public Billet getBilletBase() {
		return this.billetBase;
	}
}
