/**
 * Représente un billet à plein tarif, avec des prix spécifiques en fonction 
 * du {@link TypeSeance}.
 * <p>
 * Les tarifs appliqués sont :
 * <ul>
 *   <li>{@link TypeSeance#DMAX_4D} : 16.0€</li>
 *   <li>{@link TypeSeance#_3D} : 14.0€</li>
 *   <li>{@link TypeSeance#IMAX} : 13.0€</li>
 *   <li>Type de séance non défini ou {@link TypeSeance#REGULAR} : 11.0€</li>
 * </ul>
 * </p>
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * Seance seance = new Seance(...);
 * Billet billetPleinTarif = new BilletPleinTarif(seance);
 * double prix = billetPleinTarif.getPrix();
 * System.out.println("Prix du billet plein tarif : " + prix + " €");
 * }</pre>
 * </p>
 * 
 * @see Billet
 * @see Seance
 * @see TypeSeance
 */
public class BilletPleinTarif extends Billet {

    /**
     * Construit un billet plein tarif associé à la séance spécifiée.
     *
     * @param seanceBillet La séance pour laquelle ce billet est émis.
     */
    public BilletPleinTarif(Seance seanceBillet) {
        super(seanceBillet);
    }

    /**
     * Calcule et retourne le prix du billet à plein tarif en fonction du type de séance.
     * <ul>
     *   <li>{@link TypeSeance#DMAX_4D} : 16.0€</li>
     *   <li>{@link TypeSeance#_3D} : 14.0€</li>
     *   <li>{@link TypeSeance#IMAX} : 13.0€</li>
     *   <li>Type de séance non défini ou {@link TypeSeance#REGULAR} : 11.0€</li>
     * </ul>
     *
     * @return Le prix du billet à plein tarif.
     */
    @Override
    public double getPrix() {
        double default_price = 11.0;
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
