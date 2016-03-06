package Assignment4;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
		public void test1(){
			ArrayList<String> words_t = new ArrayList<String>();
			words_t.add("hello"); words_t.add("world");
			Driver(words_t);
		}
	@Test
		public void test2(){
			ArrayList<String> words_t = new ArrayList<String>();
			words_t.add("money"); words_t.add("honey");
			words_t.add("stone"); words_t.add("honey");
			words_t.add("heads"); words_t.add("tails");
			words_t.add("honey"); words_t.add("stone");
			words_t.add("money"); words_t.add("money");
			Driver(words_t);
		}
	@Test
		public void test3(){
			ArrayList<String> words_t = new ArrayList<String>();
			words_t.add("dears"); words_t.add("fears");
			words_t.add("stone"); words_t.add("money");
			words_t.add("money"); words_t.add("smart");
			words_t.add("devil"); words_t.add("angel");
			words_t.add("atlas"); words_t.add("zebra");
			words_t.add("heart"); words_t.add("heart");
			words_t.add("babes"); words_t.add("child");
			words_t.add("mumbo"); words_t.add("ghost");
			words_t.add("ryan"); words_t.add("joe");
			words_t.add("hello"); words_t.add("buddy");
			words_t.add("hello"); words_t.add("world");
			words_t.add("heads"); words_t.add("tails");
			Driver(words_t);
		}
	
	public void Driver(ArrayList<String> words) {
		File testFile = new File("black-box-testing.txt");
	      try {
			boolean x = testFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	      PrintWriter writer;
		try {
			writer = new PrintWriter("black-box-testing.txt", "UTF-8");
			Iterator<String> w_iter = words.iterator();
			while(w_iter.hasNext())
			{	
				writer.println(w_iter.next()+" "+w_iter.next());
			}
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
