/**
 * Représente un utilisateur abstrait avec un identifiant, un nom, un email et un mot de passe.
 * Les classes concrètes doivent implémenter les méthodes de connexion et de déconnexion.
 */
public abstract class Utilisateur {

    /**
     * Identifiant statique pour déterminer le prochain ID disponible
     * pour chaque nouvel utilisateur.
     */
    static protected int nextAvailableId = 1;

    /**
     * Identifiant unique de l'utilisateur.
     */
    protected int id;

    /**
     * Nom de l'utilisateur.
     */
    protected String nom;

    /**
     * Adresse email de l'utilisateur.
     */
    protected String email;

    /**
     * Mot de passe de l'utilisateur.
     */
    protected String motDePasse;

    /**
     * Indique si l'utilisateur est actuellement connecté.
     */
    private boolean connectionStatus;

    /**
     * Constructeur de l'utilisateur.
     *
     * @param nom        Nom de l'utilisateur.
     * @param email      Adresse email de l'utilisateur.
     * @param motDePasse Mot de passe de l'utilisateur.
     */
    public Utilisateur(String nom, String email, String motDePasse) {
        this.id = this.getNextAvailableId();
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.connectionStatus = false;
    }

    /**
     * Retourne le prochain identifiant disponible et l'incrémente pour le futur utilisateur.
     *
     * @return le prochain identifiant disponible.
     */
    protected static int getNextAvailableId() {
        int nextID = nextAvailableId;
        nextAvailableId += 1;
        return nextID;
    }

    // -- Getters et Setters --

    /**
     * Retourne l'identifiant unique de l'utilisateur.
     *
     * @return l'identifiant de l'utilisateur.
     */
    public int getId() {
        return id;
    }

    /**
     * Retourne le nom de l'utilisateur.
     *
     * @return le nom de l'utilisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de l'utilisateur.
     *
     * @param nom le nouveau nom de l'utilisateur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne l'adresse email de l'utilisateur.
     *
     * @return l'adresse email de l'utilisateur.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifie l'adresse email de l'utilisateur.
     *
     * @param email la nouvelle adresse email de l'utilisateur.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retourne le mot de passe de l'utilisateur.
     *
     * @return le mot de passe de l'utilisateur.
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Modifie le mot de passe de l'utilisateur.
     *
     * @param motDePasse le nouveau mot de passe de l'utilisateur.
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * Indique si l'utilisateur est actuellement connecté.
     *
     * @return true si l'utilisateur est connecté, false sinon.
     */
    public boolean getConnectionStatus() {
        return this.connectionStatus;
    }

    /**
     * Méthode abstraite pour connecter un utilisateur.
     * Les classes concrètes doivent implémenter cette logique.
     *
     * @return true si la connexion réussit, false sinon.
     */
    public abstract boolean seConnecter();

    /**
     * Méthode abstraite pour déconnecter un utilisateur.
     * Les classes concrètes doivent implémenter cette logique.
     *
     * @return true si la déconnexion réussit, false sinon.
     */
    public abstract boolean seDeconnecter();
}
