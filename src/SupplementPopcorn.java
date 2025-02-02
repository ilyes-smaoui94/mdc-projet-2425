public class SupplementPopcorn extends BilletExtra {

	public SupplementPopcorn(Seance seanceBillet, Billet billetBase) {
		super(seanceBillet, billetBase);
	}
	
	public double getPrix() {
		// TODO Auto-generated method stub
		double p = this.getBilletBase().getPrix();
		return p + 6.0;
	}
}
