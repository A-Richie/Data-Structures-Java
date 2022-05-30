/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 * 
 * @author Charles Hoot 
 * @version 4.0
 * 
 * Lab 1
 * By: Alyssa Richie
 * Team: Team Two's (Alyssa Richie, Alica Shi, Muhammad Reza, Nico Paganelli)
 * 
 */
public class Counter
{
    private int minimum;
    private int maximum;
    private int currentValue;
    private boolean isRolledOver;

    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter()
    {
        minimum = 0;
        maximum = Integer.MAX_VALUE;
        //current value is the same as the minimum when the object is created
        currentValue = 0;
    }
    
    
    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max)
    {
        //checks that min and max values given are valid
        if(min >= max)
        {
            throw new CounterInitializationException("The minimum can't be less than maximum");
        }
        //set private data fields to given values.
        minimum = min;
        maximum = max;
        //current value is the same as the minimum when the object is created
        currentValue = minimum; 
    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    public boolean equals(Object otherObject)
    {
        boolean result = true;
        if (otherObject instanceof Counter)
        {
            //Make a counter object so I can compare the two counters
            Counter otherCounter = (Counter)otherObject;
            //Compares all the private data fields 
            if((otherCounter.value() == this.value()) 
                && (otherCounter.rolledOver() == this.rolledOver()) 
                && (otherCounter.minimum == this.minimum) 
                && (otherCounter.maximum == this.maximum))
            {
                result = true;
            }
            else
            {
                //result is false if one of the fields isn't equal.
                result = false;
            }
        }
        //include else so that if the instance isn't a counter - it's not equal (false)
        else
        {
            result = false;
        }
        return result;
    }
    
    

    /**
     * Increases the counter by one
     */
    public void increase()
    {
        currentValue++;
        //checks the value to see if a roll over is needed
        if(currentValue > maximum)
        {
            isRolledOver = true;
            currentValue = minimum;
        }
        else //else statment is to ensure boolean true isn't carried over
        {
            isRolledOver = false;
        }
    }
 
 
     /**
     * Decreases the counter by one
     */
    public void decrease()
    {
        currentValue--;
        //checks the value to see if a roll over is needed
        if(currentValue < minimum)
        {
            currentValue = maximum;
            isRolledOver = true;
        }
        else //else statment is to ensure boolean true isn't carried over
        {
            isRolledOver = false;
        }
    }
    
    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value()
    {
        //getter method. Nothing is set
        return currentValue;    
    }
    
    
    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver()
    {
        //getter method. Nothing is set.
        return isRolledOver;
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    public String toString()
    {
        //returns a string including all the private variables
        return "Counter: " + currentValue + "\nMinimum: " + minimum + 
                "\nMaximum: " + maximum + "\nRolledOver: " + isRolledOver;      
    }
 
}
