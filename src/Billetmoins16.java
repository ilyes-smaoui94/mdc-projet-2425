public class BilletMoins16 extends Billet {

	public BilletMoins16(Seance seance) {
		super(seance);
	}

	@Override
	public double prix() {
		double default_price = 5.0;
		if (this.getSeance().getTypeSeance() == null) {
	        return default_price; 
		}
		switch (this.getSeance().getTypeSeance()) {
		case DMAX_4D:
			return 10.0;
			break;
		case _3D:
			return 8.0;
			break;
		case IMAX:
			return 7.0;		
			break;
		default:
			return default_price;
			break;
		}
	}
}
