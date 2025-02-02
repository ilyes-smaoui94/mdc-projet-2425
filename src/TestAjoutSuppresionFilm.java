import java.text.ParseException;

public class TestAjoutSuppresionFilm {

	public static void main(String[] args) throws ParseException {
        ModeleCinema modele= new ModeleCinema();
		
		
		
		ControleurCinema controleur = new ControleurCinema(modele);
		VueCinema vue = new VueCinema(controleur, modele);
		
		controleur.setVue(vue);
		
		System.out.println("Test Ajout :");
		vue.Option1();

		System.out.println("\n******************************\n");
		
		System.out.println("Test Suppresion :");
		
		vue.Option2();



    }

}
