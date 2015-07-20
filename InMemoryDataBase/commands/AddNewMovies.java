package aoop.assignment3.commands;

import aoop.assignment3.videostoreinventory.Inventory;
import aoop.assignment3.videostoreinventory.Movie;

public class AddNewMovies extends Command {
	private static final long serialVersionUID = -3413886195305756207L;
	CommandManager commandManager;

	public AddNewMovies(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	@Override
	public void execute(Inventory inventory, Movie movie) {

		this.movie = movie;
		commandManager.recordHistory(this);
		inventory.addNewMovies(movie.getMovieName(), movie.getPrice(),movie.getQuantity());

	}
}
