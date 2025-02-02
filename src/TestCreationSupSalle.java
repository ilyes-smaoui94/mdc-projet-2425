import java.text.ParseException;

public class TestCreationSupSalle {
    public static void main(String[] args) throws ParseException {
        ModeleCinema modele= new ModeleCinema();
		
		
		
		ControleurCinema controleur = new ControleurCinema(modele);
		VueCinema vue = new VueCinema(controleur, modele);
		
        Salle s1= new Salle(2,60);

		Salle s2= new Salle(1,70);

		Salle s3= new Salle(3,60);
        modele.getListeSalle().add(s1);
		modele.getListeSalle().add(s2);
		modele.getListeSalle().add(s3);
		controleur.setVue(vue);
		
		System.out.println("Test Création :");
        vue.OptionAfficherSalles();
		vue.OptionCreerSalle();
        vue.OptionAfficherSalles();

        System.out.println("\nTest Suppression :");

        vue.OptionSupprimerSalle();
        vue.OptionAfficherSalles();



    }

    
}
