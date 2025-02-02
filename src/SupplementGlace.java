
public class SupplementGlace extends BilletExtra{

	public SupplementGlace(Billet Billet) {
		super(Billet);
				
		}
			
	public double prix() {
				// TODO Auto-generated method stub
		double p= this.getMonBillet().prix();
		return p+ 5.0;
		}

}
