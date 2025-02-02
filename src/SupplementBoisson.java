/**
 * Représente un supplément boisson pour un billet, en appliquant un coût 
 * additionnel de 3.0€ au prix de base du billet associé.
 * <p>
 * Cette classe hérite de {@link BilletExtra}, qui sert de décorateur 
 * pour un objet {@link Billet}. Le prix final est la somme du prix 
 * du billet de base et d'un supplément de 3.0€.
 * </p>
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * Seance seance = new Seance(...);
 * Billet billetEtudiant = new BilletEtudiant(seance);
 * Billet supplementBoisson = new SupplementBoisson(seance, billetEtudiant);
 *
 * double prixFinal = supplementBoisson.getPrix();
 * System.out.println("Prix final avec supplément boisson : " + prixFinal + "€");
 * }</pre>
 * </p>
 * 
 */
public class SupplementBoisson extends BilletExtra {

    /**
     * Construit un nouveau supplément boisson pour un billet spécifique.
     *
     * @param seanceBillet La séance associée au billet.
     * @param billetBase   Le billet de base sur lequel appliquer le supplément.
     */
    public SupplementBoisson(Seance seanceBillet, Billet billetBase) {
        super(seanceBillet, billetBase);
    }

    /**
     * Calcule et retourne le prix du billet incluant le supplément boisson.
     * <p>
     * Le prix final est le prix du billet de base majoré de 3.0€.
     * </p>
     *
     * @return Le prix total du billet avec supplément boisson.
     */
    @Override
    public double getPrix() {
        double p = this.getBilletBase().getPrix();
        return p + 3.0;
    }
}
