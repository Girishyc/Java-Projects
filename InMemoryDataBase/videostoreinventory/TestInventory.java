package aoop.assignment3.videostoreinventory;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import momento.CareTaker;
import momento.InventoryDatabase;
import momento.Memento;
import aoop.assignment3.commands.Command;
import aoop.assignment3.commands.CommandManager;

public class TestInventory {

	public static void main(String args[]) throws IOException,ClassNotFoundException {
		
		InventoryDatabase inventoryDatabase= new InventoryDatabase();
		/*
		Operations vg = new InventoryDecorator(new Inventory());
	    vg.addNewMovies("Test", 25, 10);
	    vg.addNewMovies("Test2",25, 30);
	    vg.addNewMovies("Test3",23, 40);
	    vg.addNewMovies("Test4",23, 40);
	    vg.addNewMovies("Test5",23, 40);
	    vg.sellMovie(1);
	    vg.changeMoviePrice(1, 500);
	    vg.addNewMovieCopies(2, 50);
	    vg.addNewMovieCopies(3, 50);
	    
	  */  
		
		testprint(inventoryDatabase);
	   
	    CommandManager commandManager= new CommandManager();
	    commandManager.commandHistory= commandManager.getCommandHistory();
	    Inventory inventory= new Inventory();
	    inventory.setResotreBackup(true);
	    for(Command commands: commandManager.commandHistory){
	    	commands.execute(inventory, commands.movie);
	    }
	   
	   System.out.println("\n\n\n");
	   System.out.println("Inventory after backup restoration");
	   
	    testprint(inventoryDatabase); 
	    
	    
	    
	 /*   Inventory inventory= new Inventory();
	    
	    Movie movie=inventory.searchMovie(1, "Texas");
	    if(movie!=null){
	    	System.out.println("Movie Found");
	    	System.out.println(movie.getMovieId()+movie.getMovieName()+movie.getPrice()+movie.getQuantity());
	    }else{
	    	System.out.println("Movie Not Found");
	    }
	    
	}*/
	}

	private static void testprint(InventoryDatabase inventoryDatabase)
			throws IOException, ClassNotFoundException {
		CareTaker careTaker;
		careTaker=inventoryDatabase.loadMovieDetailsFromDB();
		Map<Integer, Memento> map=careTaker.getMovies();
		for (Entry<Integer, Memento> test: map.entrySet() )
			System.out.println(test.getValue().toString());
	}
	
}