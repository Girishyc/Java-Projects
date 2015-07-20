package aoop.assignment3.commands;

import java.io.IOException;
import java.util.HashMap;

import aoop.assignment3.videostoreinventory.Inventory;
import aoop.assignment3.videostoreinventory.Movie;

public class CommandInvoker {

	private HashMap<String, Command> commandMap = new HashMap<String, Command>();

	public CommandInvoker(CommandManager commandManager)throws ClassNotFoundException, IOException {
		commandMap.put("AddNewMovies", new AddNewMovies(commandManager));
		commandMap.put("AddNewMovieCopies", new AddNewMovieCopies(commandManager));
		commandMap.put("ChangeMoviePrice", new ChangeMoviePrice(commandManager));
		commandMap.put("SellMovie", new SellMovies(commandManager));

	}

	public void invoke(String command, Movie movie, Inventory inventory) {

		commandMap.get(command).execute(inventory,movie);

	}
}
