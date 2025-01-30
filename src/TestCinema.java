public class Main {
    public static void main(String[] args) {

        // On crée un Utilisateur (par exemple un Client ou un Manager)
        Utilisateur man = new Manager(1, "admin", "admin@mail.com", "1234") {
        };

        Utilisateur cl1 = new Client(1, "Thomas", "Thomas@mail.com", "toto") {
        };

        // Contrôleur
        CinemaController cman = new CinemaController(man);
        CinemaController ccl = new CinemaController(cl1);
        // Vue
        VueCinema vue = new VueCinema();

        // Affichage d’un menu
        vue.afficherMenu(man);

        // L’utilisateur se connecte
        controller.seConnecter();

        // Création d’un Film
        Film film = cman.creerFilm("IronMan", 120);
        vue.afficheConfFilm(man, film);

        // Programmation d’une séance
        Salle salle = new Salle("Salle 1", 100);
        Seance seance = cman.programmerSeance(film, salle, new Date());
        vue.afficheConfSeanceCreer(seance);

        // Réservation
        vue.afficherMenu(cl1);
        Reservation resa = ccl.reserverSeance(seance);
        if (resa != null) {
            vue.afficheConfResa(cl1, resa);
            ccl1.payerReservation(resa);
        }

        // Déconnexion
        cman.seDeconnecter();
    }
}
