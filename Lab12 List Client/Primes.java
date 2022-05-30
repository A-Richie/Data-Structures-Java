import java.io.*;
import java.util.*;

/**
 * 
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
 * @version 4.0
 * 
 * Lab12 List Client
 * Alyssa Richie
 * Team: Team Two's (Alyssa Richie, Alica Shi, Muhammad Reza, Nico Paganelli)
 * 
 */    
public class Primes
{

    public static void main(String args[])
    {
        //Declare all lists
        ListInterface<Integer> candidates = null;
        ListInterface<Integer> primes = null;
        ListInterface<Integer> composites = null;
        int max;
        int primeDiscovered; 
        
        System.out.println("Please enter the maximum value to test for primality");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        
        //Initialize lists
        candidates = new AList<Integer>();
        primes = new AList<Integer>();
        composites = new AList<Integer>();
        
        //Add to candiates list 2 - max (userInput)
        for(int index = 2; index <= max; index++)
        {
            candidates.add(index);
        }
        
        //prints out candidates list
        System.out.println("Candidates: " + candidates);
        
        //Does the same steps several times to get candidates list empty
        while(candidates.getLength() != 0)
        {
            //Takes the first element from candidates (known to be prime) and adds it to the list and variable
            primeDiscovered = candidates.remove(1);
            System.out.println("The disvovered prime = " + primeDiscovered);
            primes.add(primeDiscovered);
            
            //uses the known to be prime number to compare it against possible composite numbers
            getComposites(candidates, composites, primeDiscovered);
            
            //prints out the list
            System.out.println("Candidates: " + candidates);
            System.out.println("Primes: " + primes);
            System.out.println("Composites: " + composites);
        }
    }
    
    
    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
    {
        //lists start at index 1
        for(int index = 1; index <= candidates.getLength(); index++)
        {
            //If a number is divisible by another number, it isn't prime.
            //  --> adds it to the composite list and removes it from the candidates list
            if(candidates.getEntry(index) % prime == 0)
            {
                composites.add(candidates.getEntry(index));
                candidates.remove(index);
            }
        }
    }
    
    
    
    
    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }    
    
}
