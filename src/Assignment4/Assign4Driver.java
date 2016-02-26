package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Assign4Driver
{
    public static void main(String[] args)
    {
       // Create dictionary list
   	 Scanner reader = null;
   	 List<String> dictionary = new ArrayList<String>();
   	 
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
       }
 		catch (FileNotFoundException d)
       {
     	  System.out.println("File not found!");
       }
   	 
   	 
   	 // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver();

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
         	  dictionary.remove(0);
           }
      	  List<String> result = wordLadderSolver.computeLadder("money", "honey");
            boolean correct = wordLadderSolver.validateResult("money", "honey", result);
        } 
        catch (FileNotFoundException d)
        {
      	  System.out.println("File not found!");
        }
        
        catch (NoSuchLadderException e) 
        {
            e.printStackTrace();
        }
    }
}
