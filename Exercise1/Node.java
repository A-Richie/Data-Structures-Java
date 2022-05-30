
/**
 * Lists - Exercise 1 - Class Node
 *
 * Alyssa Richie
 * 1/12/2022
 */
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
