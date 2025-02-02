/**
 * Représente un billet pour une personne de moins de 16 ans, proposant des tarifs 
 * spécifiques selon le type de séance. 
 * 
 * <p>Les tarifs appliqués sont :
 * <ul>
 *   <li>{@link TypeSeance#DMAX_4D} : 10.0€</li>
 *   <li>{@link TypeSeance#_3D} : 8.0€</li>
 *   <li>{@link TypeSeance#IMAX} : 7.0€</li>
 *   <li>Type de séance non défini ou {@link TypeSeance#REGULAR} : 5.0€</li>
 * </ul>
 *  
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * Seance seance = new Seance(...);
 * Billet billetMoins16 = new BilletMoinsDe16(seance);
 * double prix = billetMoins16.getPrix();
 * System.out.println("Prix du billet -16 ans : " + prix + " €");
 * }</pre>
 *  
 * 
 * @see Billet
 * @see Seance
 * @see TypeSeance
 */
public class BilletMoinsDe16 extends Billet {

    /**
     * Construit un billet "moins de 16 ans" associé à la séance spécifiée.
     *
     * @param seanceBillet La séance pour laquelle ce billet est émis.
     */
    public BilletMoinsDe16(Seance seanceBillet) {
        super(seanceBillet);
    }

    /**
     * Calcule et retourne le prix du billet en fonction du type de séance.
     * <ul>
     *   <li>{@link TypeSeance#DMAX_4D} : 10.0€</li>
     *   <li>{@link TypeSeance#_3D} : 8.0€</li>
     *   <li>{@link TypeSeance#IMAX} : 7.0€</li>
     *   <li>Type de séance non défini ou {@link TypeSeance#REGULAR} : 5.0€</li>
     * </ul>
     *
     * @return Le prix du billet pour une personne de moins de 16 ans.
     */
    @Override
    public double getPrix() {
        double default_price = 5.0;
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
