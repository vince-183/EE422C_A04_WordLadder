package Assignment4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class exceptiontest {

	@Test
	public void test() {
		WordLadderSolver test1 = new WordLadderSolver("A4-words.txt");
		NoSuchLadderException test2 = new NoSuchLadderException(null);
		String startWord = "hello";
		String endWord = "world";
		try {
			List<String> output = test1.computeLadder(startWord, endWord, -1);
		} catch (NoSuchLadderException e) {
			 System.out.println(e.getMessage());
			 
		}
	}
}
