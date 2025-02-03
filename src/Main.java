
public class Main {
  public static void main (String args[]) {
    // Manager leManager = new Manager("Manager", "manager@cinema.com", "password");
    IModeleCinema monModele = new ModeleCinema();
    ControleurCinema monControleur = new ControleurCinema(monModele);
    monModele.ajouterManager("Manager", "manager@cinema.com", "password");
    VueCinema maVue = new VueCinema(monControleur, monModele);
    monControleur.lancerApplication();
  }
}