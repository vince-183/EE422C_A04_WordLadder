/**
    WordLadderSolver
    
    Written by Jonathan Friesen and Vincent Ip
    EE422C Assignment 4
    Spring 2016
    The University of Texas at Austin
 */

package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface
{
    // declare class members here.
	private Scanner reader = null; // used to read the dictionary file to populate the dictionary.
	protected List<String> SolutionList = new ArrayList<String>(); // This is the solutionList to be returned and printed if successful
	protected List<String> dictionary = new ArrayList<String>(); // The dictionary to populate and use.
	protected List<String> checkedList = new ArrayList<String>(); // words we have checked so far
	
    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there
	/**
	 * Constructor
	 * Builds the 5-letter-word dictionary against which candidate words are checked.
	 * The dictionary is an ArrayList of Strings.
	 */
	public WordLadderSolver(String dictionaryFile)
	{
		// Populate the dictionary against which to check legality of words
		try 
      {
         reader = new Scanner(new FileInputStream(dictionaryFile));
         while (reader.hasNext())
         {
       	  dictionary.add(reader.nextLine());
         }
         reader.close();
         for (int i = 0; i < 4; i++)
         {
       	  dictionary.remove(0); // get rid of the first 4 lines of crap
         }
         for (int j = 0; j < dictionary.size(); j++)
         {
         	dictionary.set(j,(dictionary.get(j)).substring(0,5));
         }
         dictionary.removeAll(Collections.singleton(null));
      }
		catch (FileNotFoundException d)
      {
    	  System.out.println("File not found!");
      }
	}
	
	/**
	 * checkValidInput
	 * 
	 * This is a private method called ONLY by computeLadder.
	 * Checks if the startWord and endWord are legal inputs. Both words must be:
	 * 1) 5 letters long.
	 * 2) a legal dictionary word.
	 * If not, the appropriate exception is thrown.
	 * @param startWord
	 * @param endWord
	 */
	private int checkValidInput(String startWord, String endWord)
	{
		if (startWord.length() != 5 || endWord.length() != 5)
		{
			System.err.println("Invalid word length! Please use 5-letter words.");
			return 1;
		}
		else if (!(dictionary.contains(startWord)))
		{
			System.err.println("Start word is not a legal dictionary word!");
			return 2;
  	 	}
		else if (!(dictionary.contains(endWord)))
  	 	{
  	 		System.err.println("End word is not a legal dictionary word!");
  	 		return 3;
  	 	}
		else return 0;
	}
	
	/**
	 * generateTempList
	 * 
	 * This is a private method called ONLY by computeLadder. This method generates
	 * a list of words that differ from startWord by 1 letter, in a position other than the
	 * value of pos.
	 * @param startWord
	 * @param pos
	 * @return tempList - the temporary list of candidate words
	 */
	private List<String> generateTempList(String startWord, int pos)
	{
		List<String> tempList = new ArrayList<String>();
		int diffPos = 0;
      Iterator<String> dictionIter = dictionary.iterator();
      while (dictionIter.hasNext())
      {

    	  String dicTerm = dictionIter.next();
    	  int diffCounter = 0;
    	  int index = 0;
    	  while (index < 5)
    	  {
    		  // Go through the words letter-by-letter and compare the letters.
    		  // If different, increment a difference counter.
    		  if (dicTerm.charAt(index) != startWord.charAt(index))
    		  {
    			  diffCounter++;
    			  diffPos = index;
    		  }
    		  index++;
    	  }
    	  if ((diffCounter == 1) && (diffPos != pos) && !(SolutionList.contains(dicTerm)) && !(checkedList.contains(dicTerm)))
    	  {
    		  // add the candidate word to the tempList IF AND ONLY IF the the word differs from startWord by one letter
    		  // in a position different than pos, AND the current solution list does NOT contain the candidate word.
    		  tempList.add(dicTerm);
    		  tempList.set(tempList.indexOf(dicTerm), dicTerm + diffPos);
    	  }
      }
      return tempList;
	}
	
	/**
	 * computeDiff
	 * 
	 * This is a private method called ONLY by computeLadder. Computes the number
	 * of letter positions that are different between wordA and wordB.
	 * The result is an integer.
	 * @param wordA
	 * @param wordB
	 * @return int diffCounter
	 */
	private int computeDiff(String wordA, String wordB)
	{
		int diffCounter = 0;
 	  	for (int i = 0; i < 5; i++)
 	  	{
 	  		if (wordA.charAt(i) != wordB.charAt(i))
 	  		{
 	  			diffCounter++;
 	  		}
 	  	}
 	  	return diffCounter;
	}

    // do not change signature of the method implemented from the interface
    /**
     * ************************* computeLadder ******************************
     * This is a recursive implementation of a method that computes a word ladder between two legal 5-letter
     * words.
     * @param startWord	(5 letters)
     * @param endWord	(5 letters)
     * @param pos			(last letter position changed)
     * 
     * @return ArrayList<String> containing the "word ladder" that exists between startWord and endWord
     */
	@Override
    public List<String> computeLadder(String startWord, String endWord, int pos) throws NoSuchLadderException 
    {
		int errorCheck = checkValidInput(startWord, endWord); // Throw exception if input is invalid.
		if (errorCheck > 0)
			return SolutionList;
		
   	 SolutionList.add(startWord);
        if (startWord.equals(endWord)) // start Word is the same as end Word; return start Word as the solution
        {
      	  return SolutionList;
        }
        if(checkedList.contains(startWord)) // if we have already checked this word and it did not give us word ladder, return up
        {
      	  SolutionList.remove(startWord);
      	  return SolutionList;
        }
        
        // Generate tempList (list of candidate words that differ from startWord by 1 letter)
        List<String> tempList = generateTempList(startWord, pos);
        
        for (int j = 0; j < tempList.size(); j++) // Go through the tempList and find the diffCounter vs. endWord
        {
      	  // Get the NUMBER of letter positions that DIFFER from the endWord.
      	  int diffCounter = computeDiff(tempList.get(j), endWord);
      	  
      	  tempList.set(j, diffCounter + tempList.get(j)); // Prepend candidate word with the difference counter
      	  
      	  if (diffCounter == 1) // If the words are different in only ONE position, then we have found the solution!
      	  {
      		  SolutionList.add(tempList.get(j).substring(1,6));
      		  SolutionList.add(endWord);
      		  return SolutionList;
      	  }
        }
        Collections.sort(tempList); // Sort the tempList by number of letter positions DIFFERENT from endWord
        for (int j = 0; j < tempList.size(); j++) // Go through the sorted tempList and find possible word ladders for each word in the list
        {
      	  int newPos = Integer.parseInt(tempList.get(j).substring(6));
      	  tempList.set(j, tempList.get(j).substring(1,6)); // exclude the prepended and appended numbers
      	  SolutionList = computeLadder(tempList.get(j), endWord, newPos); // RECURSIVELY CALL computeLadder to find the next word in the ladder.
      	  if (SolutionList.get(SolutionList.size() - 1).equals(endWord))
      	  {
      		  return SolutionList; // If the last word is the endWord, we have found the solution!
      	  }
        }
        checkedList.add(startWord); //keep a list of words we have already seen
        SolutionList.remove(startWord);
        if (SolutionList.isEmpty()) // Throw exception IF no word ladder can be found. Program reaches here if startWord has been removed.
        {
      	  throw new NoSuchLadderException("No such ladder exists between \'" + startWord + "\' and \'" + endWord + "\'.");
        }
        return SolutionList;
    }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) 
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
