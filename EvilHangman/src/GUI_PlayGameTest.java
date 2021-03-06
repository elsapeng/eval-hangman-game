
import junit.framework.TestCase;

/**
 * The class <code>GUI_PlayGameTest</code> contains tests for the class {@link
 * <code>GUI_PlayGame</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 10/6/15 2:25 PM
 *
 * @author linjie
 *
 * @version $Revision$
 */
public class GUI_PlayGameTest extends TestCase {
	GUI_PlayGame gp;
	GUI_PlayGame gp2;

	/**
	 * Construct new test instance
	 *
	 * @param name the test name
	 */
	public GUI_PlayGameTest(String name) {
		super(name);
		gp = new GUI_PlayGame(4, 16);
		gp.show();
	}

	/**
	 * Perform pre-test initialization
	 *
	 * @throws Exception
	 *
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		// Add additional set up code here
	}
	
	/**
	 * Run the void controller() method test first try
	 */
	public void testControllerFirstTry() {
		gp.inputLetter = 'a';
		gp.controller();
		assertEquals(15, gp.game.numGuessesRemaining());
		assertEquals(26, gp.game.numLettersRemaining());
		assertEquals("_ _ _ _ ", gp.game.displayGameState());
		assertEquals("A", gp.game.lettersGuessed());
		assertEquals("Nope!",gp.result.getText());
		assertEquals("Let's play Evil Hangman!", gp.label1.getText());
		assertEquals("Secret Word: _ _ _ _ ", gp.label2.getText());
		assertEquals("Guesses Remaining: 15", gp.label3.getText());
	}
	
	/**
	 * Run the void controller() method test from evil to normal
	 */
	public void testControllerFromEviltoNormal() {
		EvilHangMan evil = new EvilHangMan(4, 16);
		evil.secretWord = "BRRR";
		evil.guess = 6;
		evil.letterGuessHistory = "AEIOUTSYZL";
		evil.letterGuess = 'L';
		evil.wordlist = new String[] {"BRRR"};
		evil.numWords = 1;
		evil.secretStringLength = 4;
		gp.game = evil;
		assertTrue(gp.isEvil);
		
		gp.inputLetter = 'b';
		gp.controller();
		
		assertFalse(gp.isEvil);
		assertEquals(6, gp.game.numGuessesRemaining());
		assertEquals(1, gp.game.numLettersRemaining());
		assertEquals("B _ _ _ ", gp.game.displayGameState());
		assertEquals("AEIOUTSYZLB", gp.game.lettersGuessed());
		assertEquals("Yes!",gp.result.getText());
		assertEquals("Let's play Evil Hangman!", gp.label1.getText());
		assertEquals("Secret Word: B _ _ _ ", gp.label2.getText());
		assertEquals("Guesses Remaining: 6", gp.label3.getText());
	}
	
	/**
	 * Run the void controller() method test to win
	 */
	public void testControllerWin() {
		NormalHangMan normal = new NormalHangMan("BRRR", 6, "B");
		normal.numLettersLeft = 1;
		normal.currentState = "B _ _ _";
		gp.game = normal;
		gp.isEvil = false;
		
		gp.inputLetter = 'r';
		gp.controller();
		
		assertEquals(6, gp.game.numGuessesRemaining());
		assertEquals(0, gp.game.numLettersRemaining());
		assertEquals("B R R R ", gp.game.displayGameState());
		assertEquals("BR", gp.game.lettersGuessed());
		assertEquals("Yes!",gp.result.getText());
		assertEquals("Let's play Evil Hangman!", gp.label1.getText());
		assertEquals("Secret Word: B R R R ", gp.label2.getText());
		assertEquals("Guesses Remaining: 6", gp.label3.getText());
		
		assertTrue(gp.game.isWin());
		assertTrue(gp.game.gameOver());
		
	}
	
	
	/**
	 * Run the void controller() method test
	 */
	public void testControllerLost() {
		NormalHangMan normal = new NormalHangMan("XXXX", 6, "ABC");
		normal.guessesRemaining = 1;
		normal.numLettersLeft = 4;
		gp.game = normal;
		gp.isEvil = false;
		
		gp.inputLetter = 'd';
		gp.controller();
		
		assertEquals(0, gp.game.numGuessesRemaining());
		assertEquals(4, gp.game.numLettersRemaining());
		assertEquals("_ _ _ _ ", gp.game.displayGameState());
		assertEquals("ABCD", gp.game.lettersGuessed());
		assertEquals("Nope!",gp.result.getText());
		assertEquals("Let's play Evil Hangman!", gp.label1.getText());
		assertEquals("Secret Word: _ _ _ _ ", gp.label2.getText());
		assertEquals("Guesses Remaining: 0", gp.label3.getText());
			
		assertFalse(gp.game.isWin());
		assertTrue(gp.game.gameOver());
		
	}
}

/*$CPS$ This comment was generated by CodePro. Do not edit it.
 * patternId = com.instantiations.assist.eclipse.pattern.testCasePattern
 * strategyId = com.instantiations.assist.eclipse.pattern.testCasePattern.junitTestCase
 * additionalTestNames = 
 * assertTrue = false
 * callTestMethod = true
 * createMain = false
 * createSetUp = true
 * createTearDown = true
 * createTestFixture = false
 * createTestStubs = false
 * methods = controller()
 * package = 
 * package.sourceFolder = EvilHangman/src
 * superclassType = junit.framework.TestCase
 * testCase = GUI_PlayGameTest
 * testClassType = GUI_PlayGame
 */