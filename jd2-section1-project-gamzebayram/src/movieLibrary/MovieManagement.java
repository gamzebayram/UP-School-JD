package movieLibrary;


import java.util.Arrays;



public class MovieManagement {


	public Movie[] movies = new Movie[] {
			new Movie(10L, "Inception", "Christopher Nolan",
					new String[] { "Leonardo DiCaprio,Joseph Gordon-Levitt,Marion Cotillard" }, "2010", "Sci-fi"),
			new Movie(20L, "P.S. I Love You", "Richard LaGravenese",
					new String[] { "Hilary Swank,Gerard Butler,Jeffrey Dean Morgan" }, "2007", "Romantic"),
			new Movie(30L, "Music And Lyrics", "Marc Lawrence",
					new String[] { "Hugh Grant, Drew Barrymore, Brad Garrett" }, "2007", "Romantic"), 
			new Movie(40L, "The Invisible Guest ", "Oriol Paulo",
					new String[] { "Mario Casas,Ana Wagener,Bárbara Lennie" }, "2016", "Mystery"),
			new Movie(50L, "Unutursam Fısılda", "Çağan Irmak",
					new String[] { "Farah Zeynep Abdullah,Hümeyra,Işıl Yücesoy,Kerem Bürsin" }, "2014", "Dram") };

	public void listMovies() {
		System.out.println(Arrays.toString(movies));
	}

	public Movie findMovieById(Long movieId) {
		Movie movie = null;
		for (Movie m : movies) {
			if (m.getMovieId().equals(movieId)) {
				movie = m;
				break;
			}
		}
		return movie;
	}

	public Movie findMovieByName(String name) {
		Movie searchedMovie = null;
		for (Movie movie : movies) {
			if (movie.getName().equalsIgnoreCase(name)) {
				searchedMovie = movie;
				break;
			}
		}
		return searchedMovie;
	}

	public void addMovie(Movie newMovie) {

		Movie[] newMovies = new Movie[movies.length + 1];
		System.arraycopy(movies, 0, newMovies, 0, movies.length);
		newMovies[newMovies.length - 1] = newMovie;
		movies = newMovies;

		System.out.println("Film başarılı şekilde eklendi: " + newMovie.getName());
	}

	public boolean removeMovie(String name) {
		boolean isDeleted = false;
		int index = 0;
		Movie[] newMovies = new Movie[movies.length - 1];
		
			for (Movie movie : movies) {
			if (movie != null && movie.getName().equalsIgnoreCase(name)) {
				isDeleted = true;
				} else {
				newMovies[index] = movie;
				index++;
			}
		}	
	movies = newMovies;		
		if (isDeleted) {
			System.out.println("Film başarılı şekilde silindi: " + name);
			return true;
		} else {
			System.out.println("Hata: Film bulunamadı.");
			return false;
		}
	}

	
} 