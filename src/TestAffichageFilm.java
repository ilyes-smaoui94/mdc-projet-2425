import java.text.ParseException;

public class TestAffichageFilm {
    public static void main(String[] args) throws ParseException {
        ModeleCinema modele= new ModeleCinema();
		
		
		
		ControleurCinema controleur = new ControleurCinema(modele);
		VueCinema vue = new VueCinema(controleur, modele);
		Film f= new Film("Inception",2012,"Parle de Inception");
		modele.getListeFilm().add(f);
		controleur.setVue(vue);
		
		vue.Option1();

		
		System.out.println("Test Affiche ListFilm :");
		
		vue.Option3();
		System.out.println("\n******************************\n");

		
		System.out.println("Test Affiche Film :");

		
		vue.Option4(f);




    }

}
