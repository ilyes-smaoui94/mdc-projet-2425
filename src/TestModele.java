import java.util.ArrayList;

public class TestModele {

  public static void essayerConnexion (IModeleCinema modele, String email, String mdp) {
    ArrayList<Boolean> resTest = modele.connecterUtilisateur(email, mdp);
    if (resTest.get(0)) {
      System.out.println("Connexion réussie !");
      if (resTest.get(1)) {
        System.out.println("(Manager)");
      }
      else {
        System.out.println("(Client)");
      }
    }
    else {
      System.out.println("Connexion échouée !");
    }
  }

  public static void essayerAjoutSalle (IModeleCinema modele, int numero, int capacite) {
    int res = modele.ajouterSalle(numero, capacite);
    if (res > 0) {
      System.out.println("Salle d'ID " + res + " bien créée !");
      System.out.println("(Salle numéro " + modele.getSalle(res).getNumero() + " avec une capacité de " + modele.getSalle(res).getCapacite() + ")");
    }
    else {
      System.out.println("Échec !");
      System.out.println("(numéro : " + numero + ", capacité : " + capacite + ")");
    }
  }

  public static void main (String args[]) {
    IModeleCinema monModele = new ModeleCinema();
    
    // Billet billet1 = new Bi
    
    // À tester : ?
    // ajouter/get/getListe
    String nomManager = "Manager", emailManager = "man@gmail.com", mdpManager = "mdp_man";
    String donneesClient1[] = {"Alice", "alice@gmail.com", "mdp_alice"};
    String donneesClient2[] = {"Bob", "bob@gmail.com", "mdp_bob"};
    String donneesClient3[] = {"Chris", "chris@gmail.com", "mdp_chris"};
    int donneesSalle[][] = {
      {1, 400},
      {37, 40},
      {6, 350},
      {1, 300},
      {3, 200}
    };
    
    // Ajout d'utilisateur
    monModele.ajouterManager(nomManager, emailManager, mdpManager);
    monModele.ajouterClient(donneesClient1[0], donneesClient1[1], donneesClient1[2]);
    monModele.ajouterClient(donneesClient2[0], donneesClient2[1], donneesClient2[2]);
    monModele.ajouterClient(donneesClient3[0], donneesClient3[1], donneesClient3[2]);

    essayerConnexion(monModele, emailManager, mdpManager);
    essayerConnexion(monModele, emailManager, mdpManager + "_");
    essayerConnexion(monModele, donneesClient1[1], donneesClient1[2]);
    essayerConnexion(monModele, donneesClient2[1], donneesClient2[2]);
    essayerConnexion(monModele, donneesClient2[1], donneesClient2[2] + "_");

    essayerAjoutSalle(monModele, donneesSalle[0][0], donneesSalle[0][1]);
    essayerAjoutSalle(monModele, donneesSalle[1][0], donneesSalle[1][1]);
    essayerAjoutSalle(monModele, donneesSalle[2][0], donneesSalle[2][1]);
    essayerAjoutSalle(monModele, donneesSalle[3][0], donneesSalle[3][1]);
    essayerAjoutSalle(monModele, donneesSalle[4][0], donneesSalle[4][1]);

    // Afficahge des listes du Modèles, pour une vue d'ensemble
    System.out.println("Utilisateurs :\n" + monModele.getListeUtilisateurs());
    System.out.println("Billets :\n" + monModele.getListeBillets());
    System.out.println("Films :\n" + monModele.getListeFilms());
    System.out.println("Résas :\n" + monModele.getListeReservations());
    System.out.println("Salles :\n" + monModele.getListeSalles());
    System.out.println("Seances :\n" + monModele.getListeSeances());
    
    // []
    // Client/Manager
    // Billets/BilletExtra
    // Salle
    // Seance, TypeSeance
    // Film, Genre
    // Reservation
  }
}