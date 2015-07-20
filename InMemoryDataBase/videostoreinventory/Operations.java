package aoop.assignment3.videostoreinventory;

public interface Operations {
	
	public void addNewMovies(String movieName, double price,int quantity); 
	public void sellMovie(int movieId);
	public void addNewMovieCopies(int movieID, int copies);
	public void changeMoviePrice(int movieID, double newPrice);

}

