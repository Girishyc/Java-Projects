package aoop.assignment3.commands;

import aoop.assignment3.videostoreinventory.Inventory;
import aoop.assignment3.videostoreinventory.Movie;
import aoop.assignment3.videostoreinventory.Operations;

public class AddNewMovieCopies extends Command {

	private static final long serialVersionUID = 407792298937400807L;
	Operations operations;
	CommandManager commandManager;

	public AddNewMovieCopies(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	@Override
	public void execute(Inventory inventory, Movie movie) {

		this.movie = movie;
		commandManager.recordHistory(this);
		inventory.addNewMovieCopies(movie.getMovieId(), movie.getQuantity());

	}

}
