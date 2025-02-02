public class SupplementGlace extends BilletExtra {

	public SupplementGlace(Billet Billet) {
		super(Billet);
		}
			
	public double getPrix() {
		// TODO Auto-generated method stub
		double p = this.getBilletBase().prix();
		return p + 5.0;
	}

}
