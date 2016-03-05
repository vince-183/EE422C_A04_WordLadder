package Assignment4;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
/*the purpose of this test case is to strictly look at the outputs of main for certain inputs.
 * the test() method will create a new file so you don't have to make one called "black-box-testing"
 * if that test file already exists then it will be overwritten each time test() is run so there
 * is no need to keep editing the text file. simply input your tests into the lines below and observe
 * the output.
 */
public class blackboxtesting {

	@Test
	public void test() {
		File testFile = new File("black-box-testing.txt");
	      try {
			boolean x = testFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	      PrintWriter writer;
		try {
			writer = new PrintWriter("black-box-testing.txt", "UTF-8");
			/*
			 *  enter any number of tests below to see what the corresponding output is
			 */
			writer.println("money honey");
			writer.println("hello world");
			writer.println("twenty four");
			writer.println("money stone");
			writer.println("heads tails");
			
			
		    //writer.println("next line");
			//writer.println("next line"); 
			//etc...
		    writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String[] temp = new String[2];
		temp[0] = "A4-words.txt";
		temp[1] = "black-box-testing.txt";
		Assign4Driver test_f = new Assign4Driver(); 
		test_f.main(temp);
	}

}
