import java.util.Iterator;
import java.util.Scanner;

/**
 * Midterm Part 1
 * Alyssa Richie
 * Team Two's: Alyssa Richie, Alica Shi, Muhammad Reza, Nico Paganelli
 * 
 */

public class DataBase
{
    public static void createAndAdd(String userHandle, DictionaryInterface<String, Person> network)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scan.next();
        Person newProfile = new Person(name);
        network.add(userHandle, newProfile);
       }
    
       //This method gets the user/person in a network from a given handle/username
    private static Person getUser(String handle, DictionaryInterface<String, Person> network) {
        if(network.contains(handle) == true)
        {
            Person foundPerson = network.getValue(handle);
            return foundPerson;
        }
        else
        {
            return null;
        }
    }
    
    static void addAFriend(String currentHandle, String friendHandle, DictionaryInterface<String, Person> network) {
        network.getValue(currentHandle).addFriend(getUser(friendHandle, network));
        network.getValue(friendHandle).addFriend(getUser(currentHandle, network));
    }

    //This method removes someone from a given/"current" person
	static void removeAFriend(String currentPerson, String friendHandle, DictionaryInterface<String, Person> network) 
	{
        network.getValue(friendHandle).removeFriend(getUser(currentPerson, network));
		network.getValue(currentPerson).removeFriend(getUser(friendHandle, network));
	}


    public static void display(DictionaryInterface<String, Person> network)
    {
        Iterator<String> keyIterator   = network.getKeyIterator();
        Iterator<Person> valueIterator = network.getValueIterator();
        
        while (keyIterator.hasNext() && valueIterator.hasNext())
            System.out.println(keyIterator.next() + " : " + valueIterator.next().toString() + "\n");
        System.out.println();
    } // end display

    
    
}