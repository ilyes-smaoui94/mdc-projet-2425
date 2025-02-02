/**
 * Classe abstraite représentant un billet "décorateur" (pattern Decorator) qui ajoute
 * des fonctionnalités ou des coûts supplémentaires à un billet de base.
 *
 * <p>
 * Cette classe hérite de {@link Billet} et contient un billet de base ({@link #billetBase})
 * afin de lui ajouter un supplément (prix, etc.) ou des informations additionnelles.
 * 
 *
 * <p>Exemple d'utilisation :
 * <pre>{@code
 * Seance seance = new Seance(...);
 * Billet billetEtudiant = new BilletEtudiant(seance);
 *
 * // Décorateur : supplément boisson
 * BilletExtra supplementBoisson = new SupplementBoisson(seance, billetEtudiant);
 *
 * // Décorateur : supplément glace
 * BilletExtra supplementGlace = new SupplementGlace(seance, billetEtudiant);
 *
 * // On peut chaîner les décorateurs
 * BilletExtra billetComplet = new SupplementGlace(seance, supplementBoisson);
 *
 * // Calcul du prix final
 * double prixFinal = billetComplet.getPrix();
 * }</pre>
 * 
 * 
 * <p>
 * Les classes concrètes qui étendent {@code BilletExtra} doivent implémenter 
 * la méthode {@link #getPrix()} pour définir le coût supplémentaire appliqué 
 * au billet de base.
 * 
 * 
 * @see Billet
 * @see SupplementBoisson
 * @see SupplementGlace
 * @see SupplementPopCorn
 */
public abstract class BilletExtra extends Billet {

    /**
     * Le billet de base sur lequel le supplément s'applique.
     */
    private Billet billetBase;

    /**
     * Construit un billet décoré avec la séance spécifiée et un billet de base.
     *
     * @param seanceBillet La séance associée au billet.
     * @param billetBase   Le billet de base sur lequel appliquer le supplément.
     */
    public BilletExtra(Seance seanceBillet, Billet billetBase) {
        super(seanceBillet);
        this.billetBase = billetBase;
    }

    /**
     * Méthode abstraite qui doit être implémentée pour calculer le prix
     * du billet en tenant compte du supplément.
     *
     * @return Le prix total (billet de base + supplément).
     */
    @Override
    public abstract double getPrix();

    /**
     * Retourne le billet de base sur lequel s'applique ce décorateur.
     *
     * @return Le billet de base associé.
     */
    public Billet getBilletBase() {
        return this.billetBase;
    }
}
