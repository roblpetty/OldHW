// Name: Robert Petty
// Class: CS 5040
// Term: Fall 2018
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: IntelliJ

import java.util.Scanner;

public class TestQueue_Robert_Petty
{
	public static void main (String[] args)
	{
		Queue_Robert_Petty myList = new Queue_Robert_Petty(); //create a list object

		//Write code to test each completed method in class LinkedList
		boolean exit = false;
		Scanner input = new Scanner(System.in);
		int data = 0;
		int index = 0;
		while (!exit){// loop to repeat prompt until exit chosen
			System.out.println("\nEnter letter to choose option:\n"+
									"A. Print Queue\n"+
									"B. Enqueue\n"+
									"C. Dequeue\n"+
									"D. Print Queue Size\n"+
									"E. Print Front Node\n"+
									"F. Check if Queue is empty\n"+
									"X. Exit program");

			char choice = input.nextLine().charAt(0); //get user input
			
			choice = Character.toUpperCase(choice); //force to uppercase
			switch (choice){ // select function and output based on user input
				case 'A':
					System.out.println("Current values in queue:");
					myList.printList();
					break;
				case 'B':
					System.out.println("Enter value to be enqueued:  ");
					try{data = Integer.parseInt(input.nextLine());}
				    catch(Exception e){
						System.out.print("Operation failed: Must be integer\n");
						break;
				    }
					myList.enqueue(data);
					System.out.println("Queue after enqueuing:");
					myList.printList();
					break;
				case 'C':
					myList.dequeue();
					System.out.println("Queue after dequeuing");
					myList.printList();
					break;
				case 'D':
					System.out.println("Queue size is: " + myList.size());
					break;
				case 'E':
					System.out.println("Front Node is: " + myList.front());
					break;
				case 'F':
					System.out.println("Queue empty?: " + myList.isEmpty());
					break;
				case 'X':
					exit = true;
               break;
				default:
					System.out.println("Invalid selection! Try again."); 
               break;
			}
		}
	}
}

