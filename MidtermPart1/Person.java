
public class Person
{
    String name;
    String userHandle;
    String status;
    private Person next;

    // Constructor
    Person(String nameEntered)
    {
        name = nameEntered;
        status = "Online";
        next = null;
    }

    //getters

    //returns value of private variable name
    public String getName()
    {
        return name;
    }

    public String getUserHandle()
    {
        return userHandle;
    }

    //returns value of private variable name
    public String getStatus()
    {
        return status;
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
    
    public ListInterface<Person> getFriendList()
    {
        return friendList;
    }

    public void setUserHandle(String newUserHandle)
    {
        userHandle = newUserHandle;
    }

    //adds a given friend
    public void addFriend(String friend)
    {
        Person friendPerson = new Person(friend);

        if(next == null)
        {
            next = friendPerson;
        }
        else
        {
            Person newPerson = next;
            while(newPerson.next != null)
            {
                newPerson = newPerson.next;
            }
            newPerson.next = friendPerson;
        }
    }

    //remove a given friend
    public Person removeFriend(Person friend)
    {
        if(contain(friend.getName()) == true)
        {
            return friendList.remove(friend);
        }
        else
        {
            return null;
        }
    }

    //checks that there is a friend with a specific name/userhandle
    public boolean contain(String friendName)
    {
        return friendList.contains(friendName);
    }

    //clears the arraylist for the friend
    public void clearFriendList()
    {
        friendList.clear();
    }
    


}