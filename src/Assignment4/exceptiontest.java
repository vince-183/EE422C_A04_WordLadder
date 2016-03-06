package Assignment4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
//the purpose of this test case is to make sure NoSuchLadderException is thrown properly for words with no ladders
public class exceptiontest {
	WordLadderSolver test_wls = new WordLadderSolver("A4-words.txt");
	@Test
	public void test1() {
		//enter in two words that do not have a word ladder and it will pass if NoSuchLadderException is thrown	
		String startWord = "hello";
		String endWord = "world";
		try {
			List<String> output = test_wls.computeLadder(startWord, endWord, -1);
			//fail
			fail();//did not throw the error
		} catch (NoSuchLadderException e) {
			//pass
			System.out.println(e.getMessage()); 
		}
	}
	@Test
	public void test2() {
		//enter in two words that do not have a word ladder and it will pass if NoSuchLadderException is thrown	
		String startWord = "demon";
		String endWord = "devil";
		try {
			List<String> output = test_wls.computeLadder(startWord, endWord, -1);
			//fail
			fail();//did not throw the error
		} catch (NoSuchLadderException e) {
			//pass
			System.out.println(e.getMessage()); 
		}
	}
	@Test
	public void test3() {
		//enter in two words that do not have a word ladder and it will pass if NoSuchLadderException is thrown	
		String startWord = "atlas";
		String endWord = "zebra";
		try {
			List<String> output = test_wls.computeLadder(startWord, endWord, -1);
			//fail
			fail();//did not throw the error
		} catch (NoSuchLadderException e) {
			//pass
			System.out.println(e.getMessage()); 
		}
	}
}
