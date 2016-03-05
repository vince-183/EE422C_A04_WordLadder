package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Assign4Driver
{
	private static Scanner reader = null;
    public static void main(String[] args)
    { 
    //create a list of word pairs from the file with the name in args[1]
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
	//pull from the 'wordpairs' list in pairs of two. if there is an uneven amount of words it will throw an exception
		String wordOne = null;
		String wordTwo = null;
		for(int k=0; k<wordPairs.size();k=k+2)
		{
	        try 
	        {
	        //create a new WordLadderSolver using args[0] as the dictionary file name
	          Assignment4Interface wordLadderSolver = new WordLadderSolver(args[0]);
	          wordOne = wordPairs.get(k);
	          wordOne = wordOne.toLowerCase();
	          wordTwo = wordPairs.get(k+1);
	          wordTwo = wordTwo.toLowerCase();
	      	  List<String> result = wordLadderSolver.computeLadder(wordOne,wordTwo, -1);// returns the word ladder solution
	          if(wordOne.equals(wordTwo)){
	        	  result.add(wordTwo);
	          }
	      	  Iterator<String> resultIter = result.iterator();
	      	  while(resultIter.hasNext()){
	      		  System.out.println(resultIter.next());
	      	  }
	        }
	        catch (NoSuchLadderException e) 
	        {
	            System.out.println(e.getMessage());    
	        }
	        catch (NullPointerException | IndexOutOfBoundsException f)
	        {
	        	System.out.println("Error: uneven number of words");
	        }
	        finally
	        {
		        System.out.println("**********");
	        }
		}
    }
}
