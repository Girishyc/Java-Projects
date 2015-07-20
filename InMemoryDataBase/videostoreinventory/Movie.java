package aoop.assignment3.videostoreinventory;

import java.io.Serializable;

public class Movie implements Serializable {

	private static final long serialVersionUID = -37611545089215762L;
	private int movieId;
	private String movieName;
	private double price;
	private int quantity;

	public Movie(int movieId, String movieName, double price, int quantity) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
