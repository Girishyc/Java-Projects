package aoop.assignment3.commands;

import java.io.Serializable;

import aoop.assignment3.videostoreinventory.Inventory;
import aoop.assignment3.videostoreinventory.Movie;
@SuppressWarnings("serial")
public abstract  class Command implements Serializable {

	public Movie movie;
	public  abstract void execute(Inventory inventory , Movie movie);

}
