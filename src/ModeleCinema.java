
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ModeleCinema {
	private HashSet<Film> listeFilm;
	private ArrayList<Salle> listeSalle;
	private ArrayList<Seance> listeSeance;

	


	public ModeleCinema(Set<Film> listeFilm) {
		this.listeFilm= new  HashSet<Film>();
	}
	
	public ModeleCinema() {
		this.listeFilm= new  HashSet<Film>();
		this.listeSalle= new ArrayList<Salle>();
		this.listeSeance= new ArrayList<Seance>();
	}
	public   HashSet<Film> getListeFilm(){
		return this.listeFilm;
	}
	public ArrayList<Salle> getListeSalle(){
		return this.listeSalle;
	}

	public ArrayList<Seance> getListeSeance(){
		return this.listeSeance;
	}
	

}
