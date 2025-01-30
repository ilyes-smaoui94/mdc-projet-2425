
public class BilletPleinTarif extends Billet {

	public BilletPleinTarif(Seance seance) {
		super(seance);
	}

	@Override
	public double prix() {
		
		double default_price= 11.0;
		if (this.getSeance().getTypeSeance() == null) {
	        return default_price; 
	    }
		
		switch (this.getSeance().getTypeSeance()) {
		case DMAX_4D:
            return 16.0;
		case _3D:
            return 14.0;
        case IMAX:
            return 13.0;
        default:
            return default_price;
		}
	}

	

}
