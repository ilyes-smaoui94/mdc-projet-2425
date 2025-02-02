public class SupplementGlace extends BilletExtra {

	public SupplementGlace(Seance seanceBillet, Billet billetBase) {
		super(seanceBillet, billetBase);
		}
			
	public double getPrix() {
		// TODO Auto-generated method stub
		double p = this.getBilletBase().getPrix();
		return p + 5.0;
	}

}
