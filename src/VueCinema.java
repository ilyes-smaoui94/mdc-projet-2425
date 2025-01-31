class VueCinema implements ObservateurSeance, IVueCinema {
    public void afficherMenu(Utilisateur utilisateur) {
        System.out.println("=== MENU CINEMA ===");
        // Simple exemple : on affiche un menu générique,
        // ou on peut faire un instanceof pour distinguer Manager / Client
        System.out.println("1. Se connecter");
        System.out.println("2. Déconnecter");
        System.out.println("3. Créer un film");
        System.out.println("4. Programmer une séance");
        System.out.println("5. Réserver une séance");
        System.out.println("6. Payer une réservation");
    }

    // Affiche la confirmation d’une réservation (u + r)
    public void afficheConfResa(Utilisateur u, Reservation r) {
        System.out.println("Confirmation de réservation pour l'utilisateur " 
                            + u.getNom() + " : Réservation n°" + r.getId());
    }

    // Affiche la confirmation d’une réservation (juste r)
    public void afficheConfResa(Reservation r) {
        System.out.println("Réservation n°" + r.getId() 
                           + " confirmée pour le film : " 
                           + r.getSeance().getFilm().getTitre());
    }

    // Affiche la confirmation d’une réservation (juste u)
    // (Nom peu explicite, mais on respecte la signature demandée)
    public void afficheConfResa(Utilisateur u) {
        System.out.println("Réservation confirmée pour l'utilisateur " + u.getNom());
    }

    // Affiche la confirmation d’un film (u)
    public void afficheConfFilm(Utilisateur u) {
        System.out.println("Confirmation : un film a été créé par l'utilisateur " + u.getNom());
    }

    // Affiche la confirmation d’un film (f)
    public void afficheConfFilm(Film f) {
        System.out.println("Confirmation : Film créé - " + f.getTitre());
    }

    // Affiche la confirmation d’un film (u, f)
    public void afficheConfFilm(Utilisateur u, Film f) {
        System.out.println("Confirmation : Film " + f.getTitre() 
                           + " créé par " + u.getNom());
    }

    // Affiche la confirmation d’une séance créée (s)
    public void afficheConfSeanceCreee(Seance s) {
        System.out.println("Confirmation : Séance programmée pour le film " 
                           + s.getFilm().getTitre() + ", en salle " 
                           + s.getSalle().getNom());
    }

    public void afficherConfCreationClient (Client c) {
        String aAfficher = "";
        // [TBC]
        aAfficher += "Utilisateur n°" + c.getId() + " (email : " + c.getEmail() + ") bien créé !\n";
        // [/TBC]
        System.out.println(aAfficher);
    }
  
}
