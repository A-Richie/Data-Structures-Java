
import java.io.*;
import java.util.*;

/**
 * Hydra is a program that will simulate the work done for a
 * computational task that can be broken down into smaller subtasks.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class Hydra {

    public static void main(String args[]) {
        BagInterface<Integer> headBag = null;
        BagInterface<String> workBag = null;

        int startingSize;

        System.out.println("Please enter the size of the initial head.");
        startingSize = getInt("   It should be an integer value greater than or equal to 1.");


        // ADD CODE HERE TO CREATE AND INITIALIZE THE TWO BAGS
        headBag = new ArrayBag<Integer>();
        headBag.add(startingSize);
        workBag = new ArrayBag<String>();

        System.out.println("The head bag is " + headBag);

        boolean noOverflow = true;

        // ADD CODE HERE TO DO THE SIMULATION
        while(headBag.getCurrentSize() > 0 && noOverflow)
        {
            noOverflow = simulationStep(headBag, workBag);
            System.out.println("The head bag is " + headBag);
            System.out.println("The work bag is " + workBag);
            System.out.println();
            
        }

        if (noOverflow) {
            System.out.println("The number of chops required is " + workBag.getCurrentSize());
        } else {
            System.out.println("Computation ended early with a bag overflow");
        }

    }

    /**
     * Take one head from the headBag bag.  If it is a final head, we are done with it.
     * Otherwise put in two heads that are one smaller.
     * Always put a chop into the work bag.
     *
     * @param  headBag   A bag holding the heads yet to be considered.
     * @param  workBag   A bag of chops.
     * 
     */
    public static boolean simulationStep(BagInterface<Integer> heads, BagInterface<String> work) {

        // COMPLETE THIS METHOD
        boolean result = true;
        
        int newSize = (heads.getCurrentSize() - 1);
        
        System.out.println("the added size is: " + newSize);
        if(newSize > 0)
        {
           heads.remove(heads.getCurrentSize());
           heads.add(newSize);
           heads.add(newSize);
           System.out.println("the added size is: " + newSize);
           work.add("chop");
        }
        else
        {
            heads.clear();
            result = false;
        }

        return result;
    }

    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt) {
        Scanner input;
        int result = 10;        //default value is 10
        try {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();

        } catch (NumberFormatException e) {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        } catch (Exception e) {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;

    }
}
