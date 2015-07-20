package aoop.assignment3.videostoreinventory;

import java.io.IOException;
import java.util.HashMap;

import aoop.assignment3.commands.CommandManager;
import momento.CareTaker;
import momento.InventoryDatabase;
import momento.Memento;

public class Inventory implements Operations {

	private Movie movie;
	public HashMap<Integer, Memento> movies;
	private static int Counter;
	private int MovieID=1;
	private CareTaker careTaker;
	private boolean restoreBackup =false;


	public void setResotreBackup(boolean restoreFlag){
		this.restoreBackup=true;
	}

	public Inventory() throws ClassNotFoundException, IOException {
		careTaker = new CareTaker();
		movies=careTaker.getMovies();
		MovieID=generateNewMovieID() ;
		Counter=0;
	}


	public  int getMovieID() {
		return MovieID;
	}

	private int generateNewMovieID() {
		int result=0;
		for (int key : movies.keySet()) {
			result = movies.get(key).getSavedMovie().getMovieId();
		}
		return result+1;
	}

	public void addNewMovies(String movieName, double price,
			int quantity) {
		movie = new Movie(MovieID, movieName, price, quantity);
		careTaker.addMovie(MovieID,new Memento(movie));
		Counter++;
		MovieID++;
		storeMovieDetails();

	}

	public void sellMovie(int movieId)  {

		int quantity=movies.get(movieId).getSavedMovie().getQuantity();
		careTaker.getMovies().get(movieId).getSavedMovie().setQuantity(--quantity);
		Counter++;
		storeMovieDetails();
	}


	public void addNewMovieCopies(int movieID, int newCopies) {
		int Oldcopies=movies.get(movieID).getSavedMovie().getQuantity();
		careTaker.getMovies().get(movieID).getSavedMovie().setQuantity(Oldcopies+newCopies);
		Counter++;
		storeMovieDetails();

	}

	public void changeMoviePrice(int movieID, double newPrice) {
		movies.get(movieID).getSavedMovie().setPrice(newPrice);
		Counter++;
		storeMovieDetails();
	}

	public Movie searchMovie(int movieID, String movieName) {
		if(movies.containsKey(movieID)){
			return  movies.get(movieID).getSavedMovie();
		}else{
			for (int key : movies.keySet()) {
				if(movies.get(key).getSavedMovie().getMovieName().equalsIgnoreCase(movieName)){
					return movies.get(key).getSavedMovie();
				}
			}
		}
		return movie;
	}


	public void storeMovieDetails() {
		try {
			if(Counter==5 || restoreBackup){
				CommandManager commandManager;
				commandManager = new CommandManager();
				InventoryDatabase inventoryDatabase=new InventoryDatabase();
				commandManager.eraseCommand();
				Counter=0;
				inventoryDatabase.storeMovieDetailsInDB(careTaker);
			} }catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}


