
import java.util.ArrayList;

public interface IVueManager {
   // ChoixMenu afficherMenuManager();

    ArrayList<String> afficherDialogueCreationUtilisateur();
    //void afficherCreationUtilisateurReussie(Utilisateur u);
    void afficherCreationUtilisateurEchouee();
    
    void afficherDialogueSuppressionUtilisateur();
    void afficherSuppressionUtilisateurReussie();
    void afficherSuppressionUtilisateurEchouee();

    ArrayList<String> AfficherDialogueCreationFilm();
    void afficherCreationFilmReussie(Film f);
    void afficherCreationFilmEchouer();

    ArrayList<String> AfficherDialogueSuppressionFilm();
    void afficherSuppressionFilmReussie();
    void afficherSuppressionFilmEchouer();

    ArrayList<String> afficherDialogueCreationSalle();
    void afficherCreationSalleReussie(Salle s);
    void afficherCreationSalleEchouee();

    ArrayList<String> afficherDialogueSuppressionSalle();
    void afficherSuppressionSalleReussie();
    void afficherSuppressionSalleEchouee();

    ArrayList<String> afficherDialogueCreationSeance();
    void afficherCreationSeanceReussie(Seance s);
    void afficherCreationSeanceEchouee();

    ArrayList<String> afficherDialogueSuppressionSeance();
    void afficherSuppressionSeanceReussie();
    void afficherSuppressionSeanceEchouee();
    
    
}