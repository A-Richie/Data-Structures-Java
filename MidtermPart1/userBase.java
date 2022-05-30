import java.util.Iterator;
import java.util.Scanner;

public class userBase
{
	public static void main(String[] args) 
	{

		DictionaryInterface<String, Person> network = new LinkedDictionary<>();
		boolean finished = false;
		Scanner scanObj = new Scanner(System.in);

		String currentUserHandle = "@Bobbie89";
		String friendHandle = "@friendHanle";
		String status = "Online";
		String personName = "Bobbie";
		String friendName = "JanFriend";
		String currentString = personName;
		

		Person aProfile = createUser(personName, status);
		Person someFriend = createUser(friendName, status);
		
		addUserToNetwork(currentUserHandle, aProfile, network);
		addUserToNetwork(friendHandle, someFriend, network);

		display(network);
		/*
		removeUserFromNetwork(currentUserHandle, aProfile, network);
		Person getPerson = getUser(currentUserHandle, network);
		System.out.print("We got the person " + getPerson);
		addFriend(friendName, friendHandle, network);
		Person removedFriend = removeFriend(currentString, friendName, network);
		System.out.print("We removed the friend " + removedFriend);



		display(network);

		*/
		
		/*
		while(finished == false)
		{
			System.out.println("Press 1, 2, 3 or 4. 1 for create a profile. 2 for print info. 3 for update an existing user information. 4 Manage Friends. 5 for closing the program");

			//Get an input from user
			int input = scanObj.nextInt();
			//This is for creating a profile
			if(input == 1)
			{
				System.out.println("\n CREATE ACCOUNT");
				System.out.println("Enter a name, status, and userhandle ");
				String name = scanObj.nextLine();
				String status = scanObj.nextLine();
				String userHandle = scanObj.nextLine();

				Person aProfile = createUser(name, status);
				addUserToNetwork(userHandle, aProfile, network);
			}
			//THIS IS FOR PRINTING INFORMATION
			else if(input == 2)
			{
				System.out.println("\n PRINT INFORMATION");
				System.out.println("Press: 1) Print name 2) Print Status 3) Print userHandle 4) Print friends");
				int printInput = scanObj.nextInt();
				printOptions(printInput);
				
			}
			//UPDATES INFORMATION NOT RELATED TO FRIENDS
			else if(input == 3)
			{
				System.out.println("\n UPDATE INFORMATION");
				System.out.println("Press: 1) Change name 2) Change Status 3) Delete account");
				int updateInput = scanObj.nextInt();
				System.out.println("Account Username / handle");
				String currentAccount = scanObj.nextLine();

				//There's three options. Change the name, status, or delete an account
				if(updateInput == 1)
				{
					System.out.println("Enter a new name: ");
					String newName = scanObj.nextLine();
					network.getValue(currentAccount).setNewName(newName);
				}
				else if(updateInput == 2)
				{
					System.out.println("Enter a new status: ");
					String newStatus = scanObj.nextLine();
					network.getValue(currentAccount).setNewName(newStatus);
				}
				else
				{
					network.remove(currentAccount);
				}
			}
			//This option is for managing friends
			else if(input == 4)
			{
				System.out.println("\n MANAGE FRIENDS");
				System.out.println("Press: 1) Add friend 2) Remove friend");
				int updateInput = scanObj.nextInt();

				//Set from the perspective of this account -- the current account
				System.out.println("Account Username / handle");
				String currentAccount = scanObj.nextLine();

				System.out.println("Friend name");
				String friendAccount = scanObj.nextLine();

				if(updateInput == 1)
				{
					//Adds it from both perspective
					addFriend(currentAccount, friendAccount, network);
					addFriend(friendAccount, currentAccount, network);
				}
				else
				{
					//Removes from both perspective
					removeFriend(currentAccount, friendAccount, network);
					removeFriend(friendAccount, currentAccount, network);
				}

			}
			else if(input == 5)
			{
				System.out.println("Closing program.");
				finished = true;
			}
			else
			{
				System.out.println("Error: you must select 1 - 5");
			} 
			*/
		}


	

	


/*
	private static void printOptions(int printInput) {

		if(printInput == 1)
		{

		}
		else if(printInput == 2)
		{

		}
		else if(printInput == 3)
		{

		}
		else if(printInput == 4)
		{

		}
		else
		{
			System.out.println("Error: input invalid");
		}

	} */







	//This method removes someone from a given/"current" person
	private static Person removeFriend(String currentPerson, String friendHandle, DictionaryInterface<String, Person> network) 
	{
		return network.getValue(currentPerson).removeFriend(getUser(friendHandle, network));
	}

	//This method adds a friend to a "current" or given person
	private static void addFriend(String currentString, String friendHandle, DictionaryInterface<String, Person> network) {
		network.getValue(currentString).addFriend(getUser(friendHandle, network));
		network.getValue(friendHandle).addFriend(getUser(currentString, network));
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

	//Creates a profile
	private static Person createUser(String userName, String status) {
		Person newPerson = new Person(userName, status);
		return newPerson;
	}

	//Adds a profile to the network
	private static void addUserToNetwork(String userHandle, Person newProfile, DictionaryInterface<String, Person> network)
	{
		network.add(userHandle, newProfile);
	}

	//Removes a profile from the network
	private static void removeUserFromNetwork(String handle, Person aProfile, DictionaryInterface<String, Person> network) {
		network.remove(handle);
	}


	public static void display(DictionaryInterface<String, Person> network)
	{
		Iterator<String> keyIterator   = network.getKeyIterator();
		Iterator<Person> valueIterator = network.getValueIterator();
		
		while (keyIterator.hasNext() && valueIterator.hasNext())
			System.out.println(keyIterator.next() + " : " + valueIterator.next());
		System.out.println();
	} // end display
}