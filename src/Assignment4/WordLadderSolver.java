/*
    ADD YOUR HEADER HERE
 */

package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface
{
    // declare class members here.
	private Scanner reader = null;
	protected List<String> SolutionList = new ArrayList<String>(); // This is the solutionList to be returned and printed if successful
	protected List<String> dictionary = new ArrayList<String>(); // This is the dictionary
	
    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there
	public WordLadderSolver()
	{
		// Parse and create dictionary Arraylist
		try 
      {
         reader = new Scanner(new FileInputStream("A4words.dat"));
         while (reader.hasNext())
         {
       	  dictionary.add(reader.nextLine());
         }
         reader.close();
         for (int i = 0; i < 4; i++)
         {
       	  dictionary.remove(0); // get rid of first 4 lines of crap
         }
         for (int j = 0; j < dictionary.size(); j++)
         {
         	dictionary.set(j,(dictionary.get(0)).substring(0,5));
         }
      }
		catch (FileNotFoundException d)
      {
    	  System.out.println("File not found!");
      }
	}

    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException 
    {
        SolutionList.add(startWord);
        if (startWord.equals(endWord))
        {
      	  return SolutionList;
        }
        List<String> tempList = new ArrayList<String>();
        // Search dictionary for words that differ
        return SolutionList;
    }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) 
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    // add additional methods here
}
