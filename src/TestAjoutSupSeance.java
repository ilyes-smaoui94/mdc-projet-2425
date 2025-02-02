import java.text.ParseException;

public class TestAjoutSupSeance {
    public static void main(String[] args) throws ParseException {
        ModeleCinema modele= new ModeleCinema();
		
		
		
		ControleurCinema controleur = new ControleurCinema(modele);
		VueCinema vue = new VueCinema(controleur, modele);
		Film f= new Film("Inception",2012,"Parle de Inception");
		Salle s= new Salle(1,60);
		modele.getListeSalle().add(s);
		modele.getListeFilm().add(f);
		controleur.setVue(vue);
		
		vue.OptionCreerSeance();

        vue.OptionSupprimerSeance();





    }
}
