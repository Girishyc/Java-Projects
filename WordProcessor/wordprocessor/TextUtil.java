package assignment4.wordprocessor;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextUtil {

	protected static String getSampleTextInfo() {
		StringBuilder temp = new StringBuilder();
		try {
			Scanner reader = new Scanner(new FileReader("sampleText.txt"));

			while (reader.hasNextLine()) {
				temp.append(reader.nextLine());
				if (reader.hasNextLine())
					temp.append("\n");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp.toString();

	}
	
	
}
