/**
 * Représente un supplément popcorn pour un billet, ajoutant un coût 
 * additionnel de 6.0€ au prix de base du billet associé.
 *
 * <p>
 * Cette classe hérite de {@link BilletExtra}, qui sert de décorateur 
 * dans un pattern Decorator pour un objet {@link Billet}. 
 * Le prix final est donc la somme du prix du billet de base 
 * et d'un supplément de 6.0€.
 * </p>
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * Seance seance = new Seance(...);
 * Billet billetEtudiant = new BilletEtudiant(seance);
 * Billet supplementPopcorn = new SupplementPopcorn(seance, billetEtudiant);
 *
 * double prixFinal = supplementPopcorn.getPrix();
 * System.out.println("Prix final avec supplément popcorn : " + prixFinal + "€");
 * }</pre>
 * </p>
 * 
 * @see Billet
 * @see BilletExtra
 * @see Seance
 */
public class SupplementPopcorn extends BilletExtra {

    /**
     * Construit un nouveau supplément popcorn pour un billet spécifique.
     *
     * @param seanceBillet La séance associée au billet.
     * @param billetBase   Le billet de base sur lequel appliquer le supplément.
     */
    public SupplementPopcorn(Seance seanceBillet, Billet billetBase) {
        super(seanceBillet, billetBase);
    }

    /**
     * Calcule et retourne le prix du billet incluant le supplément popcorn.
     * <p>
     * Le prix final est le prix du billet de base majoré de 6.0€.
     * </p>
     *
     * @return Le prix total du billet avec supplément popcorn.
     */
    @Override
    public double getPrix() {
        double p = this.getBilletBase().getPrix();
        return p + 6.0;
    }
}
