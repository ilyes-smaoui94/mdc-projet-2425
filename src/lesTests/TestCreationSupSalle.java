import java.text.ParseException;

public class TestCreationSupSalle {
    public static void main(String[] args) throws ParseException {
        ModeleCinema modele= new ModeleCinema();
		
		
		
		ControleurCinema controleur = new ControleurCinema(modele);
		VueCinema vue = new VueCinema(controleur, modele);
		
		controleur.setVue(vue);
		
		System.out.println("Test Création :");
		vue.OptionCreerSalle();

        System.out.println("\nTest Suppression :");
        vue.OptionSupprimerSalle();



    }

    
}
