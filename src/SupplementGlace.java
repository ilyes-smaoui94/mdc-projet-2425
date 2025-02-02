/**
 * Représente un supplément glace pour un billet, en ajoutant un coût 
 * additionnel de 5.0€ au prix de base du billet associé.
 * <p>
 * Cette classe hérite de {@link BilletExtra}, qui sert de décorateur 
 * pour un objet {@link Billet}. Le prix final est la somme du prix 
 * du billet de base et d'un supplément de 5.0€.
 * </p>
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * Seance seance = new Seance(...);
 * Billet billetEtudiant = new BilletEtudiant(seance);
 * Billet supplementGlace = new SupplementGlace(seance, billetEtudiant);
 *
 * double prixFinal = supplementGlace.getPrix();
 * System.out.println("Prix final avec supplément glace : " + prixFinal + "€");
 * }</pre>
 * </p>
 * 
 */
public class SupplementGlace extends BilletExtra {

    /**
     * Construit un nouveau supplément glace pour un billet spécifique.
     *
     * @param seanceBillet La séance associée au billet.
     * @param billetBase   Le billet de base sur lequel appliquer le supplément.
     */
    public SupplementGlace(Seance seanceBillet, Billet billetBase) {
        super(seanceBillet, billetBase);
    }

    /**
     * Calcule et retourne le prix du billet incluant le supplément glace.
     * <p>
     * Le prix final est le prix du billet de base majoré de 5.0€.
     * </p>
     *
     * @return Le prix total du billet avec supplément glace.
     */
    @Override
    public double getPrix() {
        double p = this.getBilletBase().getPrix();
        return p + 5.0;
    }
}
