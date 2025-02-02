public abstract class Utilisateur {
	static protected int nextAvailableId = 1;
	protected int id;
	protected String nom;
	protected String email;
	protected String motDePasse;
	private boolean connectionStatus;

	// public Utilisateur() {
	// }

	public Utilisateur(String nom, String email, String motDePasse) {
		this.id = this.getNextAvailableId();
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.connectionStatus = false;
	}

	public abstract void seConnecter();
	public abstract void seDeconnecter();

	protected static int getNextAvailableId () {
		int nextID = nextAvailableId;
		nextAvailableId += 1;
		return nextID;
	}

	// -- Getters et Setters --
	public int getId() {
		return id;
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

	public abstract getConnectionStatus() {
		return this.connectionStatus;
	}

	public abstract void seConnecter();

	public void seDeconnecter();
}
