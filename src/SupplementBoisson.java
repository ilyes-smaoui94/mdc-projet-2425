public class SupplementBoisson extends BilletExtra {

	public SupplementBoisson(Seance seanceBillet, Billet billetBase) {
		super(seanceBillet, billetBase);
	}
	
	public double getPrix() {
		// TODO Auto-generated method stub
		double p = this.getBilletBase().getPrix();
		return p + 3.0;
	}
}
