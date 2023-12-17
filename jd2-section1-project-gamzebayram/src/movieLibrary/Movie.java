package movieLibrary;

import java.util.Arrays;

public class Movie {

	private final Long movieId; // readonly

	private String name;

	private String director;
	
	private String[] actors;

	private String releaseDate;
		
	private String genre;

	
	public Movie(Long movieId, String name, String director, String[] actors, String releaseDate, String genre) {
		
		this.movieId = movieId;
		this.name = name;
		this.director = director;
		this.actors = actors;
		this.releaseDate = releaseDate;
		this.genre = genre;
	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String[] getActors() {
		return actors;
	}


	public void setActors(String[] actors) {
		this.actors = actors;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	

	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public Long getMovieId() {
		return movieId;
	}


	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", director=" + director + ", actors="
				+ Arrays.toString(actors) + ", releaseDate=" + releaseDate + ",  genre=" + genre + "]" + '\n';
	}
	
	
	
	
}
