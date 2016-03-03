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
   	 
   	 // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver();

        try 
        {
           reader = new Scanner(new FileInputStream("A4words.dat"));
           
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
