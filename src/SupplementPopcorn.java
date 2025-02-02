public class SupplementPopcorn extends BilletExtra {

	public SupplementPopcorn(Billet Billet) {
		super(Billet);
	}
	
	public double getPrix() {
		// TODO Auto-generated method stub
		double p = this.getBilletBase().prix();
		return p + 6.0;
	}
}
