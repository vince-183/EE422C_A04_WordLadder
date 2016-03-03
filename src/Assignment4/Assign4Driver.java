package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Assign4Driver
{
    public static void main(String[] args)
    {
       // Create a dictionary ArrayList
   	 
   	 // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver();

        try 
        {
           
      	  List<String> result = wordLadderSolver.computeLadder("hello","world", -1);
      	  int i = 0;
      	  int j = i - 3;
      	  System.out.printf("%d", j);
      	  //boolean correct = wordLadderSolver.validateResult("money", "honey", result);
        }
        catch (NoSuchLadderException e) 
        {
            e.printStackTrace();
        }
    }
}
