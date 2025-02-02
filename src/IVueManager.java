import java.util.ArrayList;

public interface IVueManager extends IVueUtilisateur {
   // ChoixMenu afficherMenuManager();

    public void afficherMenuManager();
   
    public ArrayList<String> afficherDialogueCreationUtilisateur();
    //void afficherCreationUtilisateurReussie(Utilisateur u);
    public void afficherCreationUtilisateurEchouee();
    
    public void afficherDialogueSuppressionUtilisateur();
    public void afficherSuppressionUtilisateurReussie();
    public void afficherSuppressionUtilisateurEchouee();

    public ArrayList<String> AfficherDialogueCreationFilm();
    public void afficherCreationFilmReussie(Film f);
    public void afficherCreationFilmEchouer();

    public ArrayList<String> AfficherDialogueSuppressionFilm();
    public void afficherSuppressionFilmReussie();
    public void afficherSuppressionFilmEchouer();

    public ArrayList<String> afficherDialogueCreationSalle();
    public void afficherCreationSalleReussie(Salle s);
    public void afficherCreationSalleEchouee();

    public ArrayList<String> afficherDialogueSuppressionSalle();
    public void afficherSuppressionSalleReussie();
    public void afficherSuppressionSalleEchouee();

    public ArrayList<String> afficherDialogueCreationSeance();
    public void afficherCreationSeanceReussie(Seance s);
    public void afficherCreationSeanceEchouee();

    public ArrayList<String> afficherDialogueSuppressionSeance();
    public void afficherSuppressionSeanceReussie();
    public void afficherSuppressionSeanceEchouee();
    
    
}