package aoop.assignment3.videostoreinventory;

public class Decorator implements Operations {

	protected Operations operations;
	
	
	public Decorator(Operations operations) {
		this.operations=operations;
	}
	
	@Override
	public void addNewMovies(String movieName, double price,
			int quantity) {
		operations.addNewMovies(movieName, price, quantity);
		
	}

	@Override
	public void sellMovie(int movieId) {
		operations.sellMovie(movieId);
		
	}

	@Override
	public void addNewMovieCopies(int movieID, int copies) {
		
		operations.addNewMovieCopies(movieID, copies);
		
	}

	@Override
	public void changeMoviePrice(int movieID, double newPrice) {
		
		operations.changeMoviePrice(movieID, newPrice);
	}

}
