import java.util.Set;
import java.util.HashSet;

public class Main {
  public static void main (String args[]) {
    // Manager leManager = new Manager("Manager", "manager@cinema.com", "password");
    IModeleCinema monModele = new ModeleCinema();
    ControleurCinema monControleur = new ControleurCinema(monModele);
    monModele.ajouterManager("Manager", "manager@cinema.com", "password");
    VueCinema maVue = new VueCinema(monControleur, monModele);
    monControleur.setVues(maVue, maVue);
    monControleur.lancerApplication();
    // Set<Genre> genres_avatar = new HashSet<>();
    // genres_avatar.add(Genre.DRAME);
    // genres_avatar.add(Genre.HORREUR);
    // Film filmAvatar = new Film("Avatar", 2009, "Les gens en bleu", 180, genres_avatar);
    // maVue.afficherFilm(filmAvatar);
  }
  
}