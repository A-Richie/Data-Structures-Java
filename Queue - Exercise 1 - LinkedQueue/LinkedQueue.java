// Queue - Exercise 1 - LinkedQueue
// Alyssa Richie
// 2/5/2022

public final class LinkedQueue<T> implements QueueInterface<T>
{
    private Node firstNode; //references front of queue
    private Node lastNode; //references back of queue

    public LinkedQueue()
    {
        firstNode = null;
        lastNode = null;
    }

    //adds a new entry to back of queue
    public void enqueue(T newEntry)
    {
        //create new node for the entry
        Node newNode = new Node(newEntry, null);
        if(isEmpty())
            //lastNode and firstNode will point to same thing when
            //there's only one entry in queue
            firstNode = newNode;
        else
            //points to next node in queue
            lastNode.setNextNode(newNode);
        lastNode = newNode;
    }
    
    //retrives the front entry
    public T getFront()
    {
        if(isEmpty())
            throw new EmptyQueueException();
        else
            return firstNode.getData();
    }
    
    //removes and returns entry at front of queue
    public T dequeue()
    {
        T front = getFront(); // getFront can throw exception
        assert firstNode != null;
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null)
            lastNode = null;

        return front;
    }

    
    //removes all entries from queue
    public void clear()
    {
        firstNode = null;
        lastNode = null;
    }


    //checks if queue is empty
    //first node and last node do not point to anything
    public boolean isEmpty()
    {
        return (firstNode == null) && (lastNode == null);
    }

class Node{
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
     } // end Node
} // end Linkedqueue