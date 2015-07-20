package assignment4.wordprocessor;

import java.util.HashMap;

public class CharacterFlyweightFactory {

	private HashMap<Integer, CharacterFlyweight> Characters = new HashMap<Integer, CharacterFlyweight>();

	private static class SingletonHolder {

		private final static CharacterFlyweightFactory INSTANCE = new CharacterFlyweightFactory();
	}

	public static CharacterFlyweightFactory instance() {
		return SingletonHolder.INSTANCE;
	}

	public CharacterFlyweight getCharacter(char character) {
		if (!Characters.containsKey((int) character)) {
			Characters.put((int) character, new CharacterFlyweight(
					(int) character));
		}
		return Characters.get((int) character);

	}

}