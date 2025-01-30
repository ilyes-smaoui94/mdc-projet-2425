package app_cinema;

public class SupplementBoisson extends BilletExtra{

	public SupplementBoisson(Billet Billet) {
		super(Billet);
			
		}
		
		public double prix() {
			// TODO Auto-generated method stub
			double p= this.getMonBillet().prix();
			return p+ 3.0;
		}
}
