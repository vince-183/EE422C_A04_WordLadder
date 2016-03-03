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
	protected List<String> dictionary = new ArrayList<String>();
	
    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there
	public WordLadderSolver()
	{
		// Populate dictionary against which to check legality of words
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
         	dictionary.set(j,(dictionary.get(j)).substring(0,5));
         }
         dictionary.removeAll(Collections.singleton(null));
      }
		catch (FileNotFoundException d)
      {
    	  System.out.println("File not found!");
      }
	}

    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord, int pos) throws NoSuchLadderException 
    {
   	 if (startWord.length() != 5 && endWord.length() != 5)
   	 {
   		 // invalid input
   	 }
   	  SolutionList.add(startWord);
        if (startWord.equals(endWord))
        {
      	  return SolutionList;
        }
        List<String> tempList = new ArrayList<String>();
        //Iterator<String> tempIter = tempList.iterator();
        // Search dictionary for words that differ from startWord by 1 letter
        int diffPos = 0;
        Iterator<String> dictionIter = dictionary.iterator();
        while (dictionIter.hasNext())
        {

      	  String dicTerm = dictionIter.next();
      	  int diffCounter = 0;
      	  int index = 0;
      	  while (index < 5 && diffCounter < 2)
      	  {
      		  if (dicTerm.charAt(index) != startWord.charAt(index))
      		  {
      			  diffCounter++;
      			  diffPos = index;
      		  }
      		  index++;
      	  }
      	  if ((diffCounter == 1) && (diffPos != pos) && !(SolutionList.contains(dicTerm)))
      	  {
      		  // add the candidate word to the tempList IF AND ONLY IF the the word differs from startWord by one letter
      		  // in a position different than pos, AND the current solution list does NOT contain the candidate word.
      		  tempList.add(dicTerm);
      		  tempList.set(tempList.indexOf(dicTerm), dicTerm + diffPos);
      	  }
        }
        for (int j = 0; j < tempList.size(); j++) // Go through the tempList and find the diffCounter vs. endWord
        {
      	  int diffCounter = 0;
           int index = 0;
      	  for (int i = 0; i < 5; i++)
      	  {
      		  if (tempList.get(j).charAt(i) != endWord.charAt(i))
         	  {
         		  diffCounter++;
         	  }
      	  }
      	  
      	  tempList.set(j, diffCounter + tempList.get(j)); // Prepend candidate word with the difference counter
      	  
      	  if (diffCounter == 1) // If the words are different in only ONE position, then we have found the solution!
      	  {
      		  SolutionList.add(tempList.get(j).substring(1,6));
      		  SolutionList.add(endWord);
      		  return SolutionList;
      	  }
        }
        Collections.sort(tempList); // Sort the tempList by number of positions DIFFERENT from endWord
        for (int j = 0; j < tempList.size(); j++)
        {
      	  int newPos = Integer.parseInt(tempList.get(j).substring(6));
      	  tempList.set(j, tempList.get(j).substring(1,6)); // exclude the prepended and appended numbers
      	  SolutionList = computeLadder(tempList.get(j), endWord, newPos);
      	  if (SolutionList.get(SolutionList.size() - 1).equals(endWord))
      	  {
      		  return SolutionList;
      	  }
        }
        //SolutionList.remove(SolutionList.indexOf(startWord));
        SolutionList.remove(startWord);
        return SolutionList;
    }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) 
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    // add additional methods here
}
