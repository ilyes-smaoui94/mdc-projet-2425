

public class BilletEtudiant extends Billet {

	public BilletEtudiant(Seance seance) {
		super(seance);
}

	@Override
	public double prix() {
		double default_price= 7.0;
		
		if (this.getSeance().getTypeSeance() == null) {
	        return default_price; 
	    }
		switch (this.getSeance().getTypeSeance()) {
		case DMAX_4D:
            return 12.0;
		case _3D:
            return 10.0;
        case IMAX:
            return 9.0;
        
        default:
            return default_price;
		}
	}

	

}
