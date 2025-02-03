import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestAjoutSupSeance {
    public static void main(String[] args) throws ParseException {
        ModeleCinema modele= new ModeleCinema();
		
		
		
		ControleurCinema controleur = new ControleurCinema(modele);
		VueCinema vue = new VueCinema(controleur, modele);
		Film f= new Film("Inception",2012,"Parle de Inception");
		Salle s1= new Salle(2,60);

		Film f2= new Film("Avatar",2009,"Parle de avatar");
		Salle s2= new Salle(1,70);

		Film f3= new Film("Avenger",2019,"Parle de Iron Man");
		Salle s3= new Salle(3,60);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1= formatter.parse("2025-02-03");
		Date date2= formatter.parse("2025-02-03");
		Date date3= formatter.parse("2025-02-04");

		Seance seance1=new Seance(f,date1,"14:00",s1,TypeSeance.REGULAR);
		Seance seance2=new Seance(f2,date2,"14:00",s2,TypeSeance.REGULAR);
		Seance seance3=new Seance(f3,date3,"17:00",s3,TypeSeance.REGULAR);
		Seance seance4=new Seance(f2,date3,"18:00",s1,TypeSeance.REGULAR);


		modele.getListeSalle().add(s1);
		modele.getListeSalle().add(s2);
		modele.getListeSalle().add(s3);

		modele.getListeFilm().add(f);
		modele.getListeFilm().add(f2);
		modele.getListeFilm().add(f3);

		modele.getListeSeance().add(seance1);
		modele.getListeSeance().add(seance2);
		modele.getListeSeance().add(seance3);
		modele.getListeSeance().add(seance4);


		controleur.setVue(vue);
		
		vue.OptionCreerSeance();


		vue.OptionAfficherSeance();

        vue.OptionSupprimerSeance();
		vue.OptionAfficherToutesSeance();

		vue.OptionAfficherSeancesFilm();




    }
}
