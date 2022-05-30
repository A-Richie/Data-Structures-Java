import java.util.Scanner;

/**
 * Final Part 1
 * Alyssa Richie
 * Team Two's: Alyssa Richie, Alica Shi, Muhammad Reza, Nico Paganelli
 * 
 */

public class Driver
{
	public static void main(String[] args) 
	{
		UndirectedGraph<String> networkMap = new UndirectedGraph(); 
		DictionaryInterface<String, Person> network = new LinkedDictionary<>();
		boolean finished = false;
		Scanner scanObj = new Scanner(System.in);
		
		while(finished == false)
		{
			System.out.println("1. Create a profile");
			System.out.println("2. Leave the network");
			System.out.println("3. Search Profile");
			System.out.println("4. Modify Profile");
			System.out.println("5. Display list of friends");
			System.out.println("6. Exit");
			
			int userInput = scanObj.nextInt();
			/* THIS USERINPUT IS FOR CREATING A NEW PROFILE AND ADDING IT TO THE NETWORK */
			if(userInput == 1)
			{
				System.out.println("Enter a userhandle (Ex: @Cat-Lover): ");
        		String userHandle = scanObj.next();
				DataBase.createAndAdd(userHandle, network);
				//******* For Graph - create vertex *******//
				networkMap.addVertex(userHandle);
			}
			/* THIS SELECTION IS FOR REMOVING A USER FROM A NETWORK */
			else if(userInput == 2)
			{
				System.out.println("Enter a userhandle to remove");
				String userHandle = scanObj.next();
				if(DataBase.checkIsPossible(userHandle, network) == true)
				{
					network.remove(userHandle);
					//******* For Graph - remove vertex *******//
					networkMap.removeVertex(userHandle); //--> not implemented. 
					//Couldn't get disconnect method / remove edge method to work
					
				}
			}
			/* THIS SELECTION IS FOR SEARCHING PROFILES & ADDING PROFILES AS FRIENDS */
			else if(userInput == 3)
			{
				System.out.println("Specify a userhandle to search for: ");
				String userHandle = scanObj.next();
				if(DataBase.checkIsPossible(userHandle, network) == true)
				{
					System.out.println("User profile found. Do you want to add to a friend's list? 1. Yes 2. No");
					int userSelection = scanObj.nextInt();
					if(userSelection == 1)
					{
						System.out.println("What profile is adding the searched profile? Enter the userhandle: ");
						String currentUserHandle = scanObj.next();
						DataBase.addAFriend(currentUserHandle, userHandle, network);

						//******* For Graph - create edge *******//
						networkMap.addEdge(currentUserHandle, userHandle);
					}
				}
			}
			/* THIS USERINPUT IS FOR WHEN A CHANGE IN A STATUS OR NAME --Userhandle doesn't change */
			else if(userInput == 4)
			{
				System.out.println("1. Modify Status");
				System.out.println("2. Modify Name");
				System.out.println("3. Modify friend's list");
	
				int userSelection = scanObj.nextInt();
				String replacementVal;
				//Selection 1 changes the status for a specified profile
				if(userSelection == 1)
				{
					System.out.println("New Status: ");
					replacementVal = scanObj.next();
					System.out.println("Specify a userhandle to change the status: ");
					String userHandle = scanObj.next();
					if(DataBase.checkIsPossible(userHandle, network) == true)
						network.getValue(userHandle).setStatus(replacementVal);
				}
				//Selection 2 changes the username displayed for the profile
				else if(userSelection == 2)
				{
					System.out.println("New Name: ");
					replacementVal = scanObj.next();
					System.out.println("Specify a userhandle to change the name for: ");
					String userHandle = scanObj.next();
					if(DataBase.checkIsPossible(userHandle, network) == true)
						network.getValue(userHandle).setNewName(replacementVal);
				}
				//Selection 3 adds and removes friends
				else if(userSelection == 3)
				{
					System.out.println("Friend to be removed (userhandle): ");
					String removeVal = scanObj.next();
					if(DataBase.checkIsPossible(removeVal, network) == true)
					{
						System.out.println("Specify current user (who to be removed from): ");
						String currentUser = scanObj.next();
						if(DataBase.checkIsPossible(currentUser, network) == true)	
							//******* For Graph - remove Connection *******//
							networkMap.removeEdge(currentUser, removeVal);
							DataBase.removeAFriend(currentUser, removeVal, network);
							
							
					}
				}

			}
			/* THIS SELECTION IS FOR DISPLAYING ALL USERS AND THEIR FRIENDS ONLY */
			else if(userInput == 5)
			{
				System.out.println("Username : All user's friends & friend's status");
				DataBase.display(network);
				System.out.print("----Adjacency List for graph----");
				networkMap.displayEdges();
			}
			else if(userInput == 6)
			{
				finished = true;
			}
			System.out.println("*************************************************************");
		}
	}

}