package assignment4.wordprocessor;

import java.awt.Font;

public class Test {
	public Test() {

	}

	public static void getSizeWithoutFlyweight(final String contentStr) {
		System.out.printf(
				"The size of an Object Without flyweight is %.1f bytes%n",new SizeofUtil() {
					
					TestClass[] charArray;
					@Override
					public int create() {
						charArray = new TestClass[contentStr.length()];
						for (int i = 0; i < contentStr.length(); i++) {
							charArray[i] = new TestClass(contentStr.charAt(i),
									getFont(i));
						}
						return 1;
					}

					private Font getFont(int i) {
						if (i >= 0 && i <= 115) {
							return new Font("Times New Roman", Font.BOLD, 15);
						} else {
							return new Font("Times New Roman", Font.PLAIN, 10);
						}
					}
				}.averageBytes());
	}

	public static void getSizeWithFlyweight(final String contentStr) {
		System.out.printf(
				"The  size of an Object With flyweight is %.1f bytes%n",new SizeofUtil() {
					CharacterFlyweight[] flyWeightarray;
					CharacterFlyweightFactory characterFactory = CharacterFlyweightFactory
							.instance();
					FontFlyweightFactory fontFactory = FontFlyweightFactory
							.instance();

					@Override
					public int create() {
						RunArray test = new RunArray();

						Font fontA = fontFactory.getFonts("Times New Roman",
								Font.BOLD, 15);
						Font fontB = fontFactory.getFonts("Times New Roman",
								Font.PLAIN, 10);

						test.addRun(0, 114, fontA);
						test.addRun(115, 211, fontB);

						flyWeightarray = new CharacterFlyweight[contentStr
						                                        .length()];
						for (int i = 0; i < contentStr.length(); i++) {
							flyWeightarray[i] = characterFactory
									.getCharacter(contentStr.charAt(i));
						}
						return 1;
					}
				}.averageBytes());
	}

	public static void main(String args[]) {
		String contentStr = TextUtil.getSampleTextInfo();
		getSizeWithoutFlyweight(contentStr);
		getSizeWithFlyweight(contentStr);

	}

}
