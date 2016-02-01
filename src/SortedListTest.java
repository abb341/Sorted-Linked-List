import java.util.Scanner;

/*********************************************************************************
 * 
 * Name:	Aaron Brown
 * Block:	G
 * Date:	12/2/15
 * 	
 * Program 08: Sorted List
 * Description:
 * 		A program that simulates the sorted linked list data structure
 * 
 ***********************************************************************************/
public class SortedListTest {

	private static final Scanner user = new Scanner(System.in);

	public static void main(String[] args)
	{
		SortedList list = new SortedList();

		String userInput;
		displayMenu();
		userInput = user.nextLine();
		while (!userInput.equals("q"))
		{
			System.out.println(userInput);
			doAction(list, userInput);
			userInput = user.nextLine();
		}
		System.out.println("Goodbye!");

	}

	/**
	 * Prints out a menu of options to the console
	 */
	private static void displayMenu()
	{
		System.out.println("What would you like to Do?");
		System.out.println("i = insert, r = remove, s = search, d = display, h = help, "
				+ "q = quit");
	}

	/**
	 * Perform the action specified by the user input
	 * @param list
	 * @param userInput
	 */
	private static void doAction(SortedList list, String userInput)
	{
		if (userInput.equals("i"))
		{
			// Insert
			insert(list);
		}
		else if (userInput.equals("s"))
		{
			// Search
			search(list);
		}
		else if (userInput.equals("r"))
		{
			// Remove
			remove(list);
		}
		else if (userInput.equals("d"))
		{
			// Display
			System.out.println(list);
		}
		else if (userInput.equals("h"))
		{
			// Help (display commands)
			displayMenu();
		}
	}
	
	/**
	 * Inserts a new student into the sorted list
	 * @param list -the sorted list
	 */
	private static void insert(SortedList list)
	{
		// Information About New Student
		System.out.println("Enter a new student Id");
		int id = user.nextInt();
		user.nextLine();
		System.out.println(id);
		
		System.out.println("Enter the student's name");
		String name = user.nextLine();
		System.out.println(name);
				
		// Insert new Student
		list.insert(new Student(id, name));
	}
	
	/**
	 * Searches for a student in the sorted list
	 * @param list -the sorted list
	 */
	private static void search(SortedList list)
	{
		// Search information
		System.out.println("Enter id you are looking for");
		int id = user.nextInt();
		user.nextLine();
		System.out.println(id);
		
		Object searchedStudent = list.search(new Student(id, null));
		if (searchedStudent == null)
		{
			System.out.println("Not Found");
		}
		else
		{
			System.out.println(((Student) searchedStudent).getName());
		}
	}
	
	/**
	 * removes a student from the Sorted List
	 * @param list
	 */
	private static void remove(SortedList list)
	{
		// Remove information
		System.out.println("Enter the id of the student you would like to remove");
		int id = user.nextInt();
		user.nextLine();
		System.out.println(id);
		
		Object removedStudent = list.remove(new Student(id, null));
		if (removedStudent == null)
		{
			System.out.println("Not Found");
		}
		else
		{
			System.out.println("Removed " + ((Student) removedStudent).getName());
		}
	}
	

}
