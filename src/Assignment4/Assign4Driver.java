package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Assign4Driver
{
    public static void main(String[] args)
    { 
   	 // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver();

        try 
        {
      	  // Compute a word ladder between two words if one exists
      	  List<String> result = wordLadderSolver.computeLadder("hemps","panda", -1);
      	  
      	  // Print out the word ladder if it exists
      	  Iterator<String> resultIter = result.iterator();
      	  while (resultIter.hasNext())
      	  {
      		  System.out.print(resultIter.next() + " ");
      	  }
      	  System.out.println("\nTotal words: " + result.size());
        }
        catch (NoSuchLadderException e) 
        {
            e.printStackTrace();
        }
    }
}
