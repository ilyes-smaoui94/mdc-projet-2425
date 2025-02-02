public class BilletEtudiant extends Billet {

	public BilletEtudiant(Seance seanceBillet) {
		super(seanceBillet);
	}

	@Override
	public double getPrix() {
		double default_price = 7.0;
		
		if (this.getSeance().getTypeSeance() == null) {
			return default_price; 
		}
		switch (this.getSeance().getTypeSeance()) {
		case DMAX_4D:
			return 12.0;
			// break;
		case _3D:
			return 10.0;
			// break;
		case IMAX:
			return 9.0;        
			// break;
		default:
			return default_price;
			// break;
		}
	}
}
