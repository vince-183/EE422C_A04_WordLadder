package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Assign4Driver
{
    public static void main(String[] args)
    { 
     // Create a dictionary  and word pairs ArrayList
   	 // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver(args[0]);
     // get an array of word pairs
        List<String> wordPairs = new ArrayList<String>();
		try 
	      {
	         reader = new Scanner(new FileInputStream(args[1]));
	         while (reader.hasNext())
	         {
	       	  wordPairs.add(reader.next());
	         }
	         reader.close();
	         
	        wordPairs.removeAll(Collections.singleton(null));
	      }
			catch (FileNotFoundException d)
	      {
	    	  System.out.println("File not found!");
	      }
		//
		String wordOne = null;
		String wordTwo = null;
		for(int k=0; k<wordPairs.size();k=k+2)
		{
	        try 
	        {
	          wordOne = wordPairs.get(k);
	          wordTwo = wordPairs.get(k+1);
	      	  List<String> result = wordLadderSolver.computeLadder(wordOne,wordTwo, -1);
	      	  Iterator<String> resultIter = result.iterator();
	      	  while(resultIter.hasNext()){
	      		  System.out.print(resultIter.next() + " ");
	      	  }
	      	  System.out.println("\n\n**********\n");
	        }
	        catch (NoSuchLadderException e) 
	        {
	            e.printStackTrace();
	        }
	        catch (NullPointerException f)
	        {
	        	System.err.println("Error: uneven number of words");
	        }
	        catch (ArrayIndexOutOfBoundsException g)
	        {
	        	System.err.println("Error: uneven number of words");
	        }
		}
    }
}
