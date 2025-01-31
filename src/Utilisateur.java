public abstract class Utilisateur {
	protected int id;
	protected String nom;
	protected String email;
	protected String motDePasse;
	static protected int maxUsedID = 0;

	public Utilisateur() {
	}

	public Utilisateur(String nom, String email, String motDePasse) {
		this.id = this.getNextId();
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public abstract void seConnecter();
	public abstract void seDeconnecter();

	public int getNextId () {
		int nextID = maxUsedID + 1;
		maxUsedID += 1;
		return nextID;
	}

	// -- Getters et Setters --
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
