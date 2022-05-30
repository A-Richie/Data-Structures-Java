import java.util.Arrays;
/**
 * Midterm Part 1
 * Alyssa Richie
 * Team Two's: Alyssa Richie, Alica Shi, Muhammad Reza, Nico Paganelli
 * 
 */
public class AList<T> implements ListInterface<T> 
{

    private T[] list; // Array of list entries; ignore list[0]
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    
    //Constructor
    public AList()
    {
        this(DEFAULT_CAPACITY); //Call next constructor
    }
    
    //Another constructor
    public AList(int initialCapacity)
    {
        //Is initial capacity too small?
        if(initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
        else
            checkCapacity(initialCapacity);
    
        //The cast is safe because new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempList = (T[])new Object[initialCapacity + 1];
        list = tempList;
        numberOfEntries = 0;
        initialized = true;
    }
 
    //adds entry to end of list
    public void add(T newEntry)
    {
        checkInitialization();
        list[numberOfEntries + 1] = newEntry;
        numberOfEntries++;
        ensureCapacity();
    }

    //REMOVES ENTRY GIVEN AN OBJECT
    public T remove(T toRemove)
    {
        T result = null;
        //You just do a for loop for the length and if(getEntry[index].equals(entryToRemove) 
        checkInitialization();
        assert !isEmpty();
        for(int index = 1; index <= numberOfEntries; index++)
        {
            if(getEntry(index).equals(toRemove))
            {
                result = list[index]; //Get entry to remove]
                //Move subsequent entries towards entry to be removed
                //  (unless it is the last entry in the list)
                if(index < numberOfEntries)
                    removeGap(index);
                numberOfEntries--;
            }
        }
        return result;
    }
    
    //Precondition: array list has enough room for another entry
    public void add(int newPosition, T newEntry)
    {
        checkInitialization();
        if((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
        {
            if(newPosition <= numberOfEntries)
                makeRoom(newPosition);
            list[newPosition] = newEntry;
            numberOfEntries++;
            ensureCapacity();       //ensure enoguh room for next add
        }
        else
            throw new IndexOutOfBoundsException ("Given position of add's new entry is out of bounds.");
    }
    
    public T remove(int givenPosition)
    {
        checkInitialization();
        if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            assert !isEmpty();
            T result = list[givenPosition]; //Get entry to remove
            //Move subsequent entries towards entry to be removed
            //  (unless it is the last entry in the list)
            if(givenPosition < numberOfEntries)
                removeGap(givenPosition);
            numberOfEntries--;
            return result; //Return reference to removed entry
        }
        else
            throw new IndexOutOfBoundsException ("Illegal position given to remove operation");
    }
    
    public void clear()
    {
        numberOfEntries = 0;
    }
    
    public T replace(int givenPosition, T newEntry)
    {
        checkInitialization();
        if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            assert!isEmpty();
            T originalEntry = list[givenPosition];
            list[givenPosition] = newEntry;
            return originalEntry;
        }
        else
            throw new IndexOutOfBoundsException ("Illegal position given to replace operation");
    }
    
    //returns specific entry at a given position
    public T getEntry(int givenPosition)
    {
        checkInitialization();
        if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            assert!isEmpty();
            return list[givenPosition];
        }
        else
            throw new IndexOutOfBoundsException ("Illegal position given to remove operation");
    }
    
    public T[] toArray()
    {
        checkInitialization();
        
        //cast works because array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for(int index = 0; index < numberOfEntries; index++)
        {
            result[index] = list[index + 1];
        }
        return result;
    }
    
    //uses local boolean and while loop to check for a specific entry
    public boolean contains(T anEntry)
    {
        checkInitialization();
        boolean found = false;
        int index = 1;
        while(!found && (index <= numberOfEntries))
        {
            if(anEntry.equals(list[index]))
                found = true;
            index++;
        }
        return found;
    }
    
    //returns length
    public int getLength()
    {
        return numberOfEntries;
    }
    
    //Return True or False if there are no entries
    public boolean isEmpty()
    {
        return numberOfEntries == 0;        //getLength() == 0 also works
    }
    
    
    
    // Doubles the capacity of the array list if it is full.
    // Precondition: checkInitialization has been called.
    private void ensureCapacity()
    {
        int capacity = list.length - 1;
        if (numberOfEntries >= capacity)
        {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity); // Is capacity too big?
            list = Arrays.copyOf(list, newCapacity + 1);
        } // end if
    } // end ensureCapacity

    // Makes room for a new entry at newPosition.
    // Precondition: 1 <= newPosition <= numberOfEntries + 1;
    // numberOfEntries is list's length before addition;
    // checkInitialization has been called.
    private void makeRoom(int newPosition)
    {
        assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);
        
        int newIndex = newPosition;
        int lastIndex = numberOfEntries;
        
        // Move each entry to next higher index, starting at end of
        // list and continuing until the entry at newIndex is moved
        for (int index = lastIndex; index >= newIndex; index--)
        list[index + 1] = list[index];
    } // end makeRoom
    
    // Shifts entries that are beyond the entry to be removed to the
    // next lower position.
    // Precondition: 1 <= givenPosition < numberOfEntries;
    // numberOfEntries is list's length before removal;
    // checkInitialization has been called.
    private void removeGap(int givenPosition)
    {
        assert (givenPosition >= 1) && (givenPosition < numberOfEntries);
        
        int removedIndex = givenPosition;
        int lastIndex = numberOfEntries;
        
        for (int index = removedIndex; index < lastIndex; index++)
        list[index] = list[index + 1];
    } // end removeGap

    // Throws an exception if this object is not initialized.
    private void checkInitialization()
    {
    if (!initialized)
    throw new SecurityException ("AList object is not initialized properly.");
    } // end checkInitialization

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        throw new IllegalStateException("Attempt to create a list " +
        "whose capacity exceeds " +
        "allowed maximum.");
    } // end checkCapacity
}