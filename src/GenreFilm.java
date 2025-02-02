import java.util.Set;
import java.util.HashSet;

public class GenreFilm {
	enum Genre {
	    Drame,
	    Comedie,
	    Horreur,
	    Action,
	    Thriller
	  }

	  private Set<Genre> genres;

	  public GenreFilm () {
	    this.genres = new HashSet<Genre>();
	  }
	  public GenreFilm (Set<Genre> genresInitiaux) {
	    this.genres = genresInitiaux;
	  }

	  public void addGenre (Genre nvGenre) {
	    this.genres.add(nvGenre);
	  }
	  public void removeGenre (Genre genreAEnlever) {
	    this.genres.remove(genreAEnlever);
	  }
	  public Set<Genre> getGenres () {
	    return this.genres;
	  }
	}