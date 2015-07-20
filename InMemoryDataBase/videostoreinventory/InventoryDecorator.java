package aoop.assignment3.videostoreinventory;

import java.io.IOException;

import aoop.assignment3.commands.CommandInvoker;
import aoop.assignment3.commands.CommandManager;

public class InventoryDecorator extends Decorator {

	CommandManager commandManager;
	CommandInvoker commandInvoker;
	Movie movie;
	Inventory inventory;

	public InventoryDecorator(Operations operations)
			throws ClassNotFoundException, IOException {
		super(operations);
		initializeCommandManager();
	}

	private void initializeCommandManager() throws ClassNotFoundException,
			IOException {
		commandManager = new CommandManager();
		commandInvoker = new CommandInvoker(commandManager);
		inventory = new Inventory();

	}

	@Override
	public void addNewMovies(String movieName, double price, int quantity) {
		int newMovieId = inventory.getMovieID();
		movie = new Movie(newMovieId, movieName, price, quantity);
		commandInvoker.invoke("AddNewMovies", movie, inventory);
	}

	@Override
	public void sellMovie(int movieId) {
		movie.setMovieId(movieId);
		commandInvoker.invoke("SellMovie", movie, inventory);
		printHist();
	}

	@Override
	public void addNewMovieCopies(int movieID, int copies) {
		movie.setMovieId(movieID);
		movie.setQuantity(copies);
		commandInvoker.invoke("AddNewMovieCopies", movie, inventory);
		printHist();
	}

	@Override
	public void changeMoviePrice(int movieID, double newPrice) {
		movie.setMovieId(movieID);
		movie.setPrice(newPrice);
		commandInvoker.invoke("ChangeMoviePrice", movie, inventory);
		printHist();
	}

	public void printHist() {

		try {
			commandManager.commandHistory = commandManager.getCommandHistory();
			if (commandManager.commandHistory != null) {
				System.out.println("Command Saved: "+ commandManager.commandHistory.size());
				System.out.println(commandManager.commandHistory);
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

}
