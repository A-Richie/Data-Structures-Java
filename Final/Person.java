/**
 * Final Part 1
 * Alyssa Richie
 * Team Two's: Alyssa Richie, Alica Shi, Muhammad Reza, Nico Paganelli
 * 
 */
public class Person
{
    String name;
    String status;
    ListInterface<Person> friendList = new AList<>();

    // Constructor
    Person(String nameEntered)
    {
        name = nameEntered;
        status = "Online";
        //friendList = new AList<>();
    }

    //getters

    //returns value of private variable name
    public String getName()
    {
        return name;
    }

    //returns value of private variable name
    public String getStatus()
    {
        return status;
    }

    //Return the whole list -- getter
    public ListInterface<Person> getFriendList()
    {
        return friendList;
    }

    //setters

    public void setStatus(String newStatus)
    {
        status = newStatus;
    }

    public void setNewName(String newName)
    {
        name = newName;
    }


    //adds a given friend
    public void addFriend(Person friend)
    {
        friendList.add(friend);
    }

    //remove a given friend
    public void removeFriend(Person friend)
    {
        if(((AList<Person>) friendList).contains(friend) == true)
        {
           ((AList<Person>) friendList).remove(friend);
        }
    }

    //clears the arraylist for the friend
    public void clearFriendList()
    {
        friendList.clear();
    }
    

    //ToString is for printing out the information on a person
    @Override
    public String toString() {
        String result = "\n";
        for(int index = 1; index <= friendList.getLength(); index++)
        {
            result = result + friendList.getEntry(index).getName() + " " + (friendList.getEntry(index)).getStatus() + "\n";
        }
        return result;
    }
}