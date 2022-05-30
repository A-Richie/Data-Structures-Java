
import java.io.*;
import java.util.*;

/**
 * StackSort is a program that will use two stacks to sort an array of integer values.
 * 
 * @author Charles Hoot
 * @version 4.0
 * 
 * Alyssa Richie
 * Team Two's
 * 2/12/2022
 */
public class StackSort {

    public static void main(String args[]) {

        int data[] = null;
        int result[] = null;

        Scanner input;
        input = new Scanner(System.in);

        System.out.println("This program sorts an array of integer values.");


        // Create an empty array of integers
        data = createArray(0, 1, 1);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        // Create an array with one integer
        data = createArray(1, 0, 9);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        // Create an array with two integers
        data = createArray(2, 0, 9);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        // Create an array with 10 integers
        data = createArray(10, 0, 9999);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        // Create an array with 20 integers
        data = createArray(20, 0, 9);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        System.out.println("Please enter the number of values to sort");
        int size = getInt("   It should be an integer value greater than or equal to 1.");
        // Create an array of the given size

        data = createArray(size, 0, 99);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();


    }


    /**
     * Use two stacks to sort the data in an array
     *
     * @param data An array of integer values to be sorted.
     * @return     An array of sorted integers. 
     */
    private static int[] doStackSort(int data[]) 
    {

        int result[] = new int[data.length];
        VectorStack<Integer> lowerValues = new VectorStack<>();
        VectorStack<Integer> upperValues = new VectorStack<>();
          
        //Goes through entire array
        for(int index = 0; index < data.length; index++)
        {

            //if the value on the low stack is higher than the array value move the value to uppervalue
            //  continues until the lowerStack's value is < the array value
            while(lowerValues.isEmpty() == false && lowerValues.peek() > data[index]) 
            {
                upperValues.push(lowerValues.pop());
            }
            
            //Moves the lowest value in the high stack to the lower stack
            while(upperValues.isEmpty() == false && lowerValues.isEmpty() == false && upperValues.peek() < data[index]) 
            {
                lowerValues.push(upperValues.pop());
            }

            //push the values to the lower stack
            lowerValues.push(data[index]);
        }
    
            //As long as the lowerValue isn't empty (can become empty because the array is empty)
        while(lowerValues.isEmpty() == false)
        {
            //Moves the reverse & ordered array to upperStack --> makes it become the correct sorted order for adding to array
            upperValues.push(lowerValues.pop());
        }

        //Checks the upperValues isn't empty --> because data array can be empty
        if(upperValues.isEmpty() == false)
        {
            //Goes through entire stack to move the values to the new array
            for(int index = 0; index <= data.length; index++)
            {
                if(upperValues.isEmpty() == false)
                    result[index] = upperValues.pop();
            } 
        }
        
        return result;
    }
        
    /**
     * Load an array with data values
     *
     * @param size The number of data values to generate and place in the array.
     * @param min The minimum value to generate.
     * @param max The maximum value to generate.
     * @return     An array of randomly generated integers. 
     */
    private static int[] createArray(int size, int min, int max) {

        Random generator = new Random();

        // If we get a negative size, just make the size 1
        if (size < 0) {
            size = 1;
        }
        // We need max > min for the random number generator to be happy

        if (max <= min) {
            max = min + 1;
        }

        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = min + generator.nextInt(max - min);
        }

        return data;
    }

    /**
     * Create a string with the data values from an array
     *
     * @param data An array of integer values.
     * @return A string representation of the array.
     */
    private static String representationOfArray(int data[]) {
        String result = new String("< ");
        for (int i = 0; i < data.length; i++) {
            result += data[i] + " ";
        }
        result += ">";

        return result;
    }

    /**
     * Get an integer value
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
