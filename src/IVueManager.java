import java.util.ArrayList;

public interface IVueManager extends IVueUtilisateur {
   // ChoixMenu afficherMenuManager();

    public void afficherMenuManager();
   
    public ArrayList<String> afficherDialogueCreationUtilisateur();
    void afficherCreationUtilisateurReussie(Utilisateur u);
    public void afficherCreationUtilisateurEchouee();
    
    public ArrayList<String> afficherDialogueSuppressionUtilisateur();
    public void afficherSuppressionUtilisateurReussie();
    public void afficherSuppressionUtilisateurEchouee();

    public ArrayList<String> afficherDialogueCreationFilm();
    public void afficherCreationFilmReussie(Film f);
    public void afficherCreationFilmEchouee();

    public ArrayList<String> afficherDialogueSuppressionFilm();
    public void afficherSuppressionFilmReussie();
    public void afficherSuppressionFilmEchouee();

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