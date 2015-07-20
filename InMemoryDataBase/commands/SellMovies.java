package aoop.assignment3.commands;

import aoop.assignment3.videostoreinventory.Inventory;
import aoop.assignment3.videostoreinventory.Movie;

public class SellMovies extends Command {
	private static final long serialVersionUID = 8534125411642797411L;
	CommandManager commandManager;

	public SellMovies(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	@Override
	public void execute(Inventory inventory, Movie movie) {

		this.movie = movie;
		commandManager.recordHistory(this);
		inventory.sellMovie(movie.getMovieId());

	}

}
