package momento;

import java.io.Serializable;

import aoop.assignment3.videostoreinventory.Movie;

@SuppressWarnings("serial")
public class Memento implements Serializable {

	private Movie movie;

	public Memento( Movie newmovie){
		this.movie=newmovie;
	}

	public Movie getSavedMovie(){
		return movie;
	}
	
	@Override
	public String toString() {
		return movie.getMovieId()+" | " + movie.getMovieName() +" | " + movie.getPrice()+ " | "+ movie.getQuantity();
	}
}
