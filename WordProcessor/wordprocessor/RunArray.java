package assignment4.wordprocessor;

import java.awt.Font;
import java.util.ArrayList;

public class RunArray {

	private ArrayList<Integer> characterIndices = new ArrayList<Integer>();
	private ArrayList<Font> fontIndices = new ArrayList<Font>();

	protected void addRun(int lowerIndex, int length, Font newFont) {
		if (characterIndices.size() == 0)
			characterIndices.add(lowerIndex);
		characterIndices.add(lowerIndex + length);
		fontIndices.add(newFont);
	}

	protected void appendRun(int length, Font newFont) {
		int lastIndex = characterIndices.size() - 1;
		characterIndices.add(characterIndices.get(lastIndex) + length);
		fontIndices.add(newFont);
	}

	protected Font getFont(int index) {
		for (int i = 0; i <= characterIndices.size() - 1; i++) {
			int temp = i + 1;
			if (temp <= characterIndices.size() - 1)
				if (characterIndices.get(i) <= index) {
					if (characterIndices.get(temp) >= index) {
						return fontIndices.get(i);
					}
				}
		}

		return fontIndices.get(fontIndices.size() - 1);
	}
}
