//  
//  Alyssa Richie
//  1/26/2022
//

public class LinkedBag <T> implements BagInterface<T> 
{
    
    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;
     
    
    //default constructor
    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor
    
     
    
    // Implement the unimplemented methods
    //checks if the bag is empty
    public boolean isEmpty()
    {
        return (numberOfEntries == 0);
    }
    
    //returns number of entries (the size)
    public int getCurrentSize()
    {
        return numberOfEntries;
    }
    
    public boolean add(T newEntry)
    {
        Node newNode = new Node(newEntry); //create a new node
        newNode.next = firstNode; //the new node references rest of chain
        firstNode = newNode; //new node is at start of chain
        //*note: firstNode = null if chain is empty*
        // a new entry was added- so increase number of entries
        numberOfEntries++;
        return true;
    }
    
    //Returns removed entry --> or null if uncessessful.
    //Need both T remove() and boolean remove(T anEntry) ((for the driver))
    public T remove()
    {
        T removed = null;
        //check if bag is empty
        if(firstNode != null)
        {
            numberOfEntries--;
            removed = firstNode.getData();  //puts data into removed node
            firstNode = firstNode.next; //changes pointer node to next node
        }
        return removed;
    }
    
    //return true or false if the removal for the entry was successful
    public boolean remove(T anEntry)
    {
        boolean removed = false;
        Node nodeEntryReference = getReferenceTo(anEntry);
        //check if specified entry exists in bag
        if(nodeEntryReference != null)
        {
            nodeEntryReference.data = firstNode.data; //put data to removed node
            firstNode = firstNode.next; //increase reference. Point to next node
            numberOfEntries--;
            removed = true;
        }
        //remove is automatically false if entry isn't in bag
        return removed;
    }
    
    public void clear()
    {
        while(!isEmpty())
            remove();
    }
    
    public int getFrequencyOf(T anEntry)
    {
        int frequencyOfEntry = 0;
        int whileLoopCount = 0;
        Node currentNode = firstNode; //Node acts as a pointer
        //go through all entries in bag. currentNode acts as a pointer and becomes null
        // once it reaches the end of the entries
        while((whileLoopCount < numberOfEntries) && currentNode != null)
        {
            //checks if the entry's data is equal using equals
            if(anEntry.equals(currentNode.getData()))
            {
                frequencyOfEntry++;         //increase frequency if found
            }
            whileLoopCount++;
            currentNode = currentNode.next; //increases pointer
        }
        return frequencyOfEntry;
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
    
    
    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located,
    // or null otherwise.
    private Node getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.data))
            found = true;
            else
            currentNode = currentNode.next;
        } // end while
        
        return currentNode;
    } // end getReferenceTo
    
     
    
    private class Node
    {
        private T data;     //Entry in Bag
        private Node next;  //Link to next node
    
        //First constructor (for end/start)
        public Node(T dataPortion)
        {
            this(dataPortion, null);
        }
    
        //Second Constructor
        public Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        //sets private variable "data"
        public void setData(T newData)
        {
            data = newData;
        }
    
        //returns value of private variable data
        public T getData()
        {
            return data;
        }
    
        //sets private variable "data"
        public void setNextNode(Node nextNode)
        {
            next = nextNode;
        }
    
        //returns value of private variable next
        public Node getNextNode()
        {
            return next;
        }
        
    
    }// end Node
    
}// end LinkedBag