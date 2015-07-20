package aoop.assignment3.commands;


import aoop.assignment3.videostoreinventory.Inventory;
import aoop.assignment3.videostoreinventory.Movie;
import aoop.assignment3.videostoreinventory.Operations;

public class ChangeMoviePrice extends Command {
	private static final long serialVersionUID = -813558085558254627L;
	Operations operations;
	CommandManager commandManager;
	Command dummyObject;

	public ChangeMoviePrice(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	@Override
	public void execute(Inventory inventory, Movie movie) {
		this.movie = movie;
		commandManager.recordHistory(this);
		inventory.changeMoviePrice(movie.getMovieId(), movie.getPrice());

	}

}
