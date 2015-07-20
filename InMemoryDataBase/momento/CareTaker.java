package momento;


import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

@SuppressWarnings("serial")
public class CareTaker implements Serializable {

	private HashMap<Integer, Memento> movies= new HashMap<Integer,Memento>();
	private CareTaker careTaker;

	public CareTaker() throws ClassNotFoundException, IOException {
		InventoryDatabase inventoryDatabase = new InventoryDatabase();
		if(inventoryDatabase.loadMovieDetailsFromDB()!=null){
			this.careTaker=inventoryDatabase.loadMovieDetailsFromDB();
			this.movies=careTaker.getMovies();
		}
	}

	public void setMovies(HashMap<Integer ,Memento> movies) {
		this.movies=movies;
	}

	public void addMovie(int key ,Memento movie) {
		movies.put(key, movie);
	}

	public Memento getMemento(int index) {
		return movies.get(index); 
	}

	public HashMap <Integer , Memento> getMovies() {
		return movies;
	}

	public CareTaker getCareTaker(){
		return careTaker;
	}
}
