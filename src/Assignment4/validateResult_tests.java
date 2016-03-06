package Assignment4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
/*this test looks at a produced word ladder and checks to see if it is correct using validateResult()
 * these tests will pass if the word ladder produced is a correct word ladder and will fail otherwise
 */
public class validateResult_tests {

	WordLadderSolver test_vs = new WordLadderSolver("A4-words.txt");
	@Test
	public void test1() {	
		String startWord = "honey";
		String endWord = "stone";
		try {
			List<String> output = test_vs.computeLadder(startWord, endWord, -1);
			assertTrue(test_vs.validateResult(startWord, endWord, output));
		} catch (NoSuchLadderException e) {
			System.out.println(e.getMessage()); 
			fail();
		}
	}
	@Test
	public void test2() {	
		String startWord = "heads";
		String endWord = "tails";
		try {
			List<String> output = test_vs.computeLadder(startWord, endWord, -1);
			assertTrue(test_vs.validateResult(startWord, endWord, output));
		} catch (NoSuchLadderException e) {
			System.out.println(e.getMessage()); 
			fail();
		}
	}
	@Test
	public void test3() {	
		String startWord = "child";
		String endWord = "babes";
		try {
			List<String> output = test_vs.computeLadder(startWord, endWord, -1);
			assertTrue(test_vs.validateResult(startWord, endWord, output));
		} catch (NoSuchLadderException e) {
			System.out.println(e.getMessage()); 
			fail();
		}
	}

}
