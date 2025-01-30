package app_cinema;

public class SupplementPopcorn extends BilletExtra{
	public SupplementPopcorn(Billet Billet) {
		super(Billet);
		
	}
	
	public double prix() {
		// TODO Auto-generated method stub
		double p= this.getMonBillet().prix();
		return p+ 6.0;
	}

}
