package assignment4.wordprocessor;

import java.awt.Font;
import java.util.ArrayList;

public class FontFlyweightFactory {

	private ArrayList<Font> fonts = new ArrayList<Font>();

	private static class SingletonHolder {
		private final static FontFlyweightFactory INSTANCE = new FontFlyweightFactory();
	}

	public static FontFlyweightFactory instance() {
		return SingletonHolder.INSTANCE;
	}

	public Font getFonts(String fontName, int fontStyle, int fontSize) {
		Font tempFont = new Font(fontName, fontStyle, fontSize);
		if (!fonts.contains(tempFont)) {
			fonts.add(tempFont);
		}
		return fonts.get(fonts.indexOf(tempFont));
	}

}