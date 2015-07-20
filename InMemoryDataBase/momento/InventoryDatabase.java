package momento;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InventoryDatabase{

	private CareTaker careTaker;
	
	public void storeMovieDetailsInDB(CareTaker careTaker) throws IOException {
		try {

			FileOutputStream file = new FileOutputStream("inventory.ser");
			ObjectOutputStream obOutputStream = new ObjectOutputStream(file);
			obOutputStream.writeObject(careTaker);
			obOutputStream.close();
		} catch (IOException e) {
			System.out.println("Exception in writting Occur");
		}
	}

	public CareTaker loadMovieDetailsFromDB() throws IOException,
			ClassNotFoundException {
		try {
			FileInputStream file = new FileInputStream("inventory.ser");
			ObjectInputStream obInputStream = new ObjectInputStream(file);
			careTaker = (CareTaker) obInputStream.readObject();
			obInputStream.close();

		} catch (IOException e) {
		}
		return careTaker;

	}
}
