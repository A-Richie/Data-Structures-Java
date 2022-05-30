//
//Stacks - Excersise 1 - Linked Stack
// Alyssa Richie                
//

public final class LinkedStack<T> implements StackInterface<T>
{

    private Node topNode; // References the first node in the chain
    
    //default constructor
    
    LinkedStack()
    {
        topNode = null;
    }
    
    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }
    
    //checks top of stack to see if it's empty
    public T peek()
    {
        if(isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    }
    
    public T pop()
    {
        T top = peek(); // might throw emptyStackException
        assert topNode != null;
        topNode = topNode.getNextNode();
        return top;
    }
    
    public boolean isEmpty()
    {
        //checks if the topNode is null
        return topNode == null;
    }
    
    public void clear()
    {
        //topNode points to nothing. Garbage collector deletes nodes
        topNode = null;
    }
     
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
        
    }// end Node
}// end LinkedStack