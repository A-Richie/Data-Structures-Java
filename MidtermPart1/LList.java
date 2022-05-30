/**
* Lists - Exercise 3 - LinkedList
*
* @Alyssa Richie
* @1/16/2022
*/
//link list header
public class LList<T> implements ListInterface<T>
{
                
    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;
                
    //default constructor
    public LList()
    {
        initializeDataFields();
    }
                
    public void clear()
    {
        initializeDataFields();
    }
                
    //Add a new node method when only given an entry
    public void add(T newEntry)
    {
        Node newNode = new Node(newEntry);
                        
        if(isEmpty())
            firstNode = newNode; //Add node to end of nonempty list
        else
        {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode); //Make last node point to new node
        }
        numberOfEntries++;
    }
    
    //Add a new node method when given an entry AND a postion (can put between two nodes)
    public void add(int newPosition, T newEntry)
    {
        if((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) //check if entry is negative or over capacity
        {
            Node newNode = new Node(newEntry);
            if(newPosition == 1)
            {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
            else
            {
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            }
            numberOfEntries++;
        }
        else
        {
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }    
    }
    
    public T remove(int givenPosition)
    {
        T result = null;                                                    //Return value
        if((givenPosition >= 1) && (givenPosition <= numberOfEntries))       //Checks if position is in bounds
        {
            assert !isEmpty();
            if (givenPosition == 1)
            {
                result = firstNode.getData();            //data from the first node is put into "T"
                firstNode = firstNode.getNextNode();    //replaces what node is the first node
            }
            else
            {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData();        //get data from node to remove
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
            }
            numberOfEntries--;
            return result;
        }
        else
        {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation");
        }
    } 
    
    public T replace(int givenPosition, T newEntry)
    {
        if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            assert !isEmpty();
            Node desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        }
        else
        {
            throw new IndexOutOfBoundsException("Illegal position given to replace operation");
        }
    }   

    public T getEntry(int givenPosition)
    {
        if((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            assert !isEmpty();
            return getNodeAt(givenPosition).getData();
        }
        else
        {
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation");
        }
    }


    public boolean contains(T anEntry)
    {
	boolean found = false;
	Node currentNode = firstNode;
	while(!found && (currentNode != null))
	{
	    if(anEntry.equals(currentNode.getData()))
		found = true;
	    else
		currentNode = currentNode.getNextNode();            
	}
	return found;
    }
	
    public int getLength()
    {
            return numberOfEntries;
    }
    
    // return true or false
    public boolean isEmpty()
    {
        boolean result;
        if(numberOfEntries == 0)
        {
            assert firstNode == null;
            result = true;
        }
        else
        {
            assert firstNode != null;
            result = false;
        }
        return result;
    }
    
    
    public T[] toArray()
    {
         @SuppressWarnings("unchecked")
         T[] result = (T[])new Object[numberOfEntries];
         
         int index = 0;
         Node currentNode = firstNode;
         //adds node to created array as long as the current node is in range
         while((index < numberOfEntries) && (currentNode != null))
         {
             result[index] = currentNode.getData();
             currentNode = currentNode.getNextNode();
             index++;
         }
         return result;
    }
    
    
    
    // Initializes the class's data fields to indicate an empty list.
    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end initializeDataFields
   
    // Returns a reference to the node at a given position.
    // Precondition: The chain is not empty;
    // 1 <= givenPosition <= numberOfEntries.
    private Node getNodeAt(int givenPosition)
    {
        assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
        Node currentNode = firstNode;
        
        // Traverse the chain to locate the desired node
        // (skipped if givenPosition is 1)
        for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();
        
        assert currentNode != null;
        
        return currentNode;
    } // end getNodeAt
    
     
    
    private class Node
    {
        
        private T data;     //Entry in List "T" is generic (can be string, int, etc)
        private Node next;  //Link to next node
    
        //First constructor (for end/start)
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        
        //Second Constructor
        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }
    
        //sets private variable "data"
        private void setData(T newData)
        {
            data = newData;
        }
        
        //returns value of private variable data
        private T getData()
        {
            return data;
        }
        
        //sets private variable "data"
        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        }
        
        //returns value of private variable next
        private Node getNextNode()
        {
            return next;
        }
        
    }

 

} // end LList