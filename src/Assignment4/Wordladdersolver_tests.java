package Assignment4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
//the purpose of this test case is to make sure invalid inputs are caught
public class Wordladdersolver_tests {
	WordLadderSolver test_wls = new WordLadderSolver("A4-words.txt");
	@Test
	   public void testGeneral(){//change start and/or end word to invalid inputs to pass the test; passes only for valid inputs
			String startWord = "bear";
			String endWord = "honey";
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
	   public void testInvalidLength(){// checking for the wrong word length; passes only for valid inputs
			String startWord = "bear";
			String endWord = "honey";
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
	   public void testInvalidStartWord(){// checking to see if the start word is not in the dictionary; passes only for valid inputs
			String startWord = "zzz2z";
			String endWord = "honey";
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
	   public void testInvalidEndWord(){// checking to see if the end word is not in the dictionary; passes only for valid inputs
			String startWord = "honey";
			String endWord = "zz1zz";
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
