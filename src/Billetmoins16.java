
public class Billetmoins16 extends Billet {

	public Billetmoins16(Seance seance) {
		super(seance);
	}

	@Override
	public double prix() {
		double default_price= 5.0;
		if (this.getSeance().getTypeSeance() == null) {
	        return default_price; 
	    }
		switch (this.getSeance().getTypeSeance()) {
		case DMAX_4D:
            return 10.0;
		case _3D:
            return 8.0;
        case IMAX:
            return 7.0;
        
        default:
            return default_price;
		}
	}

	
	
}
