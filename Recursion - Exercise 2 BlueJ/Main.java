/*
 * Recursion - Exercise 2
 * Alyssa Richie
 * 2/3/2022
 */
public class Main {
    public static void main(String[] args) {
        createTriangle('*', 10);
   }

   public static void createTriangle(char star, int rows)
   {
       //checks if rows isn't 1. (rows need to be one to start printing *)
       if(rows != 1)
       {
           //Recursive call happens first so no printing happens before rows = 1
           createTriangle(star, (rows - 1));
       }
       
       //Prints out 1 - rows amount of stars
       for(int printQuantity = 1; printQuantity <= rows; printQuantity++)
       {
           System.out.print(star);
       }
       
       //Breaks up the rows of stars
       System.out.println(); 
   }
}