
import java.util.Scanner;  // Import the Scanner class

//  Queue & Stack - Exercise - Palindrome
//  Alyssa Richie
//  2/8/2022

public class palindrome
{
    public static void main(String[] args) 
	{
        //creates both queue, stack and sanner object
        QueueInterface<Character> myQueue = new LinkedQueue<>();
        StackInterface<Character> myStack = new LinkedStack<>();
        Scanner scanObj = new Scanner(System.in);

        //Variables
            //Get an input from user
        String input = scanObj.nextLine();
            //Forces the string / input from user to be lowercase (Ex: Madam is palindrome)
        String lowerCaseInput = input.toLowerCase();
            //boolean for checking if palindrome. Don't want double outputs
        boolean isPalindrome = false;
        Character addCharacter;
        

        //For loop for input from the string the user wrote
        for(int inputIndex = 0; inputIndex < lowerCaseInput.length(); inputIndex++)
        {
            //Gets one character from the string
            addCharacter = lowerCaseInput.charAt(inputIndex);
            //Add character to both queue and stack
            myQueue.enqueue(addCharacter);
            myStack.push(addCharacter);
        }
        
        //Checks that the stack isn't empty & queue isn't empty first (Only one really needs to be checked)
        //  Removes from the "top" from the stack and from the "front" for the queue. Makes the comparison directly
        //      the loop stops if one character isn't the same or the queue/stack is empty
        while((myStack.isEmpty() == false && myQueue.isEmpty() == false) && myStack.pop() == myQueue.dequeue())
        {
            //Makes sure the next pop / dequeue is the last one before making an output
            if(myStack.isEmpty() && myQueue.isEmpty())
            {
                //boolean is true so there won't be conflicting outputs
                isPalindrome = true;
                System.out.print(input + " is a palindrome");
            }
        } 

        //The while loop indicates if isPalindrome is true or false
        if(isPalindrome == false)
            System.out.print(input + " is NOT a palindrome");
    }
}