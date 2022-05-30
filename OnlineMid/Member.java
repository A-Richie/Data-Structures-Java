class Member {
    private String name;
    private String status;
    private Member next;

    public Member(String enteredName) {
        name = enteredName;
        status = "Online";
        next = null;
    }

    String getName()
    {
        return name;
    }

    String getStatus()
    {
        return status;
    }

    public void setStatus(String newStatus)
    {
        status = newStatus;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    //adds a given friend
    public void addFriend(String friend)
    {
        Member friendPerson = new Member(friend);

        if(next == null)
        {
            next = friendPerson;
        }
        else
        {
            Member newPerson = next;
            while(newPerson.next != null)
            {
                newPerson = newPerson.next;
            }
            newPerson.next = friendPerson;
        }
    }

    public void displayFriends() {
        if(next == null)
        {
            System.out.println("No friends listed");
        }
        else
        {
            Member selectedMember = next;
            while(selectedMember != null)
            {
                System.out.println(selectedMember.getName());
                selectedMember = selectedMember.next;
            }
        }
    }
}