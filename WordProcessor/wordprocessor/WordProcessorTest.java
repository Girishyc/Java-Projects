package assignment4.wordprocessor;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.awt.Font;


import org.junit.Test;

public class WordProcessorTest {

	@Test
	public void computeSizeWithoutFlyweight() {
		double expectedObjectSize=32816.0; //bytes
		//double expectedObjectSize=9344.0;//bytes
		String sampleText=TextUtil.getSampleTextInfo();
		double actualObjectSize=getObjectSizeWithOutFlyweight(sampleText);
		assertTrue(expectedObjectSize==actualObjectSize);
		
	}


	@Test
	public void computeSizeWithFlyweight() {
		double expectedObjectSize=1704.0; //byts
		String sampleText=TextUtil.getSampleTextInfo();
		double actualObjectSize= getObjectSizeWithFlyweight(sampleText);
		assertTrue(expectedObjectSize==actualObjectSize);
	}

	
	@Test
	public void runArrayAddRunTest() {
		
		RunArray runArray= new RunArray();
		
		Font expectedFont=new Font("Menlo",Font.PLAIN, 23);
		
		Font fontA=new Font("Times",Font.ITALIC, 25);
		Font fontB=new Font("Menlo",Font.PLAIN, 23);
		
		runArray.addRun(0, 100, fontA);
		runArray.addRun(101, 200, fontB);
		
		Font actualFont=runArray.getFont(155);
		assertEquals(expectedFont, actualFont);
		
		actualFont=runArray.getFont(45);
		assertNotEquals(actualFont, expectedFont);
	
	}

	private double getObjectSizeWithOutFlyweight(final String sampleText) {
		return new SizeofUtil() {
			TestClass[] charArray;
			@Override
			public int create() {
				charArray = new TestClass[sampleText.length()];
				
				for (int i = 0; i < sampleText.length(); i++) {
					if(i<=114){
						charArray[i] = new TestClass(sampleText.charAt(i),new Font("Times New Roman", Font.BOLD, 15));
					}
					else{
						charArray[i] = new TestClass(sampleText.charAt(i),new Font("Times New Roman", Font.PLAIN, 10));
					}
				}
				return 1;
			}
		}.averageBytes();
	}




	private double getObjectSizeWithFlyweight(final String sampleText) {
		return new SizeofUtil() {

			CharacterFlyweight[] characterFlyweights;
			CharacterFlyweightFactory characterFactory = CharacterFlyweightFactory.instance();
			FontFlyweightFactory fontFactory = FontFlyweightFactory.instance();

			@Override
			public int create() {
				RunArray runArray= new RunArray();

				Font fontA = fontFactory.getFonts("Times New Roman", Font.BOLD, 15);
				Font fontB = fontFactory.getFonts("Times New Roman", Font.PLAIN, 10);

				runArray.addRun(0, 114, fontA);
				runArray.addRun(115, 211, fontB);
				characterFlyweights = new CharacterFlyweight[sampleText.length()];
				for (int i = 0; i < sampleText.length(); i++) {
					characterFlyweights[i] = characterFactory.getCharacter(sampleText.charAt(i));
				}
				return 1;
			}
		}.averageBytes();
	}

}
