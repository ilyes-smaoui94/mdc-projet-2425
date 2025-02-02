public class SupplementBoisson extends BilletExtra {

	public SupplementBoisson(Billet Billet) {
		super(Billet);
	}
	
	public double getPrix() {
		// TODO Auto-generated method stub
		double p = this.getBilletBase().prix();
		return p + 3.0;
	}
}
