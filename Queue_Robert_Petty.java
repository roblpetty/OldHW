// Name: Robert Petty
// Class: CS 5040
// Term: Fall 2018
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: IntelliJ


public class Queue_Robert_Petty
{
	private Node head, tail;

	//constructor method to create a list of object with head, tail, and size.
	public Queue_Robert_Petty()
	{
		head = null;
		tail = null;
	}

	//method add node to end of list
	public void enqueue(int data) 
	{
		if (tail == null) 
		 head = tail = new Node(data); //empty list
		else 
		{
		 tail.next = new Node(data); //link new node as last node
		 tail = tail.next; //make tail pointer points to last node
		}
	}
		
	//method remove first node
	public void dequeue()
	{
		if (size() == 0) 
			return; //empty list
		else
		{
			head = head.next; //head points to second node
			if (head == null)
				tail = null;
		}
	}

	//method size
	public int size()
	{
      if(head == null){
         return 0;
      } else if(head == null){
         return 1;
      } else {
         Node current = head;
         int count = 1;
         while (current != tail){
            count++;
            current = current.next;
         }
         return count;
      }
	}

	//method print front node
	public Integer front(){
		if(head != null) {
			return new Integer(head.data);
		} else {
			return null;
		}
	}

	//method print front node
	public boolean isEmpty(){
		if(head == null) {
			return true;
		} else {
			return false;
		}
	}

	//method to print out the list
	public void printList() 
	{
		Node temp;
		temp = head;
		while (temp != null)
		{
		 System.out.print(temp.data + "   ");
		 temp = temp.next;
		}
		System.out.println();
	}
	
	//class to create nodes as objects
	private class Node
	{
		private int data;	//data field
		private Node next; //link field
		
		public Node(int item) //constructor method
		{
		 data = item;
		 next = null;
		}
	}
}

