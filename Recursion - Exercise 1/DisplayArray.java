//
// Recursion - Excersise 1
// Alyssa Richie                
//


public class DisplayArray 
{
    private int array[]= {25,96,87,41};
    public static void main(String[] args)
    {
       DisplayArray da = new DisplayArray();
    
       da.displayArrayRecursively(0,da.array.length-1);
       System.out.println();
       da.displayArrayWithStack(0,da.array.length-1);
    }
    
    //Recursively display an array from the middle
    public void displayArrayRecursively(int first, int last)
    {
        if(first == last)
            System.out.println(array[first] + " ");
        else
        {
            int mid = (first + last) / 2; //calcuation of midpoint
            displayArrayRecursively(first, mid);
            displayArrayRecursively(mid + 1, last);
        } 
    }
    
    //display an array using the stack
    public void displayArrayWithStack(int first, int last)
    {
        boolean done = false;
        StackInterface<Record> programStack = new LinkedStack<Record>();
        programStack.push(new Record(first, last));
        while(!done && !programStack.isEmpty())
        {
            Record topRecord = programStack.pop();
            first = topRecord.first;
            last = topRecord.last;
            
            if(first == last)
                System.out.println(array[first] + " ");
            else
            {
                int mid = first + (last - first) / 2;
                programStack.push(new Record(mid + 1, last));
                programStack.push(new Record(first, mid));
            }
        }
    }
    
    private class Record
    {
        private int first, last;
        private Record(int firstIndex, int lastIndex)
       {
          first = firstIndex;
          last = lastIndex;
       } // end constructor
    } // end Record
}