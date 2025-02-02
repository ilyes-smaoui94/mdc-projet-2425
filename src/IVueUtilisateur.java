import java.util.ArrayList;
import java.util.Set;

public interface IVueUtilisateur {
    ArrayList<String> afficherDialogueConnexion();
    //void afficherConnexionReussie(Utilisateur u);
    void afficherConnexionEchouee();

    ArrayList<String> afficherDialogueDeconnexion();
   // void afficherDeconnexionReussie(Utilisateur u);
    void afficherDeconnexionEchouee();

    String afficherDialogueAffichageFilm();
    void afficherFilm(Film f);
    void afficherFilms(Set<Film> films);

    String afficherDialogueAffichageSalle();
    void afficherSalle(Salle s);
    void afficherSalles(Set<Salle> salles);

    String afficherDialogueAffichageSeance();
    void afficherSeance(Seance s);
    
    String afficherDialogueAffichageSeancesUneSalle();
    void afficherSeancesUneSalle(Set<Seance> seances);
    
    String afficherDialogueAffichageSeancesPlusieursSalles();
    void afficherSeancesPlusieursSalles(Set<Seance> seances);

    ArrayList<String> afficherDialogueReservationSeance();
    //void afficherReservationReussie(Reservation r);
    void afficherReservationEchouee();
    //void afficherReservation(Reservation r);
}
