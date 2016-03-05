package Assignment4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class test1 {

	@Test
	public void test() {
		WordLadderSolver test1 = new WordLadderSolver("A4-words.txt");
		try {
			List<String> output = test1.computeLadder("money", "honey", -1);
			assertTrue(output.contains("honey"));
		} catch (NoSuchLadderException e) {
			e.printStackTrace();
		}
	}

}
