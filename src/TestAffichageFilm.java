import java.text.ParseException;

public class TestAffichageFilm {
    public static void main(String[] args) throws ParseException {
        ModeleCinema modele= new ModeleCinema();
		
		
		
		ControleurCinema controleur = new ControleurCinema(modele);
		VueCinema vue = new VueCinema(controleur, modele);
		Film f= new Film("Inception",2012,"Parle de Inception");
		modele.getListeFilm().add(f);
		controleur.setVue(vue);
		
		System.out.println("Creation d'un nouveau film:");

		vue.Option1();

		
		System.out.println("\n Affichage de la liste de tout les films actuellement au cinema :");
		
		vue.Option3();
		
		System.out.println("\n Affichez un Film :");

		
		vue.Option4();




    }

}
