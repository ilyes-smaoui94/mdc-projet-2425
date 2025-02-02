
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ModeleCinema {
	private HashSet<Film> listeFilm;
	


	public ModeleCinema(Set<Film> listeFilm) {
		this.listeFilm= new  HashSet<Film>();
	}
	
	public ModeleCinema() {
		this.listeFilm= new  HashSet<Film>();
	}
	public   HashSet<Film> getListeFilm(){
		return this.listeFilm;
	}
	

}
