/**
 * Représente un billet pour un étudiant, offrant des tarifs spécifiques 
 * en fonction du {@link TypeSeance} de la séance associée.
 * <p>
 * Par défaut, le prix est de 7.0€ pour une séance régulière (ou si le type de séance 
 * n'est pas défini). Les tarifs peuvent être plus élevés selon le format de la séance :
 * <ul>
 *   <li>{@link TypeSeance#DMAX_4D} : 12.0€</li>
 *   <li>{@link TypeSeance#_3D} : 10.0€</li>
 *   <li>{@link TypeSeance#IMAX} : 9.0€</li>
 *   <li>{@link TypeSeance#REGULAR} : 7.0€ (prix par défaut)</li>
 * </ul>
 * 
 *
 * <p>Exemple d'utilisation : 
 * <pre>{@code
 * Seance seance = new Seance(...);
 * Billet billetEtudiant = new BilletEtudiant(seance);
 * double prix = billetEtudiant.getPrix();
 * System.out.println("Prix du billet étudiant : " + prix + " €");
 * }</pre>
 * 
 */
public class BilletEtudiant extends Billet {

    /**
     * Construit un nouveau billet étudiant associé à la séance spécifiée.
     *
     * @param seanceBillet La séance pour laquelle ce billet est émis.
     */
    public BilletEtudiant(Seance seanceBillet) {
        super(seanceBillet);
    }

    /**
     * Calcule et retourne le prix du billet étudiant en fonction du type de séance.
     * <ul>
     *   <li>DMAX_4D = 12.0€</li>
     *   <li>_3D = 10.0€</li>
     *   <li>IMAX = 9.0€</li>
     *   <li>REGULAR ou non défini = 7.0€</li>
     * </ul>
     *
     * @return Le prix du billet étudiant.
     */
    @Override
    public double getPrix() {
        double default_price = 7.0;

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
