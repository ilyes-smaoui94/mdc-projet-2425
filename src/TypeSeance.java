/**
 * Enumération représentant les différents formats ou types de séance 
 * pouvant être proposés dans un cinéma.
 * <ul>
 *   <li>{@link #REGULAR} : Séance classique.</li>
 *   <li>{@link #IMAX} : Séance au format IMAX.</li>
 *   <li>{@link #DMAX_4D} : Séance au format 4D, incluant éventuellement 
 *       mouvements de siège, effets sensoriels, etc.</li>
 *   <li>{@link #_3D} : Séance en trois dimensions.</li>
 * </ul>
 */
public enum TypeSeance {
    /**
     * Séance classique (2D standard).
     */
    REGULAR,

    /**
     * Séance au format IMAX.
     */
    IMAX,

    /**
     * Séance au format 4D, pouvant inclure des effets sensoriels ou 
     * mouvements de siège.
     */
    DMAX_4D,

    /**
     * Séance en trois dimensions (3D).
     */
    _3D
}
