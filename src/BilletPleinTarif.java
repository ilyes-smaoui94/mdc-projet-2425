public class BilletPleinTarif extends Billet {

	public BilletPleinTarif(Seance seanceBillet) {
		super(seanceBillet);
	}

	@Override
	public double getPrix() {
		double default_price = 11.0;
		if (this.getSeance().getTypeSeance() == null) {
			return default_price; 
		}
		switch (this.getSeance().getTypeSeance()) {
		case DMAX_4D:
			return 16.0;
			// break;
		case _3D:
			return 14.0;
			// break;
		case IMAX:
			return 13.0;
			// break;
		default:
			return default_price;
			// break;
		}
	}
}
