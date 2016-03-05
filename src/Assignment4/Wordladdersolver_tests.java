package Assignment4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
//the purpose of this test case is to make sure invalid inputs are caught
public class Wordladdersolver_tests {
	WordLadderSolver test_wls = new WordLadderSolver("A4-words.txt");
	@Test
	   public void test1(){//change start and/or end word to invalid inputs to pass the test
			String startWord = "money";
			String endWord = "12345";
			try {
				List<String> output = test_wls.computeLadder(startWord, endWord, -1);
				if(!output.isEmpty()){
					fail();
				}
			} catch (NoSuchLadderException e) {
				fail();
				System.out.println(e.getMessage()); 
			}
	   }

}
